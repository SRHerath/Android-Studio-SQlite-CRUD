package com.example.testing.Sql;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "item_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "materials";
    private static final String KEY_ID = "id";
    private static final String KEY_CODE = "code";
    private static final String DES = "des";
    private static final String QUA = "quan";



    private static final String CREATE_TABLE_MATERIALS = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_CODE + " TEXT, "+ DES + " TEXT, " + QUA + " TEXT );";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("table", CREATE_TABLE_MATERIALS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MATERIALS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'");
        onCreate(db);
    }

    public long addDetail(String code, String des, String quan) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();
        values.put(KEY_CODE, code);
        values.put(DES, des);
        values.put(QUA, quan);
        // insert row in students table
        long insert = db.insert(TABLE_USER, null, values);

        return insert;
    }

    @SuppressLint("Range")
    public ArrayList<ItemModel> getAllData() {
        ArrayList<ItemModel> userModelArrayList = new ArrayList<ItemModel>();

        String selectQuery = "SELECT  * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                ItemModel userModel = new ItemModel();
                userModel.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                userModel.setItemCode(c.getString(c.getColumnIndex(KEY_CODE)));
                userModel.setItemDes(c.getString(c.getColumnIndex(DES)));
                userModel.setItemQuan(c.getString(c.getColumnIndex(QUA)));
                // adding to Students list
                userModelArrayList.add(userModel);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }

    public int updateDetails(int id, String code, String des, String quan) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Creating content values
        ContentValues values = new ContentValues();
        values.put(KEY_CODE, code);
        values.put(DES, des);
        values.put(QUA, quan);
        //update
        return db.update(TABLE_USER, values, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    public void deleteDetails(int id) {

        // delete row based on id
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

}