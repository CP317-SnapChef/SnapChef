//written by Jun Cao, Erman Dinsel, Stuart Isley

package app.snapchef.com.base;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import static app.snapchef.com.base.apiTESTActivity.recipeList;

public class ViewRecipeView extends AppCompatActivity {
    //TODO: Again... literally this entire view, but it should be similar to CreateRecipeView

    private ImageButton backBtn;
    private Button reportBtn;
    private Intent intent;
    private TextView tv1;
    private RatingBar rate;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);

        if (HomeView.chooseView == 0){
            tv1 = (TextView)findViewById(R.id.foodTitleTemp);
            tv1.setText(CreateRecipeView.savedRecipes[HomeView.chooseRecipe].getRecipeName());
            rate = (RatingBar) findViewById(R.id.ratingBar);
            rate.setRating(Float.parseFloat(CreateRecipeView.savedRecipes[HomeView.chooseRecipe].getRating()));
            tv1 = (TextView)findViewById(R.id.foodIngredientsTemp);
            tv1.setText(CreateRecipeView.savedRecipes[HomeView.chooseRecipe].getIngredients());
            tv1 = (TextView)findViewById(R.id.foodInstructionsTemp);
            tv1.setText(CreateRecipeView.savedRecipes[HomeView.chooseRecipe].getInstructions());
            img = (ImageView)findViewById(R.id.foodTempImage);
            img.setImageBitmap(CreateRecipeView.pics.get(HomeView.chooseRecipe));

        }
        else{
            tv1 = (TextView)findViewById(R.id.foodTitleTemp);
            tv1.setText(recipeList[HomeView.chooseRecipe].getRecipeName());
            rate = (RatingBar) findViewById(R.id.ratingBar);
            rate.setRating(Float.parseFloat(recipeList[HomeView.chooseRecipe].getRating()));
            tv1 = (TextView)findViewById(R.id.foodIngredientsTemp);
            tv1.setText(recipeList[HomeView.chooseRecipe].getIngredients());
            tv1 = (TextView)findViewById(R.id.foodInstructionsTemp);
            tv1.setText(recipeList[HomeView.chooseRecipe].getInstructions());
        }



        //go back to home screen if back button is pressed
        backBtn = (ImageButton) findViewById(R.id.backButtonViewRecipe);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        reportBtn = (Button) findViewById(R.id.reportRecipeButtonViewRecipe);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent =  new Intent(getApplicationContext(), ReportRecipeView.class);
                startActivity(intent);
            }
        });


    }
}


