package app.snapchef.com.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class CreateRecipeView extends AppCompatActivity {
    private static final String TAG = "CreateRecipeView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);



        Log.d(TAG, "onCreate: Starting");

        Button toHomeScreen = (Button) findViewById(R.id.HomeButton);
        toHomeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnIntent = new Intent(CreateRecipeView.this,HomeView.class);
                startActivity(btnIntent);
            }
        });

        
    }


}
