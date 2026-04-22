package com.example.file_handling_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText etData;
    Button btnSave, btnRead;
    TextView tvOutput;

    String fileName = "myFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = findViewById(R.id.etData);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
        tvOutput = findViewById(R.id.tvOutput);

        // SAVE DATA
        btnSave.setOnClickListener(v -> {

            String data = etData.getText().toString();

            try {
                FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();

                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error Saving File", Toast.LENGTH_SHORT).show();
            }
        });

        // READ DATA
        btnRead.setOnClickListener(v -> {

            try {
                FileInputStream fis = openFileInput(fileName);
                int i;
                String data = "";

                while ((i = fis.read()) != -1) {
                    data += (char) i;
                }

                fis.close();

                tvOutput.setText(data);

                Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error Reading File", Toast.LENGTH_SHORT).show();
            }
        });
    }
}