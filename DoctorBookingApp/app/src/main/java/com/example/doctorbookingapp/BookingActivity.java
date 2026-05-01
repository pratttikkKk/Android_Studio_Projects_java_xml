package com.example.doctorbookingapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.doctorbookingapp.models.Booking;
import com.example.doctorbookingapp.database.AppDatabase;

import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {

    EditText name;
    TextView date, slotInfo, selectedDoctorText;
    Button slot1, slot2, slot3, save;

    String selectedDate = "";
    String selectedSlot = "";
    String doctor;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "db")
                .allowMainThreadQueries()
                .build();

        name = findViewById(R.id.name);
        date = findViewById(R.id.date);
        slotInfo = findViewById(R.id.slotInfo);
        selectedDoctorText = findViewById(R.id.selectedDoctorText);

        slot1 = findViewById(R.id.slot1);
        slot2 = findViewById(R.id.slot2);
        slot3 = findViewById(R.id.slot3);
        save = findViewById(R.id.save);

        doctor = getIntent().getStringExtra("doctor");
        selectedDoctorText.setText("Doctor: " + doctor);

        date.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();

            new DatePickerDialog(this, (view, y, m, d) -> {
                selectedDate = d + "/" + (m + 1) + "/" + y;
                date.setText(selectedDate);
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
        });

        slot1.setOnClickListener(v -> selectedSlot = "10:00 AM");
        slot2.setOnClickListener(v -> selectedSlot = "12:00 PM");
        slot3.setOnClickListener(v -> selectedSlot = "3:00 PM");

        save.setOnClickListener(v -> {

            if (name.getText().toString().isEmpty() ||
                    selectedDate.isEmpty() ||
                    selectedSlot.isEmpty()) {

                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            String datetime = selectedDate + " " + selectedSlot;

            db.bookingDao().insert(new Booking(
                    name.getText().toString(),
                    doctor,
                    datetime,
                    "Pending"
            ));

            Toast.makeText(this, "Booking Done", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}