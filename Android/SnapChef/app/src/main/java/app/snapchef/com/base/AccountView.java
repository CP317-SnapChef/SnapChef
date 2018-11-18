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

import app.snapchef.com.base.R;

public class AccountView extends AppCompatActivity {
private ImageButton backBtn;
private Button logout;
private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_account_view);
       // getSupportActionBar().setTitle("Account");

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        bottomNav.getMenu().getItem(0).setChecked(true);

        //go back to login screen if logout button is pressed
        logout = (Button) findViewById(R.id.logOutButton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent =  new Intent(getApplicationContext(), LoginView.class);
                startActivity(intent);
            }
        });
        //go back to home screen if back button is pressed
        backBtn = (ImageButton) findViewById(R.id.backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent =  new Intent(getApplicationContext(), HomeView.class);
                startActivity(intent);
            }
        });
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             intent = null;
            switch (item.getItemId()) {
                case R.id.navigation_account:
                    intent = new Intent(getApplicationContext(), AccountView.class);
                    break;

                case R.id.navigation_home:
                    intent  = new Intent(getApplicationContext(), HomeView.class);
                    break;

                case R.id.navigation_search:
                    // intent = new Intent(getApplicationContext(), .class);
                    break;

                case R.id.navigation_add:
                    intent = new Intent(getApplicationContext(), CreateRecipeView.class);
                    break;


                case R.id.navigation_text_search:
                    // intent = new Intent(getApplicationContext(), .class);
                    break;
            }

            startActivity(intent);
            return true;
        }
    };
}
