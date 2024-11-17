package com.sunbeaminfo.userregistrationapp.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.sunbeaminfo.userregistrationapp.entity.Product;
import com.sunbeaminfo.userregistrationapp.entity.User;

public class AppDbHelper extends SQLiteOpenHelper {
    public AppDbHelper(@Nullable Context context) {
        super(context, "dmc_db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table user(id Integer primary key autoincrement,name text,email text,password text)";
        db.execSQL(sql);
        String sql_product = "CREATE TABLE product(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, price DOUBLE)";
        db.execSQL(sql_product);
    }
    public void insertUser(User user){
      SQLiteDatabase db=getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("name",user.getName());
        values.put("email",user.getEmail());
        values.put("password",user.getPassword());
      db.insert("user",null,values);
    }
    public User getUser(String email,String password){
      SQLiteDatabase db= getReadableDatabase();
      Cursor cursor=db.query("user",null,"email=? AND password=?",new String[]{email,password},null,null,null);
      if(cursor.moveToNext()){
          User user=new User();
          user.setId((cursor.getInt(0)));
          user.setName(cursor.getString(1));
          user.setEmail(email);
          user.setPassword(password);
          return user;
      }
      return null;
    }
    public void insertProduct(Product product){

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql_product = "CREATE TABLE product(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, price DOUBLE)";
        db.execSQL(sql_product);
    }
}
