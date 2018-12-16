package app.snapchef.com.base;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import android.os.AsyncTask;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//TODO: Add camera button
public class SearchView extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public String ingredient;
    private Spinner sortBy, filter;
    private ImageButton backBtn, cameraBtn;
    private Intent intent;
    TextView responseView;
    public static final String API_URL = "https://hen5wqy033.execute-api.us-east-2.amazonaws.com/default/SnapChefDBConnection?operation=getRecipes&ingredient=CHANGE;";
    public static String url = API_URL;
    MaterialSearchView searchView;
    ListView lstView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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
                intent = new Intent(getApplicationContext(),HomeView.class);
                startActivity(intent);
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("                           Search All Recipes");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        lstView = (ListView)findViewById(R.id.listView);
        ArrayAdapter adapter3 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,apiTESTActivity.names);
        lstView.setAdapter(adapter3);

        searchView = (MaterialSearchView)findViewById(R.id.search_view);
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
               lstView = (ListView)findViewById(R.id.listView);
               ArrayAdapter adapter3 = new ArrayAdapter(SearchView.this,android.R.layout.simple_list_item_1,apiTESTActivity.names);
               lstView.setAdapter(adapter3);
            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != null && !query.isEmpty()) {
                    url = API_URL.replace("CHANGE", query.toLowerCase());
                    apiTESTActivity.chooseView = 1;
                    Intent i = new Intent(getApplicationContext(), apiTESTActivity.class);
                    startActivity(i);
                    overridePendingTransition(0,0);
                    List<String> lstFound = new ArrayList<String>();

                    int ind = 0;
                    for(String item:apiTESTActivity.ingredients_){
                        if(item.contains(query)){
                            lstFound.add(apiTESTActivity.names[ind]);
                        }
                        ind++;
                    }
                    ArrayAdapter adapter3 = new ArrayAdapter(SearchView.this,android.R.layout.simple_list_item_1,lstFound);
                    lstView.setAdapter(adapter3);
                }
                else{
                    ArrayAdapter adapter3 = new ArrayAdapter(SearchView.this,android.R.layout.simple_list_item_1,apiTESTActivity.names);
                    lstView.setAdapter(adapter3);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                if (newText != null && !newText.isEmpty()){
//                    List<String> lstFound = new ArrayList<String>();
//                    for(String item:names){
//                        if(item.contains(newText)){
//                            lstFound.add(item);
//                        }
//                    }
//                    ArrayAdapter adapter3 = new ArrayAdapter(SearchView.this,android.R.layout.simple_list_item_1,lstFound);
//                    lstView.setAdapter(adapter3);
//                }
//                else{
//                    ArrayAdapter adapter3 = new ArrayAdapter(SearchView.this,android.R.layout.simple_list_item_1,names);
//                    lstView.setAdapter(adapter3);
//                }
                return true;
            }
        });

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for(int j = 0; j < apiTESTActivity.names.length; j++){
                    if (i == j) {
                        HomeView.chooseRecipe = j;
                        intent = new Intent(SearchView.this, ViewRecipeView.class);
                        startActivity(intent);
                    }
                }
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

    public String getIngredient() {
        return this.ingredient;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }


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

    @Override
    public void onBackPressed() {
        intent = new Intent(getApplicationContext(),HomeView.class);
        startActivity(intent);
    }


}