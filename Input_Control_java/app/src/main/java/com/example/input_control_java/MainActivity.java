package com.example.input_control_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    CheckBox cbSports, cbMusic;
    ToggleButton toggleButton;
    Spinner spinnerCourse;
    RatingBar ratingBar;
    ProgressBar progressBar;
    ImageButton imageButton;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        cbSports = findViewById(R.id.cbSports);
        cbMusic = findViewById(R.id.cbMusic);
        toggleButton = findViewById(R.id.toggleButton);
        spinnerCourse = findViewById(R.id.spinnerCourse);
        ratingBar = findViewById(R.id.ratingBar);
        progressBar = findViewById(R.id.progressBar);
        imageButton = findViewById(R.id.imageButton);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Spinner Data
        String[] courses = {"BCA", "BSc", "BTech", "MCA"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                courses
        );
        spinnerCourse.setAdapter(adapter);

        // RatingBar -> ProgressBar Link
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) ->
                progressBar.setProgress((int) rating)
        );

        // Image Button Click
        imageButton.setOnClickListener(v ->
                Toast.makeText(this, "Image Button Clicked!", Toast.LENGTH_SHORT).show()
        );

        // Submit Button
        btnSubmit.setOnClickListener(v -> {

            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadio = findViewById(selectedId);

            String gender = selectedRadio != null ? selectedRadio.getText().toString() : "Not Selected";

            String hobbies = "";
            if (cbSports.isChecked()) hobbies += "Sports ";
            if (cbMusic.isChecked()) hobbies += "Music ";

            String toggleStatus = toggleButton.isChecked() ? "ON" : "OFF";
            String course = spinnerCourse.getSelectedItem().toString();
            float rating = ratingBar.getRating();

            String message =
                    "Gender: " + gender +
                            "\nHobbies: " + hobbies +
                            "\nNotifications: " + toggleStatus +
                            "\nCourse: " + course +
                            "\nRating: " + rating;

            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        });
    }
}