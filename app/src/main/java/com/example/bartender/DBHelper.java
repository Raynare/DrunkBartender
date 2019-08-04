package com.example.bartender;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ingredients ("
                + "id integer primary key,"
                + "ingredientId integer,"
                + "volume integer" + ");");

        db.execSQL("create table data ("
                + "name text,"
                + "value text" + ");");

        ContentValues cvMoney = new ContentValues();
        cvMoney.put("name", "money");
        cvMoney.put("value", Globals.money);
        db.insert("data", null, cvMoney);

        ContentValues cvLevel = new ContentValues();
        cvLevel.put("name", "level");
        cvLevel.put("value", Globals.level);
        db.insert("data", null, cvLevel);

        ContentValues cvExp = new ContentValues();
        cvExp.put("name", "exp");
        cvExp.put("value", Globals.exp);
        db.insert("data", null, cvExp);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
