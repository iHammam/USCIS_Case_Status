package com.aalpha_lab.usciscasestatus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class AllCaseStatus extends AppCompatActivity {

    ListView listView2;

    private int[] caseCodeImage = {
            R.drawable.i_130,
            R.drawable.i_130,
            R.drawable.i_130,
            R.drawable.i_131,
            R.drawable.i_765,
            R.drawable.i_821,
            R.drawable.i_130
    };

    private String[] caseNumber = {
            "WAC1590557605",
            "WAC1590557596",
            "WAC1590557593",
            "EAC1590748941",
            "EAC1590748936",
            "EAC1590748929",
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
            "Case was Received",
            "Withdrawal Acknowledgement Notice was Sent",
            "Case was Approved",
            "Case was Approved",
            "Withdrawal Acknowledgement Notice was Sent",
            "Case was Approved",
            "Case was Approved"
    };

    private String[] update = {
            "Updated: March 15, 2016 at 11:29:34 PM",
            "Updated: November 12, 2015 at 11:27:35 PM",
            "Updated: June 09, 2015 at 11:29:37 PM",
            "Updated: January 05, 2016 at 11:24:34 PM",
            "Updated: December 27, 2014 at 12:47:34 PM",
            "Updated: March 17, 2013 at 10:29:34 PM",
            "Updated: August 15, 2015 at 11:29:34 PM"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_case_status);

        // ListView coding
        listView2 = (ListView) findViewById(R.id.listView_2);

        AllCaseStatusAdapter adapter = new AllCaseStatusAdapter(this,
                caseCodeImage, caseNumber, date, caseStatus, update);
        listView2.setAdapter(adapter);

        // OnListItemClicked functionality
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), CaseStatusDetails.class);
                startActivityForResult(intent, 0);
            }
        });
    }

}
