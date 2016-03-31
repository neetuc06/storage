package com.example.chitkaraneetu.s07a04;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Chitkara Neetu on 3/29/2016.
 */
public class DBSqlOpenHelper extends SQLiteOpenHelper {

    public DBSqlOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBHelper.DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v("Task adapter","Upgrading database from " + oldVersion + " to " + newVersion + "which will delete all data");
        db.execSQL("Drop table if exists" +"TEMPLATE");
        onCreate(db);
    }
}
