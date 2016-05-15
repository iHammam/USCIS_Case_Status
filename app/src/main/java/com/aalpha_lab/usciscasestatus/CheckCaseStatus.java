package com.aalpha_lab.usciscasestatus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CheckCaseStatus extends AppCompatActivity {

    ListView listView1;
    Button check;
    EditText inputCaseNumber;

    private int[] caseCodeImage = {
            R.drawable.i_129,
            R.drawable.i_129,
            R.drawable.i_129,
            R.drawable.i_129,
            R.drawable.i_129,
            R.drawable.i_129,
            R.drawable.i_129
    };

    private String[] caseNumber = {
            "WAC1514751942",
            "WAC1514751941",
            "WAC1514751940",
            "WAC1514751939",
            "WAC1514751938",
            "WAC1514751937",
            "WAC1514751936"
    };

    private String[] date = {
            "March 15, 2016",
            "November 12, 2015",
            "June 09, 2015",
            "January 05, 2016",
            "December 27, 2014",
            "March 17, 2013",
            "August 15, 2015"
    };

    private String[] caseStatus = {
            "Case was Approved",
            "Withdrawal Acknowledgement Notice was Sent",
            "Case was Approved",
            "Case was Approved",
            "Withdrawal Acknowledgement Notice was Sent",
            "Case was Approved",
            "Case was Approved"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_case_status);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner Drop down elements
        List<String> scope = new ArrayList<String>();
        scope.add("01");
        scope.add("20");
        scope.add("50");
        scope.add("80");
        scope.add("100");
        scope.add("150");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, scope);

        // Drop down layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


        inputCaseNumber = (EditText) findViewById(R.id.editText);


        check = (Button) findViewById(R.id.button_check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputCaseNumber.getText().toString();
                if (input.matches("")) {

                    AlertDialog alertDialog = new AlertDialog.Builder(
                            CheckCaseStatus.this).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Invalid Input");

                    // Setting Dialog Message
                    alertDialog.setMessage("Please enter a valid case number. " +
                            "Here we can except only WAC1514751942 as it is a prototype");

                    // Setting Icon to Dialog
                    alertDialog.setIcon(R.drawable.uscis_small);

                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed
                            Toast.makeText(getApplicationContext(), "Warning! This is a prototype only.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();

                    return;
                }

                if (input.matches("WAC1514751942")) {
                    listView1.setVisibility(View.VISIBLE);
                    return;
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(
                            CheckCaseStatus.this).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Invalid Input");

                    // Setting Dialog Message
                    alertDialog.setMessage("Please use WAC1514751942 as your input case number since it is a prototype only.");

                    // Setting Icon to Dialog
                    alertDialog.setIcon(R.drawable.uscis_small);

                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed
                            Toast.makeText(getApplicationContext(), "Warning! This is a prototype only.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();

                }
            }
        });


        // ListView coding
        listView1 = (ListView) findViewById(R.id.listView_1);

        CaseStatusAdapter adapter = new CaseStatusAdapter(this,
                caseCodeImage, caseNumber, date, caseStatus);
        listView1.setAdapter(adapter);

        // OnListItemClicked functionality
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), CaseStatusDetails.class);
                startActivityForResult(intent, 0);
            }
        });

    }

}
