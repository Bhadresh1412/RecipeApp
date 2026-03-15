
package com.example.recipeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private TextView tvGoToLogin;
    private EditText etName, etEmail, etPassword;
    private Button btnRegister;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        tvGoToLogin = findViewById(R.id.tvLoginLink);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnRegister = findViewById(R.id.btnRegister);

        dbHelper = new DatabaseHelper(this);

        tvGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register.this, Loign.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Toast.makeText(Register.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
                }else{

                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put("name", name);
                    values.put("email", email);
                    values.put("password", password);

                    db.insert("users", null, values);

                    Toast.makeText(Register.this,"Register Successful",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Register.this, Loign.class);
                    startActivity(intent);
                }

            }
        });

    }
}

