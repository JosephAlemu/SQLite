package com.example.user.sqlite;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 1/16/2018.
 */

public class CustomAdapter extends ArrayAdapter<CelebrityData> {

    CelebrityData singleCelebrityData;
    CelebrityRegister celebrityRegister;

    public CustomAdapter(Context context, ArrayList<CelebrityData> data) {
        super(context, R.layout.row_item, data);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater myinflator = LayoutInflater.from(getContext());
        View customView = myinflator.inflate(R.layout.row_item,parent, false);

          singleCelebrityData= getItem(position);

        TextView txtFirstName= (TextView)customView.findViewById(R.id.txtFirstName);
        TextView  txtLastName= (TextView)customView.findViewById(R.id.txtLastName);
        TextView  txtTitle= (TextView)customView.findViewById(R.id.txtTitle);
        TextView  txtDes= (TextView)customView.findViewById(R.id.txtDes);
        TextView  btnDelet = (TextView)customView.findViewById(R.id.btnDelet);
        TextView  btnUpdate = (TextView)customView.findViewById(R.id.btnUpdate);


        txtFirstName.setText(singleCelebrityData.getStrFirstName());
        txtLastName.setText(singleCelebrityData.getStrLastName());
        txtTitle.setText(singleCelebrityData.getStrTittle());
        txtDes.setText(singleCelebrityData.getStrTittle());



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("First", "string: " + singleCelebrityData.getStrFirstName());


                Toast.makeText(getContext(), "Update button clicked: " + singleCelebrityData.getStrTittle(), Toast.LENGTH_SHORT).show();
            }
        });

        btnDelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("First", "string: " + singleCelebrityData.getStrFirstName());


                Toast.makeText(getContext(), "Delet button clicked: " + singleCelebrityData.getStrTittle(), Toast.LENGTH_SHORT).show();

                celebrityRegister =new CelebrityRegister(getContext());
                celebrityRegister.deleteCelebrity(singleCelebrityData.getStrTittle());
            }
        });


        return customView;
    }
}