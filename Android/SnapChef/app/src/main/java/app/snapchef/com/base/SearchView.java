package app.snapchef.com.base;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import android.os.AsyncTask;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//TODO: Add camera button
public class SearchView extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner sortBy, filter;
    private ImageButton backBtn, cameraBtn;
    private Button viewRecipeBtn;
    private Intent intent;
    TextView responseView;
    static final String API_URL = "https://1y81ltee41.execute-api.us-east-1.amazonaws.com/default/BackendLambda";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search_view);

        sortBy = findViewById(R.id.sortBySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sort_by,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortBy.setAdapter(adapter);
        sortBy.setOnItemSelectedListener(this);

        filter = findViewById(R.id.filterSpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.filter,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filter.setAdapter(adapter2);
        filter.setOnItemSelectedListener(this);

        //opens device camera
        cameraBtn = (ImageButton) findViewById(R.id.cameraButton);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });

        backBtn = (ImageButton) findViewById(R.id.backButtonSearch);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        viewRecipeBtn = (Button) findViewById(R.id.goToViewRecipeButton);
        viewRecipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               intent =  new Intent(getApplicationContext(), ViewRecipeView.class);
               startActivity(intent);
            }
        });



//        Button apiButton = (Button) findViewById(R.id.apiButton);
//        apiButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                new RetrieveFeedTask().execute();
//            }
//        });
    }
//
//    class RetrieveFeedTask extends AsyncTask<Void, Void, String> {
//        private Exception exception;
//
//        protected void onPreExecute() {
//            responseView.setText("");
//        }
//
//        protected String doInBackground(Void... urls) {
//            try {
//                URL url = new URL(API_URL);
//                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//                try {
//                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//                    StringBuilder stringBuilder = new StringBuilder();
//                    String line;
//                    while ((line = bufferedReader.readLine()) != null) {
//                        stringBuilder.append(line).append("\n");
//                    }
//                    bufferedReader.close();
//                    return stringBuilder.toString();
//                } finally {
//                    urlConnection.disconnect();
//                }
//            } catch (Exception e) {
//                Log.e("ERROR", e.getMessage(), e);
//                return null;
//            }
//        }
//    }
//
//    protected void onPostExecute(String response){
//        if(response == null){
//            response = "THERE WAS AN ERROR";
//        }
//
//        Log.i("INFO",response);
//        responseView.setText(response);
//    }





    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.sortBySpinner){
            if (adapterView.getItemAtPosition(i).equals("Sort By")){
                //don't do anything
            }
            else{
                String text = adapterView.getItemAtPosition(i).toString();
            }
        }
        else if (adapterView.getId() == R.id.filterSpinner){
            if (adapterView.getItemAtPosition(i).equals("Filter")){
                //don't do anything
            }
            else{
                String text = adapterView.getItemAtPosition(i).toString();
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
