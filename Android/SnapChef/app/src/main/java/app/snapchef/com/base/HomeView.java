package app.snapchef.com.base;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class HomeView extends AppCompatActivity {


    private ImageButton searchBtn, createRecipeBtn, reportBtn, accountBtn;
    private Intent intent;
    private apiTESTActivity.RetrieveFeedTask refresh;
    public static int chooseRecipe = 0;
    ListView lstView;
    public static int index = 0;
    public static int chooseView = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_view);


        lstView = (ListView)findViewById(R.id.listView2);
        ArrayAdapter adapter3 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,CreateRecipeView.savedRecipeNames);
        lstView.setAdapter(adapter3);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for(int j = 0; j < index; j++){
                    if (i == j) {
                        chooseView = 0;
                        HomeView.chooseRecipe = j;
                        intent = new Intent(getApplicationContext(), ViewRecipeView.class);
                        startActivity(intent);
                    }
                }
            }
        });


        searchBtn = (ImageButton)findViewById(R.id.searchButton);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 intent = new Intent(getApplicationContext(), SearchView.class);
                 startActivity(intent);
            }
        });

        createRecipeBtn = (ImageButton)findViewById(R.id.createRecipeButton);
        createRecipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), CreateRecipeView.class);
                startActivity(intent);
            }
        });

        reportBtn = (ImageButton)findViewById(R.id.reportButton);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), ReportErrorView.class);
                startActivity(intent);
            }
        });

        accountBtn = (ImageButton)findViewById(R.id.accountButton);
        accountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), AccountView.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        //Nothing happens so it doesn't go back to login view.
        //User needs to press the logout button to logout
    }


}
