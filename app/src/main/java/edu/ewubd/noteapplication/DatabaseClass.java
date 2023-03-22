package edu.ewubd.noteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.sql.SQLData;
import java.util.ArrayList;

public class DatabaseClass extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Note.db";
    private static final String TABLE_NAME = "Note_Table";
    private static final String COL1 = "ID";
    private static final String COL2 = "Title";
    private static final String COL3 = "DES";

    public DatabaseClass(Context context)
    {

        super(context,DATABASE_NAME,null,1);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {


        db.execSQL("create table "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Title TEXT,DES INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean add_data(String title,String des)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL2,title);
        cv.put(COL3,des);



        long result = db.insert(TABLE_NAME, null, cv);

        if(result == -1){return false;}

        else{return true;}

    }
    public Cursor get_data()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }


    public boolean update_data(String id,String title,String des)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL2,title);
        cv.put(COL3,des);



        db.update(TABLE_NAME, cv, COL1 + " = ? " ,
                new String[]{String.valueOf(id)});

        return true;

    }






}
