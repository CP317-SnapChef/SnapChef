//written by Jun Cao, Erman Dinsel, Stuart Isley

package app.snapchef.com.base;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeView extends AppCompatActivity {


    private ImageButton searchBtn, createRecipeBtn, reportBtn, accountBtn;
    private Button viewButton, viewButton2, viewButton3;
    private Intent intent;
    private apiTESTActivity.RetrieveFeedTask refresh;
    public static int chooseRecipe = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_view);




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

//        viewButton = (Button)findViewById(R.id.viewRecipe);
//        //viewButton.setText(apiTESTActivity.recipeList[0].getRecipeName());
//        viewButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chooseRecipe = 0;
//                intent = new Intent(getApplicationContext(),ViewRecipeView.class);
//                startActivity(intent);
//            }
//        });
//
//        viewButton2 = (Button)findViewById(R.id.viewRecipe2);
//        //viewButton.setText(apiTESTActivity.recipeList[0].getRecipeName());
//        viewButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chooseRecipe = 1;
//                intent = new Intent(getApplicationContext(),ViewRecipeView.class);
//                startActivity(intent);
//            }
//        });
//
//        viewButton3 = (Button)findViewById(R.id.viewRecipe3);
//        //viewButton.setText(apiTESTActivity.recipeList[0].getRecipeName());
//        viewButton3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chooseRecipe = 2;
//                intent = new Intent(getApplicationContext(),ViewRecipeView.class);
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public void onBackPressed() {
        //Nothing happens so it doesn't go back to login view.
        //User needs to press the logout button to logout
    }


}
