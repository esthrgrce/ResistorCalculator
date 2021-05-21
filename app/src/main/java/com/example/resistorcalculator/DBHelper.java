package com.example.resistorcalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper sInstance;

    public static synchronized DBHelper getInstance(Context context){
        if(sInstance == null) {
            sInstance = new DBHelper(context.getApplicationContext());
        }
        return  sInstance;
    }

    public DBHelper(Context context) {
        super(context, "database.db", null, 1);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.disableWriteAheadLogging();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(id integer primary key autoincrement, username text not null, password text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }

    public boolean registerUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("password", password);
        Cursor cursor = db.rawQuery("select * from users where username=? limit 1", new String[]{username});
        if(cursor.getCount() > 0){
            return false;
        }
        cursor.close();
        long result = db.insert("users", null, cv);
        if(result == -1){
            return false;
        }else return true;
    }

    public boolean loginUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? limit 1", new String[]{username});
        if(cursor.getCount() > 0){
            if(cursor.moveToFirst()){
                String user_password = cursor.getString(2);
                if(password.equals(user_password)) return true;
                else  return false;
            }
        }
        cursor.close();
        return false;
    }


    public Cursor getUsers(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users", null);
        return cursor;
    }
}
