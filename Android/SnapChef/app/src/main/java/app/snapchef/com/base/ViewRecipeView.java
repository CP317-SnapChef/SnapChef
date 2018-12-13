package app.snapchef.com.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ViewRecipeView extends AppCompatActivity {
    //TODO: Again... literally this entire view, but it should be similar to CreateRecipeView

    private ImageButton backBtn;
    private Button reportBtn;
    private Intent intent;
    private TextView txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);


        TextView tv1 = (TextView)findViewById(R.id.foodTitleTemp);
        tv1.setText("Scrambled Eggs");

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
        txtview = findViewById(R.id.foodTitleTemp);
        txtview.setText(apiTESTActivity.recipeobj.getRecipeName());
    }
}


