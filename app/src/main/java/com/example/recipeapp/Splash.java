package com.example.recipeapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // Hide the Action Bar for a full-screen look
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        // Delay for 3000 milliseconds (3 seconds)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Loign.class);
                startActivity(intent);
                finish(); // Close SplashActivity so user can't go back to it
            }
        }, 3000);
    }
}