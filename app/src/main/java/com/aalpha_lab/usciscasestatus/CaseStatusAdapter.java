package com.aalpha_lab.usciscasestatus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Coded by Isha Hammam on 5/15/2016.
 */

public class CaseStatusAdapter extends ArrayAdapter<String> {

    private Context c;
    private LayoutInflater inflater;
    private int[] caseCodeImage;
    private String[] caseNumber;
    private String[] date;
    private String[] caseStatus;

    public CaseStatusAdapter(Context context, int[] caseCodeImage, String[] caseNumber, String[] date, String[] caseStatus) {
        super(context, R.layout.case_status_row, caseNumber);
        this.c = context;
        this.caseCodeImage = caseCodeImage;
        this.caseNumber = caseNumber;
        this.date = date;
        this.caseStatus = caseStatus;
    }

    // 'ViewHolder' class
    public class ViewHolder {
        ImageView imageView_caseCodeImage;
        TextView textView_caseNumber;
        TextView textView_date;
        TextView textView_caseStatus;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.case_status_row, null);
        }

        // 'holder' object of 'ViewHolder' class
        ViewHolder holder = new ViewHolder();

        // initialize 'holder' object
        holder.imageView_caseCodeImage = (ImageView) convertView.findViewById(R.id.imageView_case_code);
        holder.textView_caseNumber = (TextView) convertView.findViewById(R.id.textView_case_number);
        holder.textView_date = (TextView) convertView.findViewById(R.id.textView_date);
        holder.textView_caseStatus = (TextView) convertView.findViewById(R.id.textView_case_status);


        // assigning data to the 'holder' object
        holder.imageView_caseCodeImage.setImageResource(caseCodeImage[position]);
        holder.textView_caseNumber.setText(caseNumber[position]);
        holder.textView_date.setText(date[position]);
        holder.textView_caseStatus.setText(caseStatus[position]);

        return convertView;
    }

}
