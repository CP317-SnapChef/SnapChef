//written by Jun Cao, Erman Dinsel, Stuart Isley

package app.snapchef.com.base;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CreateRecipeView extends AppCompatActivity {
    //TODO: Literally this entire View lol
    //TODO: Remove the nav bar at the bottom after the back button is created at the top
    private ImageButton backBtn, cameraBtn;
    private Button uploadBtn;
    private Intent intent;
    private static final String TAG = "CreateRecipeView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);


        //go back to home screen if back button is pressed
        backBtn = (ImageButton) findViewById(R.id.backButtonCreateRecipe);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        cameraBtn = (ImageButton) findViewById(R.id.uploadImageButton);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //open camera or gallery
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });

        uploadBtn = (Button) findViewById(R.id.uploadButton);
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //upload recipe
            }
        });
        
    }




}
