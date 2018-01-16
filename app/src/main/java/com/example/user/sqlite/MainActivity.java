package com.example.user.sqlite;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtEditDescription;
    EditText txtEditName;
    EditText txtEditLast;
    EditText txtEditTitle;
    ListView lvCelebrity;

    String strEditDescription;
    String strEditName;
    String strEditLast;
    String strEditTitle;
    CelebrityRegister celebrityRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();


    }
    private void bindView()

    {

        txtEditName = (EditText) findViewById(R.id.txtEditName);
        txtEditLast = (EditText) findViewById(R.id.txtEditLast);
        txtEditTitle = (EditText) findViewById(R.id.txtEditTitle);
        txtEditDescription = (EditText) findViewById(R.id.txtEditDescription);
        txtEditDescription = (EditText) findViewById(R.id.txtEditDescription);
           lvCelebrity = (ListView)findViewById(R.id.lvCelebrity);

    }


    public void onHandlingDatabase(View view) {


        strEditName =   txtEditName.getText().toString();
        strEditLast =  txtEditLast.getText().toString();
        strEditTitle =  txtEditTitle.getText().toString();
        strEditDescription =  txtEditDescription.getText().toString();


        celebrityRegister =new CelebrityRegister(this);

        switch (view.getId()) {
            case R.id.btnCelebrityAdd:

                celebrityRegister.addCelebrity(strEditName,strEditLast,strEditTitle,strEditDescription);

                break;

            case R.id.btnGetCelebrityList:

                 Intent intent;

                intent = new Intent(this, Celebrity_list.class);
                startActivity(intent);




                break;
        }



    }


}
