
package com.example.recipeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Loign extends AppCompatActivity {

    private TextView tvGoToRegister;
    private Button login;
    private EditText etEmail, etPassword;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loign);

        tvGoToRegister = findViewById(R.id.tvRegisterLink);
        login = findViewById(R.id.btnLogin);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        dbHelper = new DatabaseHelper(this);

        tvGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Loign.this, Register.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(Loign.this,"Please enter email and password",Toast.LENGTH_SHORT).show();
                }else{

                    SQLiteDatabase db = dbHelper.getReadableDatabase();

                    Cursor cursor = db.rawQuery(
                            "SELECT * FROM users WHERE email=? AND password=?",
                            new String[]{email, password});

                    if(cursor.getCount() > 0){

                        Toast.makeText(Loign.this,"Login Successful",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Loign.this, MainActivity.class);
                        startActivity(intent);

                    }else{

                        Toast.makeText(Loign.this,"Invalid Email or Password",Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });
    }
}

