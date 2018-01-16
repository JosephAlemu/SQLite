package com.example.user.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 1/16/2018.
 */

public class CelebrityRegister extends SQLiteOpenHelper {

    private static Context context;
    //Database Version
    private static final int DATABASE_VERSION = 6;

    //Database Name
    private static final String DATABASE_NAME = "celebrity_db";

    //Table Names
    private static final String TABLE_NAME = "celebrity_table";

    //Database Constants I am taking some constants as demo you can take   your own
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST = "strFirstName";
    private static final String COLUMN_LAST = "strLastName";
    private static final String COLUMN_TITLE = "strTittle";
    private static final String COLUMN_DESCRIPTION = "event_description";


    //Command to create a Table
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + COLUMN_ID + " integer primary key autoincrement,"
            + COLUMN_FIRST + " text,"
            + COLUMN_LAST + " text,"
            + COLUMN_TITLE + " text,"
            + COLUMN_DESCRIPTION + " text )";


    public CelebrityRegister(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;


    }


    /*
     *This method will be called on Start
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    /*
     * This method will be called onUpgradate of Database
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Method for adding data in database CelebrityData is my Model Object You can insert value as Single or Using Model class also

    public void addCelebrity(String strEditName, String strEditLast, String strEditTitle, String strEditDescription) {
        long flag = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        contentValues.put(COLUMN_FIRST, strEditName);
        contentValues.put(COLUMN_LAST, strEditLast);
        contentValues.put(COLUMN_TITLE, strEditTitle);
        contentValues.put(COLUMN_DESCRIPTION, strEditDescription);


        flag = db.insert(TABLE_NAME, null, contentValues);

        db.close();

        if (flag >= 0) {

            Toast.makeText(context, "Saved successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Saved  unsuccessful", Toast.LENGTH_SHORT).show();

        }


    }

    public void deleteCelebrity(String productName)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_FIRST + "=\"" + productName + "\";");
   }

    // this is goint in record_TextView in the Main activity.

    public ArrayList<CelebrityData> getCelebrityList() {
        SQLiteDatabase database = getWritableDatabase();

        ArrayList<CelebrityData> CelebrityList = new ArrayList<>();
        Cursor cursor =
                database.rawQuery("SELECT * FROM "
                        + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                CelebrityData celebrityData = new CelebrityData(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));

                CelebrityList.add(celebrityData);
            } while (cursor.moveToNext());
        }
        database.close();

        return CelebrityList;
    }
}

