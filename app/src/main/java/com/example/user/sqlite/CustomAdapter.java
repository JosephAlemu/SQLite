package com.example.user.sqlite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by user on 1/16/2018.
 */

public class CustomAdapter extends ArrayAdapter<CelebrityData> {


     CelebrityRegister celebrityRegister;

    Context finalcontext;
    public CustomAdapter(Context context, ArrayList<CelebrityData> data) {
        super(context, R.layout.row_item, data);
        finalcontext  = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       final CelebrityData singleCelebrityData;


        LayoutInflater myinflator = LayoutInflater.from(getContext());
        View customView = myinflator.inflate(R.layout.row_item,parent, false);

          singleCelebrityData= getItem(position);

        TextView txtFirstName= (TextView)customView.findViewById(R.id.txtFirstName);
        TextView  txtLastName= (TextView)customView.findViewById(R.id.txtLastName);
        TextView  txtTitle= (TextView)customView.findViewById(R.id.txtTitle);
        TextView  txtDes= (TextView)customView.findViewById(R.id.txtDes);

        ImageButton  btnDelet = (ImageButton)customView.findViewById(R.id.btnDelet);
        ImageButton btnUpdate = (ImageButton)customView.findViewById(R.id.btnUpdate);
        ImageButton btnFav = (ImageButton)customView.findViewById(R.id.btnFav);


        txtFirstName.setText(singleCelebrityData.getStrFirstName());
        txtLastName.setText(singleCelebrityData.getStrLastName());
        txtTitle.setText(singleCelebrityData.getStrTittle());
        txtDes.setText(singleCelebrityData.getStrDescription());



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
                celebrityRegister.deleteRow(position);
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("First", "string: " + singleCelebrityData.getStrFirstName());


                Toast.makeText(getContext(), "Delet button clicked: " + singleCelebrityData.getStrTittle(), Toast.LENGTH_SHORT).show();



               // Intent intent = new Intent(context,UpdateActivity.class);


                Intent intent = new Intent(finalcontext, UpdateActivity.class);


                Bundle extras = new Bundle();




                extras.putString("id", position+"");
                extras.putString("firstname", singleCelebrityData.getStrFirstName());
                extras.putString("lastname", singleCelebrityData.getStrLastName());
                extras.putString("title", singleCelebrityData.getStrTittle());
                extras.putString("description", singleCelebrityData.getStrDescription());
                intent.putExtras(extras);



                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                finalcontext.startActivity(intent);




            }

        });

        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Toast.makeText(getContext(), "Favorite button clicked: " + singleCelebrityData.getStrTittle(), Toast.LENGTH_SHORT).show();






            }

        });

        return customView;
    }
}