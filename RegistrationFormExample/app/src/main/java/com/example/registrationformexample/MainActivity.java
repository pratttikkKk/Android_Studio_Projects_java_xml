package com.example.registrationformexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button b;
    CheckBox c1, c2;
    ToggleButton t1;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);

        c1 = findViewById(R.id.terms);
        c2 = findViewById(R.id.privacy);

        t1 = findViewById(R.id.darkMode);

        rg = findViewById(R.id.gender);

        b = findViewById(R.id.submit);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              ;

                Toast.makeText(MainActivity.this,
                        "Registered Successfully",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}