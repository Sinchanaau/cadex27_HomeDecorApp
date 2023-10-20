package com.example.furnitureapp;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AddressDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "address.db";
    private static final int DATABASE_VERSION = 1;

    public AddressDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Define the table and its columns
        String createTableSQL = "CREATE TABLE addresses (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "mobile TEXT, " +
                "pin_code TEXT, " +
                "address TEXT, " +
                "locality TEXT, " +
                "city TEXT, " +
                "state TEXT);";
        db.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}