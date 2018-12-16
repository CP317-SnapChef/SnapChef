package app.snapchef.com.base;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import app.snapchef.com.base.R;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class apiTESTActivity extends AppCompatActivity {
    public static Recipe recipeobj;
    public static Recipe recipeList[];
     TextView responseView;
     ProgressBar progressBar;
    static final String API_URL = "https://1y81ltee41.execute-api.us-east-1.amazonaws.com/default/BackendLambda";
    private RequestQueue mQueue;
    public static String names[] = {""};
    public static String ingredients_[] = {""};
    public static int chooseView;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_test);

        //responseView = (TextView) findViewById(R.id.responseView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //Button queryButton = (Button) findViewById(R.id.queryButton);
       // queryButton.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {

        new RetrieveFeedTask().execute();
           // }
        //});

        mQueue = Volley.newRequestQueue(this);

        if (chooseView == 0){
            Intent intent = new Intent(getApplicationContext(), HomeView.class);
            startActivity(intent);
        }
        handler=new Handler();
        Runnable r=new Runnable() {
            public void run() {

                if (chooseView == 1) {
                    Intent intent = new Intent(getApplicationContext(), SearchView.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                }
            }
        };
        handler.postDelayed(r, 1500);

    }


    private void jsonParse() {
        //responseView.setText(SearchView.url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, SearchView.url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("recipes");
                            recipeList = new Recipe[jsonArray.length()];
                            ingredients_ = new String[recipeList.length];
                            names = new String[recipeList.length];
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject recipe = jsonArray.getJSONObject(i);

                                String recipeName = recipe.getString("recipe");
                                String rating = recipe.getString("rating");
                                String ingredients = recipe.getString("ingredients");
                                String instructions = recipe.getString("instructions");

                                recipeobj = new Recipe("", "", "","");
                                recipeobj.setRecipeName(recipeName);
                                recipeobj.setRating(rating);
                                recipeobj.setIngredients(ingredients);
                                recipeobj.setInstructions(instructions);

                                recipeList[i] = recipeobj;
                                names[i] = recipeList[i].getRecipeName();
                                ingredients_[i] = recipeList[i].getIngredients();

                                //responseView.append(recipeName + ", " + rating + ", " + ingredients + ", " + instructions + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseView.append("oof");
                error.printStackTrace();
            }

        });
        mQueue.add(request);
    }

    class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

        private Exception exception;

        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
//            responseView.setText("");
        }

        protected String doInBackground(Void... urls) {

            try {
                URL url = new URL(API_URL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {
            if (response == null) {
                response = "THERE WAS AN ERROR";
            }
            progressBar.setVisibility(View.GONE);
            //Log.i("INFO", response);
            //responseView.setText(response);
            // TODO: check this.exception
            // TODO: do something with the feed

            jsonParse();


//            try {
//                JSONObject object = (JSONObject) new JSONTokener(response).nextValue();
//                String requestID = object.getString("requestId");
//                int likelihood = object.getInt("likelihood");
//                JSONArray photos = object.getJSONArray("photos");
//                .
//                .
//                .
//                .
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
        }
    }
}