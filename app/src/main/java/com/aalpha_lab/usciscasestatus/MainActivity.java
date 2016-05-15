package com.aalpha_lab.usciscasestatus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button checkCaseStatus;
    Button allCaseStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkCaseStatus = (Button) findViewById(R.id.button_case_status);
        allCaseStatus = (Button) findViewById(R.id.button_all_cases_status);
        
        checkCaseStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CheckCaseStatus.class);
                startActivity(intent);
            }
        });

        allCaseStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AllCaseStatus.class);
                startActivity(intent);
            }
        });

    }
}
