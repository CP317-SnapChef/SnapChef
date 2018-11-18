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

}
