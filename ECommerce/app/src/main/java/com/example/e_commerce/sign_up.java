package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {
    appData db;
    EditText name;
    EditText userName;
    EditText password;
    EditText phone;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        db=new appData(this);
        name=findViewById(R.id.editText3);
        userName=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        phone=findViewById(R.id.editText4);
        b=findViewById(R.id.button);
        Intent in=new Intent(this, MainActivity.class);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //to delete data db.delete(id);

                String nameOfUser=name.getText().toString();
                String userNameOfUser=userName.getText().toString();
                String passwordOfUser=password.getText().toString();
                String phoneOfUser=phone.getText().toString();

                if(!nameOfUser.isEmpty() && !userNameOfUser.isEmpty() && !passwordOfUser.isEmpty()){
                    db.insertData(nameOfUser,userNameOfUser,passwordOfUser,phoneOfUser);
                    Log.d("sign_up","inserted"+userNameOfUser);
                    Toast.makeText(sign_up.this, "email inserted ", Toast.LENGTH_SHORT).show();

                    startActivity(in);
                }
                else{
                    Log.d("sign_up","Not inserted"+userNameOfUser);
                    Toast.makeText(sign_up.this, "email Not inserted ", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    public void openSignin(View view){
//        Intent in=new Intent(this,MainActivity.class );
//        startActivity(in);
    }
}