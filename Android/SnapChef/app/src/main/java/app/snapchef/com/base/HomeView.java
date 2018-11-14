package app.snapchef.com.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class HomeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_view);

        Button  goToAccBtn = (Button) findViewById(R.id.goToAccBtn);
        goToAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent to go to account view
                Intent accountIntent = new Intent(getApplicationContext(), AccountView.class);
                startActivity(accountIntent);
            }
            });
    }
}
