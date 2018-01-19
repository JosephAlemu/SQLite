package com.example.user.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {


    String id;
    String firstname;
    String lastname;
    String title;
    String description;
    EditText ettvfistName;
    EditText edtvLastName;
    EditText ettxtTitle;
    EditText etDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent();

        Bundle extras = getIntent().getExtras();


        id = extras.getString("id");

        firstname = extras.getString("firstname");
        lastname = extras.getString("lastname");
        title = extras.getString("title");
        description = extras.getString("lastName");


        ettvfistName = (EditText) findViewById(R.id.ettvfistName);
        edtvLastName = (EditText) findViewById(R.id.edtvLastName);
        ettxtTitle = (EditText) findViewById(R.id.ettxtTitle);
        etDescription = (EditText) findViewById(R.id.etDescription);


        ettvfistName.setText(firstname);
        edtvLastName.setText(lastname);
        ettxtTitle.setText(title);
        etDescription.setText(description);


    }


    public void onUpdate(View view) {


        firstname = ettvfistName.getText().toString().trim();
        lastname = edtvLastName.getText().toString().trim();
        title = ettxtTitle.getText().toString().trim();
        description = etDescription.getText().toString().trim();


        int rowid = Integer.parseInt(id);


        Log.d("First", "string::::> " + rowid);
        Log.d("First", "string::::> " + firstname);
        Log.d("First", "string::::> " + lastname);
        Log.d("First", "string::::>" + title);
        Log.d("First", "string::::> " + description);

        CelebrityRegister celebrityRegister = new CelebrityRegister(this);

      boolean n =   celebrityRegister.updateRow(rowid, firstname, lastname, title, description);
        Log.d("First", "string::::> " +  n );

        Intent newintent = new Intent(this, Celebrity_list.class);

        startActivity(newintent);


    }
}
