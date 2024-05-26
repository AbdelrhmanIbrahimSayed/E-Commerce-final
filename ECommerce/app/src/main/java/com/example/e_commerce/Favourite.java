package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Favourite extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
    }
    public void openHomePage(View view){
        Intent in=new Intent(this, HomePage.class);
        startActivity(in);
    }

    public void openCartPage(View view){
        Intent in=new Intent(this, Cart.class);
        startActivity(in);

        Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show();
        Intent service=new Intent(getBaseContext(), MyService2.class);
        startService(service);
    }

    public void remove(View view){
        Toast.makeText(this, "Successfully removed", Toast.LENGTH_SHORT).show();
        Intent service=new Intent(getBaseContext(), MyService.class);
        startService(service);
    }
}