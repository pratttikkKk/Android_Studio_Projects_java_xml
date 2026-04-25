package com.example.doctorbookingapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {

    EditText name;
    Spinner doctorSpinner, timeSpinner;
    TextView date, slotInfo;
    String selectedDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "db")
                .allowMainThreadQueries()
                .build();

        name = findViewById(R.id.name);
        doctorSpinner = findViewById(R.id.doctorSpinner);
        timeSpinner = findViewById(R.id.timeSpinner);
        date = findViewById(R.id.date);
        slotInfo = findViewById(R.id.slotInfo);

        Button save = findViewById(R.id.save);

        String[] doctors = {
                "Dr. Sharma - Cardiologist",
                "Dr. Mehta - Dentist",
                "Dr. Patel - General"
        };

        doctorSpinner.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, doctors));

        String[] slots = {"10:00 AM", "12:00 PM", "3:00 PM"};

        timeSpinner.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, slots));

        // DATE PICKER
        date.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new DatePickerDialog(this, (view, y, m, d) -> {
                selectedDate = d + "/" + (m+1) + "/" + y;
                date.setText(selectedDate);
                updateSlotInfo(db);
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
        });

        // UPDATE SLOT INFO WHEN CHANGE
        timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int pos, long id) {
                updateSlotInfo(db);
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        doctorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int pos, long id) {
                updateSlotInfo(db);
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // SAVE
        save.setOnClickListener(v -> {

            if (name.getText().toString().isEmpty() || selectedDate.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            String doctor = doctorSpinner.getSelectedItem().toString();
            String time = timeSpinner.getSelectedItem().toString();
            String datetime = selectedDate + " " + time;

            int count = db.bookingDao().countSlot(doctor, datetime);

            if (count >= 10) {
                Toast.makeText(this, "Slot FULL!", Toast.LENGTH_SHORT).show();
                return;
            }

            db.bookingDao().insert(new Booking(
                    name.getText().toString(),
                    doctor,
                    datetime,
                    "Pending"
            ));

            Toast.makeText(this, "Booking Requested!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void updateSlotInfo(AppDatabase db) {
        if (selectedDate.isEmpty()) return;

        String doctor = doctorSpinner.getSelectedItem().toString();
        String time = timeSpinner.getSelectedItem().toString();
        String datetime = selectedDate + " " + time;

        int count = db.bookingDao().countSlot(doctor, datetime);
        int remaining = 10 - count;

        slotInfo.setText("Remaining Slots: " + remaining + "/10");
    }
}