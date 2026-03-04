package com.example.radiogreeting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RatingBar ratingBar;
    Button btnGreet;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        ratingBar = findViewById(R.id.ratingBar);
        btnGreet = findViewById(R.id.btnGreet);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Processing...");
        progressDialog.setCancelable(false);

        btnGreet.setOnClickListener(v -> {

            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();
                return;
            }

            float rating = ratingBar.getRating();

            RadioButton selected = findViewById(selectedId);
            String gender = selected.getText().toString();

            progressDialog.show();

            new Handler().postDelayed(() -> {

                progressDialog.dismiss();

                String message;

                if (gender.equals("Male")) {
                    message = "Hello Sir! Rating: " + rating;
                } else {
                    message = "Hello Ma'am! Rating: " + rating;
                }

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

            }, 2000);

        });
    }
}