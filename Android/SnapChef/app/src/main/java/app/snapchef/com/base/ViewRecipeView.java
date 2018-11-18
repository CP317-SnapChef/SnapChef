package app.snapchef.com.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class ViewRecipeView extends AppCompatActivity {
    //TODO: Again... literally this entire view, but it should be similar to CreateRecipeView
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
    }
}
