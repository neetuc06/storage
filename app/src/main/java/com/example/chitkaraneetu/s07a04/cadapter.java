package com.example.chitkaraneetu.s07a04;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Chitkara Neetu on 3/30/2016.
 */
public class cadapter extends CursorAdapter {

    public cadapter(Context context, Cursor c, int flags) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_layout,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvid= (TextView)view.findViewById(R.id.tv_id);
        TextView tvfname =(TextView)view.findViewById(R.id.tv_firstname);
        TextView tvlname = (TextView)view.findViewById(R.id.tv_lastname);

        int id= cursor.getInt(cursor.getColumnIndexOrThrow("ID"));
        String fname = cursor.getString(cursor.getColumnIndexOrThrow("FIRSTNAME"));
        String lname = cursor.getString(cursor.getColumnIndexOrThrow("LASTNAME"));
        tvid.setText(String.valueOf(id));
        tvfname.setText(fname);
        tvlname.setText(lname);
    }
}
