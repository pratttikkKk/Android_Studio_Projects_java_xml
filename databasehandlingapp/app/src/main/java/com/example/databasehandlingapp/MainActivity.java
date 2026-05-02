package com.example.databasehandlingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText etId, etName, etCourse;
    Button btnInsert, btnView, btnUpdate, btnDelete;
    TextView tvResult;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etCourse = findViewById(R.id.etCourse);

        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        tvResult = findViewById(R.id.tvResult);

        db = new DBHelper(this);

        // 🔥 Button Animation Effect
        View.OnTouchListener scaleEffect = (v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    v.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).start();
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    v.animate().scaleX(1f).scaleY(1f).setDuration(100).start();
                    break;
            }
            return false;
        };

        btnInsert.setOnTouchListener(scaleEffect);
        btnView.setOnTouchListener(scaleEffect);
        btnUpdate.setOnTouchListener(scaleEffect);
        btnDelete.setOnTouchListener(scaleEffect);

        // 🟢 INSERT
        btnInsert.setOnClickListener(v -> {

            if (!validateInput()) return;

            boolean result = db.insertData(
                    Integer.parseInt(etId.getText().toString()),
                    etName.getText().toString(),
                    etCourse.getText().toString()
            );

            Toast.makeText(this,
                    result ? "✅ Data Inserted" : "❌ Insert Failed",
                    Toast.LENGTH_SHORT).show();

            clearFields();
        });

        // 🟢 VIEW
        btnView.setOnClickListener(v -> {

            Cursor cursor = db.getData();

            if (cursor.getCount() == 0) {
                tvResult.setText("No Data Found");
                return;
            }

            StringBuilder data = new StringBuilder();

            while (cursor.moveToNext()) {
                data.append("ID: ").append(cursor.getInt(0)).append("\n");
                data.append("Name: ").append(cursor.getString(1)).append("\n");
                data.append("Course: ").append(cursor.getString(2)).append("\n\n");
            }

            tvResult.setText(data.toString());
        });

        // 🟢 UPDATE
        btnUpdate.setOnClickListener(v -> {

            if (!validateInput()) return;

            boolean result = db.updateData(
                    Integer.parseInt(etId.getText().toString()),
                    etName.getText().toString(),
                    etCourse.getText().toString()
            );

            Toast.makeText(this,
                    result ? "🔄 Data Updated" : "❌ Update Failed",
                    Toast.LENGTH_SHORT).show();

            clearFields();
        });

        // 🟢 DELETE
        btnDelete.setOnClickListener(v -> {

            if (TextUtils.isEmpty(etId.getText())) {
                etId.setError("Enter ID");
                return;
            }

            boolean result = db.deleteData(
                    Integer.parseInt(etId.getText().toString())
            );

            Toast.makeText(this,
                    result ? "🗑 Data Deleted" : "❌ Delete Failed",
                    Toast.LENGTH_SHORT).show();

            clearFields();
        });
    }

    // 🔹 INPUT VALIDATION
    private boolean validateInput() {

        if (TextUtils.isEmpty(etId.getText())) {
            etId.setError("Enter ID");
            return false;
        }

        if (TextUtils.isEmpty(etName.getText())) {
            etName.setError("Enter Name");
            return false;
        }

        if (TextUtils.isEmpty(etCourse.getText())) {
            etCourse.setError("Enter Course");
            return false;
        }

        return true;
    }

    // 🔹 CLEAR FIELDS
    private void clearFields() {
        etId.setText("");
        etName.setText("");
        etCourse.setText("");
    }
}