package com.example.doctorbookingapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnBook).setOnClickListener(v ->
                startActivity(new Intent(this, BookingActivity.class)));

        findViewById(R.id.btnAdmin).setOnClickListener(v ->
                startActivity(new Intent(this, AdminLoginActivity.class)));
        findViewById(R.id.btnBook).setAlpha(0f);
        findViewById(R.id.btnBook).animate().alpha(1f).setDuration(800);
    }
}