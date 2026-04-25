package com.example.doctorbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdminLoginActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        EditText pass = findViewById(R.id.password);

        findViewById(R.id.login).setOnClickListener(v -> {

            if (pass.getText().toString().equals("admin123")) {
                startActivity(new Intent(this, ViewActivity.class));
            } else {
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}