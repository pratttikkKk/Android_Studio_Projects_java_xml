package com.example.doctorbookingapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.*;

public class ViewActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "db")
                .allowMainThreadQueries()
                .build();

        List<Booking> list = db.bookingDao().getAll();

        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);

        for (Booking b : list) {

            LinearLayout card = new LinearLayout(this);
            card.setOrientation(LinearLayout.VERTICAL);
            card.setPadding(20,20,20,20);

            TextView tv = new TextView(this);
            tv.setText(b.name + "\n" + b.doctor + "\n" + b.datetime + "\nStatus: " + b.status);

            Button accept = new Button(this);
            accept.setText("Accept");

            Button reject = new Button(this);
            reject.setText("Reject");

            accept.setOnClickListener(v -> {
                db.bookingDao().updateStatus(b.id, "Accepted");
                recreate();
            });

            reject.setOnClickListener(v -> {
                db.bookingDao().updateStatus(b.id, "Rejected");
                recreate();
            });

            card.addView(tv);
            card.addView(accept);
            card.addView(reject);

            container.addView(card);
        }

        ScrollView scroll = new ScrollView(this);
        scroll.addView(container);

        setContentView(scroll);
    }
}