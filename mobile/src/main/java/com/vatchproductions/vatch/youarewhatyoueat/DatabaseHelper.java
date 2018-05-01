package com.vatchproductions.vatch.youarewhatyoueat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    private static final String EMAIL = "EMAIL";
    private static final String PASSWORD = "PASSWORD";
    private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + SURNAME + " TEXT, " + SEX + " TEXT, " + AGE + " INTEGER, " + CITY + " TEXT, " + POSTCODE + " TEXT, " + EMAIL + " TEXT, "+ PASSWORD + " TEXT );";


    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
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
    public boolean insertData(String name, String surname, String sex, String age, String city, String postcode, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(SURNAME, surname);
        contentValues.put(SEX, sex);
        contentValues.put(AGE, age);
        contentValues.put(CITY, city);
        contentValues.put(POSTCODE, postcode);
        contentValues.put(EMAIL, email);
        contentValues.put(PASSWORD, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
    }
}


