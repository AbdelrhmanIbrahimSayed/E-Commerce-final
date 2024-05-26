package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Smartwatch extends AppCompatActivity {
    FloatingActionButton fab;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartwatch);
        fab=findViewById(R.id.fab);
    }
    public void openHomePageINSmartWatch(View view){

        Intent in=new Intent(this, HomePage.class);
        startActivity(in);
        Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show();
        Intent service=new Intent(getBaseContext(), MyService2.class);
        startService(service);
    }

    public void addToFavorite(View view){
        if(x==0) {
            fab.setImageResource(R.drawable.favorite);
            x=1;
        }
        else{
            x=0;
            fab.setImageResource(R.drawable.favorite_border);
        }
    }
}