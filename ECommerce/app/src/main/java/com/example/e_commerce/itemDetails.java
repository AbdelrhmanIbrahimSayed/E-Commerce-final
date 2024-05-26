package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class itemDetails extends AppCompatActivity {

    TextView title,price;
    ImageView img;
    FloatingActionButton fab;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        Intent in=getIntent();
     //   Toast.makeText(this, "Welcome " +in.getStringExtra("Name")+" p "+in.getStringExtra("Price")+" src "+in.getStringExtra("imgsrc"), Toast.LENGTH_SHORT).show();

        title=findViewById(R.id.textView);
        price=findViewById(R.id.textView2);
        img=findViewById(R.id.imageView2);
        fab=findViewById(R.id.fab);

        title.setText(title.getText()+in.getStringExtra("Name"));
        price.setText(price.getText()+in.getStringExtra("Price"));
        img.setImageResource(Integer.parseInt(in.getStringExtra("imgsrc")));

    }
    public void openHomePageINitem(View view){

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