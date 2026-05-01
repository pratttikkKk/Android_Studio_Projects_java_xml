package com.example.doctorbookingapp;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.doctorbookingapp.models.Booking;
import com.example.doctorbookingapp.database.AppDatabase;

import java.util.List;

public class UserDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = new ListView(this);
        setContentView(listView);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "db")
                .allowMainThreadQueries()
                .build();

        List<Booking> bookings = db.bookingDao().getAll();

        ArrayAdapter<Booking> adapter = new ArrayAdapter<Booking>(this, 0, bookings) {

            @Override
            public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {

                LinearLayout card = new LinearLayout(getContext());
                card.setOrientation(LinearLayout.VERTICAL);
                card.setPadding(30, 30, 30, 30);
                card.setBackgroundResource(android.R.drawable.dialog_holo_light_frame);

                Booking b = bookings.get(position);

                TextView tv = new TextView(getContext());
                tv.setText(
                        "👨‍⚕️ " + b.doctor +
                                "\n📅 " + b.datetime +
                                "\n📌 Status: " + b.status
                );

                card.addView(tv);

                return card;
            }
        };

        listView.setAdapter(adapter);
    }
}