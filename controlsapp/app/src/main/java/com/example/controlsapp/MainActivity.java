package com.example.controlsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerCourse;
    ToggleButton toggleButton;
    ProgressBar progressBar;
    Button btnStart;

    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCourse = findViewById(R.id.spinnerCourse);
        toggleButton = findViewById(R.id.toggleButton);
        progressBar = findViewById(R.id.progressBar);
        btnStart = findViewById(R.id.btnStart);

        // Spinner Data
        String[] courses = {"BCA", "BSc", "BTech", "MCA"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                courses
        );

        spinnerCourse.setAdapter(adapter);

        btnStart.setOnClickListener(v -> {

            progress = 0;

            new Thread(() -> {

                while (progress <= 100) {

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progress++;

                    runOnUiThread(() ->
                            progressBar.setProgress(progress)
                    );
                }

                runOnUiThread(() -> {

                    String course = spinnerCourse.getSelectedItem().toString();
                    boolean toggle = toggleButton.isChecked();

                    String message =
                            "Course: " + course +
                                    "\nToggle: " + (toggle ? "ON" : "OFF");

                    Toast.makeText(MainActivity.this,
                            message,
                            Toast.LENGTH_LONG).show();
                });

            }).start();
        });
    }
}