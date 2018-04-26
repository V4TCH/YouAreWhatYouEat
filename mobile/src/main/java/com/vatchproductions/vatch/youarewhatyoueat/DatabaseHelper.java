package com.vatchproductions.vatch.youarewhatyoueat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "userdata.db";
    private static final String TABLE_NAME = "userdata_table";
    private static final String ID = "ID";
    private static final String NAME = "FIRSTNAME";
    private static final String SURNAME = "LASTNAME";
    private static final String SEX = "SEX";
    private static final String AGE = "AGE";
    private static final String CITY  = "CITY";
    private static final String POSTCODE = "POSTCODE";

    private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + SURNAME + " TEXT, "+ SEX + " BOOL," + AGE + " INTEGER, " + CITY + " TEXT, " + POSTCODE + " TEXT );";


    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
}
