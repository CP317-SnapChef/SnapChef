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
    private Intent intent;
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
                intent = new Intent(getApplicationContext(), ViewRecipeView.class);
                startActivity(intent);
            }
        });

        reportBtn = (ImageButton)findViewById(R.id.reportButton);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), ReportRecipeView.class);
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


}
