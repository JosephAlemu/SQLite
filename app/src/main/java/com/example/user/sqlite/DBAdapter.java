package com.example.user.sqlite;

/**
 * Created by user on 1/19/2018.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {

    private static final String TAG = "DBAdapter";

    // DB Fields
    public static final String KEY_ROWID = "_id";
    public static final int COL_ROWID = 0;


    public static final String KEY_NAME = "name";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_AGE = "age";
    public static final String KEY_FAVORITE = "favorite";

    public static final int COL_NAME = 1;
    public static final int COL_GENDER = 2;
    public static final int COL_AGE = 3;
    public static final int COL_FAVORITE = 4;


    public static final String[] ALL_KEYS = new String[] {KEY_ROWID, KEY_NAME, KEY_GENDER, KEY_AGE,KEY_FAVORITE};

    // DB info: it's name, and the table we are using (just one).
    public static final String DATABASE_NAME = "Celebrity_Db";
    public static final String DATABASE_TABLE = "mainTable";
    // Track DB version if a new version of your app changes the format.
    public static final int DATABASE_VERSION = 2;

    private static final String DATABASE_CREATE_SQL =
            "create table " + DATABASE_TABLE
                    + " (" + KEY_ROWID + " integer primary key autoincrement, "
                    + KEY_NAME + " text not null, "
                    + KEY_GENDER + " string not null, "
                    + KEY_AGE + " string not null, "
                    + KEY_FAVORITE + " string"
                    + ");";

    // Context of application who uses us.
    private final Context context;
    private DatabaseHelper myDBHelper;
    private SQLiteDatabase db;

    /////////////////////////////////////////////////////////////////////
    //	Public methods:
    /////////////////////////////////////////////////////////////////////

    public DBAdapter(Context ctx) {
        this.context = ctx;
        myDBHelper = new DatabaseHelper(context);
    }

    // Open the database connection.
    public DBAdapter open() {
        db = myDBHelper.getWritableDatabase();
        return this;
    }

    // Close the database connection.
    public void close() {
        myDBHelper.close();
    }

    // Add a new set of values to the database.
    public long insertRow(String name, String gender, String age, String favorite) {

        // Create row's data:
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_GENDER, gender);
        initialValues.put(KEY_AGE, age);
        initialValues.put(KEY_AGE, age);
        initialValues.put(KEY_FAVORITE, favorite);

        // Insert it into the database.
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    // Delete a row from the database, by rowId (primary key)
    public boolean deleteRow(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE, where, null) != 0;
    }

    public void deleteAll() {
        Cursor c = getAllRows();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()) {
            do {
                deleteRow(c.getLong((int) rowId));
            } while (c.moveToNext());
        }
        c.close();
    }

    // Return all data in the database.
    public Cursor getAllRows() {
        String where = null;
        Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS,
                where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    // Get a specific row (by rowId)
    public Cursor getRow(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS,
                where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    // Change an existing row to be equal to new data.
    public boolean updateRow(long rowId, String name, String  gender, String age , String favorite) {
        String where = KEY_ROWID + "=" + rowId;


        ContentValues newValues = new ContentValues();
        newValues.put(KEY_NAME, name);
        newValues.put(KEY_GENDER, gender);
        newValues.put(KEY_AGE, age);
        newValues.put(KEY_FAVORITE, favorite);

        // Insert it into the database.
        return db.update(DATABASE_TABLE, newValues, where, null) != 0;
    }



    /////////////////////////////////////////////////////////////////////
    //	Private Helper Classes:
    /////////////////////////////////////////////////////////////////////

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase _db) {
            _db.execSQL(DATABASE_CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
            _db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);

            // Recreate new database:
            onCreate(_db);
        }
    }
}
