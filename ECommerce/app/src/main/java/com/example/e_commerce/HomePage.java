package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HomePage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;
    private List<Person> personList;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));  // Set span count to 2

        databaseHelper = new DatabaseHelper(this);

        // Insert test values if database is empty
        if (isDatabaseEmpty()) {
            databaseHelper.insertPerson("Jewelery", "250$", R.drawable.jewelery);
            databaseHelper.insertPerson("Shoes", "130$", R.drawable.shoes);
            databaseHelper.insertPerson("Headphone", "222$", R.drawable.headphone);
            databaseHelper.insertPerson("Red Shoes", "270$", R.drawable.redshoes);
            databaseHelper.insertPerson("Pen", "20$", R.drawable.pen);
            databaseHelper.insertPerson("Smart Watch", "500$", R.drawable.smartwatch);
        }

        personList = databaseHelper.getAllPersons();
        personAdapter = new PersonAdapter(this, personList);
        recyclerView.setAdapter(personAdapter);
    }

    private boolean isDatabaseEmpty() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + DatabaseHelper.TABLE_NAME, null);
        boolean isEmpty = false;
        if (cursor.moveToFirst()) {
            isEmpty = cursor.getInt(0) == 0;
        }
        cursor.close();
        return isEmpty;
    }

    public void openCartPage(View view){
        Intent in=new Intent(this, Cart.class);
        startActivity(in);
    }
    public void openFavourite(View view){
        Intent in=new Intent(this, Favourite.class);
        startActivity(in);
    }

    public void signout(View view){
        Intent in=new Intent(this, MainActivity.class);
        startActivity(in);
    }


}