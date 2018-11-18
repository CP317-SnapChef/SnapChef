package app.snapchef.com.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class ReportErrorView extends AppCompatActivity {
    private Button reportBtn;
    private ImageButton backBtn;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_report_error_view);


        reportBtn = (Button)findViewById(R.id.reportErrorButton);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send report

            }
        });


        backBtn = (ImageButton)findViewById(R.id.backButtonReportError);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), AccountView.class);
                startActivity(intent);
            }
        });
    }


}
