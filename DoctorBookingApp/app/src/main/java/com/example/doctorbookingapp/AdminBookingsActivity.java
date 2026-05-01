package com.example.doctorbookingapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.*;

import com.example.doctorbookingapp.models.Booking;
import com.example.doctorbookingapp.database.AppDatabase;

public class AdminBookingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String doctor = getIntent().getStringExtra("doctor");

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "db")
                .allowMainThreadQueries()
                .build();

        List<Booking> all = db.bookingDao().getAll();
        List<Booking> filtered = new ArrayList<>();

        for (Booking b : all) {
            if (b.doctor.equals(doctor)) filtered.add(b);
        }

        // Sort: Accepted first
        Collections.sort(filtered, (a, b) -> b.status.compareTo(a.status));

        ListView list = new ListView(this);
        list.setPadding(10, 10, 10, 10);
        setContentView(list);

        ArrayAdapter<Booking> adapter = new ArrayAdapter<Booking>(this, 0, filtered) {

            @Override
            public android.view.View getView(int pos, android.view.View convertView, android.view.ViewGroup parent) {

                Booking b = filtered.get(pos);

                // CARD CONTAINER
                LinearLayout card = new LinearLayout(getContext());
                card.setOrientation(LinearLayout.VERTICAL);
                card.setPadding(30, 30, 30, 30);
                card.setBackgroundResource(R.drawable.bg_card);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(20, 20, 20, 20);
                card.setLayoutParams(params);

                // TEXT
                TextView tv = new TextView(getContext());
                tv.setText(
                        "👤 " + b.name +
                                "\n👨‍⚕️ " + b.doctor +
                                "\n📅 " + b.datetime +
                                "\nStatus: " + b.status
                );
                tv.setTextSize(15);

                // STATUS COLOR
                if (b.status.equals("Accepted")) {
                    tv.setTextColor(0xFF2E7D32); // green
                } else if (b.status.equals("Rejected")) {
                    tv.setTextColor(0xFFC62828); // red
                } else {
                    tv.setTextColor(0xFFF9A825); // yellow
                }

                // BUTTON ROW
                LinearLayout btnRow = new LinearLayout(getContext());
                btnRow.setOrientation(LinearLayout.HORIZONTAL);
                btnRow.setPadding(0, 20, 0, 0);

                Button accept = new Button(getContext());
                accept.setText("Accept");
                accept.setTextColor(0xFFFFFFFF);
                accept.setBackgroundTintList(
                        android.content.res.ColorStateList.valueOf(0xFF4CAF50)
                );

                Button reject = new Button(getContext());
                reject.setText("Reject");
                reject.setTextColor(0xFFFFFFFF);
                reject.setBackgroundTintList(
                        android.content.res.ColorStateList.valueOf(0xFFE53935)
                );

                LinearLayout.LayoutParams btnParams =
                        new LinearLayout.LayoutParams(0,
                                LinearLayout.LayoutParams.WRAP_CONTENT, 1);

                accept.setLayoutParams(btnParams);
                reject.setLayoutParams(btnParams);

                accept.setOnClickListener(v1 -> {
                    db.bookingDao().updateStatus(b.id, "Accepted");
                    recreate();
                });

                reject.setOnClickListener(v1 -> {
                    db.bookingDao().updateStatus(b.id, "Rejected");
                    recreate();
                });

                btnRow.addView(accept);
                btnRow.addView(reject);

                // ADD VIEWS
                card.addView(tv);
                card.addView(btnRow);

                return card;
            }
        };

        list.setAdapter(adapter);
    }
}