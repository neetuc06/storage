package com.example.chitkaraneetu.s07a04;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Chitkara Neetu on 3/29/2016.
 */
public class DBHelper {

    static final String DATABASE_NAME ="namelist.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;


    public static String DATABASE_CREATE = "create table "+ "namelist"+" ( "+ "ID "+"integer primary key autoincrement, "+
            "FIRSTNAME text, " + "LASTNAME text ); ";

    public SQLiteDatabase db;
    private final Context context;
    public static DBSqlOpenHelper dbHelper;

    public DBHelper(Context context1) {
        this.context = context1;
        dbHelper= new DBSqlOpenHelper(context1,DATABASE_NAME,null, DATABASE_VERSION);
    }

public DBHelper open() throws SQLException{

    db = dbHelper.getWritableDatabase();
    return this;
}

    public void close(){db.close();}

    public SQLiteDatabase getDatabaseInstance(){return db;}

    public boolean insertName( String fname, String lname){
        ContentValues cv= new ContentValues();
        cv.put("FIRSTNAME", fname);
        cv.put("LASTNAME", lname);
        db.insert("namelist", null, cv);
        Log.v("Record inserted","Record inserted successfully");
        return true;
    }



}
