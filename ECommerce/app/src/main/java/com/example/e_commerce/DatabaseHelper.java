package com.example.e_commerce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 3;
    public static final String TABLE_NAME = "mytable";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_Price = "price";
    private static final String COLUMN_IMAGE_RES_ID = "image_res_id";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_Price + " TEXT, " +
                COLUMN_IMAGE_RES_ID + " TEXT)";
        db.execSQL(createTable);

        // Insert test values
        insertTestValues(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public List<Person> getAllPersons() {
        List<Person> personList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(0));
                person.setName(cursor.getString(1));
                person.setAge(cursor.getString(2));
                person.setImageResId(cursor.getInt(3));
                personList.add(person);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return personList;
    }

    private void insertTestValues(SQLiteDatabase db) {
        insertPerson(db, "Jewelery", "250$", R.drawable.jewelery);
        insertPerson(db, "Shoes", "130$", R.drawable.shoes);
        insertPerson(db, "headphone", "222$", R.drawable.headphone);
        insertPerson(db, "red shoes", "270$", R.drawable.redshoes);
        insertPerson(db, "Pen", "20$", R.drawable.pen);
        insertPerson(db, "Smart Watch", "500$", R.drawable.smartwatch);
    }

    public void insertPerson(SQLiteDatabase db, String name, String age, int imageResId) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_Price, age);
        values.put(COLUMN_IMAGE_RES_ID, imageResId);
        db.insert(TABLE_NAME, null, values);
    }

    // Overloaded method for use in MainActivity
    public void insertPerson(String name, String age, int imageResId) {
        SQLiteDatabase db = this.getWritableDatabase();
        insertPerson(db, name, age, imageResId);
    }
}