package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CheckOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        Intent in=getIntent();
      //  Toast.makeText(this, "n: " +in.getStringExtra("userName"), Toast.LENGTH_SHORT).show();
    }
    public void openHome(View view){
        Intent in=new Intent(this, HomePage.class);
        startActivity(in);
        Intent intent = new Intent(this, NotificationService.class);
        startService(intent);

    }
}