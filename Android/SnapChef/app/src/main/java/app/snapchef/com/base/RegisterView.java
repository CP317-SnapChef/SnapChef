package app.snapchef.com.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class RegisterView extends AppCompatActivity {
    //TODO: Add "Privacy Policy" like in LoginView

    private ImageButton backBtn;
    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);
        //press to go to home screen
        Button mEmailSignUpButton = (Button) findViewById(R.id.registerButton);
        mEmailSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),HomeView.class);
                startActivity(intent);
            }
        });

        //go back to login screen if back button is pressed
        backBtn = (ImageButton) findViewById(R.id.backButtonAccount);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
