//written by Jun Cao, Erman Dinsel, Stuart Isley

package app.snapchef.com.base;

import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateRecipeView extends AppCompatActivity {
    //TODO: Literally this entire View lol
    //TODO: Remove the nav bar at the bottom after the back button is created at the top
    private ImageButton backBtn, cameraBtn;
    private Button uploadBtn;
    private Intent intent;
    private static final String TAG = "CreateRecipeView";
    private EditText recipeName, recipeIngredients, recipeInstructions;
    private Recipe recipeObj;
    public static Recipe savedRecipes[] = new Recipe[100];
    public static String savedRecipeNames[] = {"", "", "", "",""};
    private ImageView img;
    public static ArrayList<Bitmap> pics = new ArrayList<Bitmap>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);

        recipeObj = new Recipe("","","","");
        recipeObj.setRating("0.0");
        recipeName = (EditText)findViewById(R.id.recipeNameTextField);
        recipeIngredients = (EditText)findViewById(R.id.ingredientsTextField);
        recipeInstructions = (EditText)findViewById(R.id.instructionsTextField);
        img = (ImageView)findViewById(R.id.tempFoodImageCreateRecipe);

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
                recipeObj.setRecipeName(recipeName.getText().toString());
                recipeObj.setInstructions(recipeInstructions.getText().toString());
                recipeObj.setIngredients(recipeIngredients.getText().toString());
                savedRecipes[HomeView.index] = recipeObj;
                savedRecipeNames[HomeView.index] = recipeObj.getRecipeName();
                HomeView.index++;
                Toast toast = Toast.makeText(getApplicationContext(), "Recipe uploaded", Toast.LENGTH_SHORT);
                toast.show();
                intent = new Intent(getApplicationContext(),HomeView.class);
                startActivity(intent);
            }
        });
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0)
        {
            if(data != null)
            {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                pics.add(photo);
                photo = Bitmap.createScaledBitmap(photo, 80, 80, false);
                img.setImageBitmap(photo);
            }
            else{
            }
        }
    }




}
