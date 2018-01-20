package com.example.user.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    String id;
    String name;
    String gender;
    String age;
    String favorite;
    EditText edtName;
    EditText edtGender;
    EditText edtAge;
    DBAdapter myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        Bundle extras = getIntent().getExtras();


        id = extras.getString("id");

        name = extras.getString("name");
        gender = extras.getString("gender");
        age = extras.getString("age");
        favorite = extras.getString("favorite");



        edtName = (EditText) findViewById(R.id.edtName);
        edtGender = (EditText) findViewById(R.id.edtGender);
        edtAge = (EditText) findViewById(R.id.edtAge);



        edtName.setText(name);
        edtGender.setText(gender);
        edtAge.setText(age);


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


    public void onUpdate(View view) {


        name = edtName.getText().toString().trim();
        gender = edtGender.getText().toString().trim();
        age = edtAge.getText().toString().trim();


        int rowid = Integer.parseInt(id);
        boolean n =   myDb.updateRow(rowid, name, gender, age,favorite);

        Intent newintent = new Intent(this, Celebrity_listActivity.class);

        startActivity(newintent);


    }
}
