package com.sunbeaminfo.employeedatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class EmployeeDbHelper extends SQLiteOpenHelper {
    public EmployeeDbHelper(@Nullable Context context) {
        super(context, "dmc_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String sql="create table employee(id Integer primary key autoincrement,name text,marks double)";
      db.execSQL(sql);
    }
    public Cursor getAllEmployee(){
      SQLiteDatabase db=getReadableDatabase();
      Cursor cursor=db.query("employee",null,null,null,null,null,null);
      return cursor;
    }
    public void insertEmployee(String name,double marks){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("name",name);
        values.put("marks",marks);
        db.insert("employee",null,values);
    }
    public void delete(int id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete("employee","id=?",new String[]{""+id});

    }
    public void editEmployee(int id,String name ,double marks){
     SQLiteDatabase db=getWritableDatabase();
     ContentValues values=new ContentValues();
     values.put("name",name);
     values.put("marks",marks);
     db.update("employee",values,"id=?",new String[]{""+id});
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
