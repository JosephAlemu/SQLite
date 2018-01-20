package com.example.user.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*
 * Steps to using the DB:
 * 1. [DONE] Instantiate the DB Adapter
 * 2. [DONE] Open the DB
 * 3. [DONE] use get, insert, delete, .. to change data.
 * 4. [DONE]Close the DB
 */

/**
 * Demo application to show how to use the
 * built-in SQL lite database.
 */
public class MainActivity extends Activity {

    DBAdapter myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openDB();



    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDB();
    }


    private void openDB() {
        myDb = new DBAdapter(this);
        myDb.open();
    }
    private void closeDB() {
        myDb.close();
    }



    public void onClick_AddRecord(View v) {
      //  displayText("Clicked add record!");

        EditText editName = (EditText) findViewById(R.id.editName);
        EditText editGender = (EditText) findViewById(R.id.editGender);
        EditText editAge = (EditText) findViewById(R.id.editAge);


        long newId = myDb.insertRow(editName.getText().toString(), editGender.getText().toString(), editAge.getText().toString(),"false");

        Intent intent = new Intent(this, Celebrity_listActivity.class);
        startActivity(intent);

    }


    public void onClick_DisplayCelebrity(View view) {

        Intent intent = new Intent(this, Celebrity_listActivity.class);
        startActivity(intent);

    }

    public void onClick_ClearAll(View view) {

        myDb.deleteAll();
        Toast.makeText(this, "Celebreitiy List Successfully cleared", Toast.LENGTH_SHORT).show();
    }



}







