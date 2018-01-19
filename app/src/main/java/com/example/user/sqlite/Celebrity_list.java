package com.example.user.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Celebrity_list extends AppCompatActivity {


   // CelebrityRegister celebrityRegister;

   // DBAdapter dBAdapter;

    CelebrityRegister celebrityRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebrity_list);


        getSupportActionBar().setTitle("Celebrity List");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listView();



    }

    public  void  listView(){




        celebrityRegister = new CelebrityRegister(this);

        final ArrayList<CelebrityData> celebrityList = celebrityRegister.getCelebrityList();

        CustomAdapter adapter = new CustomAdapter(this, celebrityList);

        ListView lvCelebrity = (ListView) findViewById(R.id.lvCelebrity);


        lvCelebrity.setAdapter(adapter);


    }




}
