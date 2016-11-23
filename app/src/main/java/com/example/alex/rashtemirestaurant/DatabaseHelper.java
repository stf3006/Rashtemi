package com.example.alex.rashtemirestaurant;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Rashtemir.db";
    public static final String TABLE_CLIENTS = "clients";
    public static final String TABLE_MENU = "menu";
    public static final String TABLE_ADDRESSES = "addresses";
    public static final String TABLE_LOCATIONS = "locations";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE CLIENTS TABLE
        db.execSQL("CREATE TABLE " + TABLE_CLIENTS +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "phone TEXT NOT NULL, " +
                "username TEXT NOT NULL, " +
                "password TEXT NOT NULL)");
        
        //// TODO: 23.11.2016 CREATE MENU TABLE
        db.execSQL("CREATE TABLE " + TABLE_MENU +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "price INTEGER NOT NULL, " +
                "category INTEGER NOT NULL, " +
                " TEXT NOT NULL)");

        //// TODO: 23.11.2016 CREATE ADDRESS TABLE
        //// TODO: 23.11.2016 CREATE LOCATIONS TABLE
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //// TODO: 23.11.2016 onUpgrade
    }
}
