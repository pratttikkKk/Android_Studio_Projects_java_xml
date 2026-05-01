package com.example.doctorbookingapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.userBtn).setScaleX(0f);
        findViewById(R.id.userBtn).animate().scaleX(1f).setDuration(500);

        findViewById(R.id.adminBtn).setScaleX(0f);
        findViewById(R.id.adminBtn).animate().scaleX(1f).setDuration(700);
        findViewById(R.id.userBtn).setOnClickListener(v ->
                startActivity(new Intent(this, DoctorListActivity.class)));

        findViewById(R.id.adminBtn).setOnClickListener(v ->
                startActivity(new Intent(this, AdminLoginActivity.class)));
        findViewById(R.id.dashboardBtn).setOnClickListener(v ->
                startActivity(new Intent(this, UserDashboardActivity.class)));
    }
}