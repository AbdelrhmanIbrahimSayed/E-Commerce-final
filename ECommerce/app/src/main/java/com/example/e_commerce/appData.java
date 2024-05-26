package com.example.e_commerce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class appData extends SQLiteOpenHelper {
  private static final String DataBaseName="elStore.db";
    private static final String tableName="users";
  private static final int version=1;
    private static final String col_id="id";
    private static final String col_name="name";
    private static final String col_userName="userName";
    private static final String col_password="password";
    private static final String col_phone="phone";

    public appData(Context context) {
        super(context,DataBaseName,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String userData="CREATE TABLE "+tableName+ "("
                +col_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +col_name+" TEXT," + col_userName+" TEXT,"
                +col_password+" TEXT,"+col_phone+ " TEXT)";
        db.execSQL(userData);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }

    public void insertData(String name ,String userName,String password,String phone){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("userName",userName);
        values.put("password",password);
        values.put("phone",phone);
        db.insert("users",null,values);
        db.close();
    }

    public void deleteData(int id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(tableName,col_id+" = ?",new String[]{String.valueOf(id)});
        db.close();
    }

    public Cursor getExampleData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM example_table";
        return db.rawQuery(query, null);
    }
}
