package app.snapchef.com.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.snapchef.com.base.R;

public class AccountView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_view);
        getSupportActionBar().setTitle("Account");
    }
}
