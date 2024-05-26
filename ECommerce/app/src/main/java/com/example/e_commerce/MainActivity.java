package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText userNameInput,passwordInput;
    private appData db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        db = new appData(this);
        userNameInput=findViewById(R.id.editText);
        passwordInput=findViewById(R.id.editText2);
//        Intent in=new Intent(this, HomePage.class);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean login=false;
                Cursor resultSet = db.getReadableDatabase().rawQuery("Select * from users", null);

                if (resultSet.moveToFirst()) {
                    do {
                        String name = resultSet.getString(1);
                        String username = resultSet.getString(2);
                        String password = resultSet.getString(3);

                        if(userNameInput.getText().toString().equals(username) && passwordInput.getText().toString().equals(password)){
                            login=true;
                            Toast.makeText(MainActivity.this, "Welcome: " +name, Toast.LENGTH_SHORT).show();
                            openHomePage(v,username);
                        }
//                        else{
//                            Toast.makeText(MainActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
//                        }
                        // Display data

                    } while (resultSet.moveToNext());
                    if(login==false) {
                        Toast.makeText(MainActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                    }
                    } else {
                    Log.d("MainActivity", "No data found.");
                }
                resultSet.close();

            }
        });

    }

    public void openSignUp(View view){
        Intent in=new Intent(this, sign_up.class);
        startActivity(in);
    }

    public void openHomePage(View view ,String userName){

        Intent in=new Intent(this, HomePage.class);
        in.putExtra("userName",userName);
        startActivity(in);
    }
    public void aboutus(View view){
        Intent in=new Intent(this,AboutUs.class);
        startActivity(in);
    }


}