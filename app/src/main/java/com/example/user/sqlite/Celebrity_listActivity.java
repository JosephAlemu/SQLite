package com.example.user.sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Celebrity_listActivity extends AppCompatActivity {

    DBAdapter myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebrity_list);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        openDB();
        Cursor cursor = myDb.getAllRows();

        CustomAdapter adapter = new CustomAdapter(this, getCelebrityRecordSet(cursor));

        ListView lvCelebrity = (ListView) findViewById(R.id.lvCelebrity);

        lvCelebrity.setAdapter(adapter);


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


    private ArrayList<CelebrityPerson> getCelebrityRecordSet(Cursor cursor) {

        ArrayList<CelebrityPerson> celebrityPersonList = new ArrayList<CelebrityPerson>();

        String message = "";
        // populate the message from the cursor

        // Reset cursor to start, checking to see if there's data:
        if (cursor.moveToFirst()) {
            do {
                // Process the data:
                int id = cursor.getInt(DBAdapter.COL_ROWID);
                String name = cursor.getString(DBAdapter.COL_NAME);
                String gender = cursor.getString(DBAdapter.COL_GENDER);
                String age = cursor.getString(DBAdapter.COL_AGE);
                String favorite = cursor.getString(DBAdapter.COL_FAVORITE);


                CelebrityPerson CelebrityPerson = new CelebrityPerson(id, name, age, gender, favorite);

                celebrityPersonList.add(CelebrityPerson);


            } while (cursor.moveToNext());
        }

        // Close the cursor to avoid a resource leak.
        cursor.close();


        return celebrityPersonList;
    }


    private ArrayList<CelebrityPerson> getMyFavoritRecordSet(Cursor cursor) {

        ArrayList<CelebrityPerson> myFavoriteelebrityList = new ArrayList<CelebrityPerson>();

        String message = "";
        // populate the message from the cursor

        // Reset cursor to start, checking to see if there's data:
        if (cursor.moveToFirst()) {
            do {
                String favorite = cursor.getString(DBAdapter.COL_FAVORITE);

                if (favorite.equalsIgnoreCase("true"))

                {  // Process the data:
                    int id = cursor.getInt(DBAdapter.COL_ROWID);
                    String name = cursor.getString(DBAdapter.COL_NAME);
                    String gender = cursor.getString(DBAdapter.COL_GENDER);
                    String age = cursor.getString(DBAdapter.COL_AGE);


                    CelebrityPerson CelebrityPerson = new CelebrityPerson(id, name, age, gender, favorite);

                    myFavoriteelebrityList.add(CelebrityPerson);

                }


            } while (cursor.moveToNext());
        }

        // Close the cursor to avoid a resource leak.
        cursor.close();


        return myFavoriteelebrityList;
    }


    public void onMyfavoriteClick(View view) {

        openDB();
        Cursor cursor = myDb.getAllRows();

        CustomAdapter adapter = new CustomAdapter(this, getMyFavoritRecordSet(cursor));

        ListView lvCelebrity = (ListView) findViewById(R.id.lvCelebrity);

        lvCelebrity.setAdapter(adapter);


    }
}
