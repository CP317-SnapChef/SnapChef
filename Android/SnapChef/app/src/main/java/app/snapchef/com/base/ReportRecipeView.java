package app.snapchef.com.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ReportRecipeView extends AppCompatActivity {
    private Button reportBtn;
    private ImageButton backBtn;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_report_recipe_view);

        reportBtn = (Button)findViewById(R.id.reportRecipeButton);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send report

                Toast toast = Toast.makeText(getApplicationContext(), "Recipe Reported", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        backBtn = (ImageButton)findViewById(R.id.backButtonReportRecipe);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}