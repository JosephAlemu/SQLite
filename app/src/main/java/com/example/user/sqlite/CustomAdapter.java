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

/**
 * Created by user on 1/16/2018.
 */

public class CustomAdapter extends ArrayAdapter<CelebrityPerson> {


    //CelebrityRegister celebrityRegister;
    DBAdapter myDb;
    Context context;
   static ArrayList<Integer> myfavList = new ArrayList<Integer> ();

    public CustomAdapter(Context context, ArrayList<CelebrityPerson> data) {
        super(context, R.layout.row_item, data);
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final CelebrityPerson singleCelebrityPerson;


        LayoutInflater myinflator = LayoutInflater.from(getContext());
        View customView = myinflator.inflate(R.layout.row_item, parent, false);

        singleCelebrityPerson = getItem(position);

        TextView txtname = (TextView) customView.findViewById(R.id.txtname);
        TextView txtage = (TextView) customView.findViewById(R.id.txtage);
        TextView txtgender = (TextView) customView.findViewById(R.id.txtgender);


        ImageButton btnDelet = (ImageButton) customView.findViewById(R.id.btnDelet);
        ImageButton btnUpdate = (ImageButton) customView.findViewById(R.id.btnUpdate);
        ImageButton btnFav = (ImageButton) customView.findViewById(R.id.btnFav);



        txtname.setText(singleCelebrityPerson.getName());
        txtage.setText(singleCelebrityPerson.getAge());
        txtgender.setText(singleCelebrityPerson.getGender());


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("First", "string: " + singleCelebrityPerson.getName());


                Toast.makeText(getContext(), "Update button clicked: " + singleCelebrityPerson.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        btnDelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("First", "string: " + singleCelebrityPerson.getName());


                Toast.makeText(getContext(), "Delet button clicked: " + singleCelebrityPerson.getName(), Toast.LENGTH_SHORT).show();

                myDb = new DBAdapter(getContext());
                myDb.open();

                myDb.deleteRow(singleCelebrityPerson.getId());
                myDb.close();

                Intent intent = new Intent(context, Celebrity_listActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("First", "string: " + singleCelebrityPerson.getName());


                Toast.makeText(getContext(), "Delet button clicked: " + singleCelebrityPerson.getName(), Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(context, UpdateActivity.class);

                Bundle extras = new Bundle();


                extras.putString("id", singleCelebrityPerson.getId()+"");
                extras.putString("name", singleCelebrityPerson.getName());
                extras.putString("age", singleCelebrityPerson.getAge());
                extras.putString("gender", singleCelebrityPerson.getGender());
                extras.putString("favorite", singleCelebrityPerson.getFavorite());

                intent.putExtras(extras);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


            }

        });

        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getContext(), singleCelebrityPerson.getName()+"  to added My Favorite Celebrity list", Toast.LENGTH_SHORT).show();
                myDb = new DBAdapter(getContext());
                myDb.open();

                myDb.updateRow(singleCelebrityPerson.getId(),singleCelebrityPerson.getName(),singleCelebrityPerson.getGender(),singleCelebrityPerson.getAge(),"true");
                myDb.close();;

            }

        });


        return customView;
    }
}