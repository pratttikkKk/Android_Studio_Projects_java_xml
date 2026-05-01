package com.example.doctorbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLoginActivity extends AppCompatActivity {

    EditText adminUser, adminPass;
    Button adminLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminUser = findViewById(R.id.adminUser);
        adminPass = findViewById(R.id.adminPass);
        adminLoginBtn = findViewById(R.id.adminLoginBtn);

        adminLoginBtn.setOnClickListener(v -> {

            if (adminUser.getText().toString().equals("admin") &&
                    adminPass.getText().toString().equals("1234")) {

                startActivity(new Intent(this, AdminDoctorActivity.class));
            } else {
                Toast.makeText(this, "Invalid Admin Login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}