package com.example.doctorbookingapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.*;
import com.example.doctorbookingapp.models.Booking;
import com.example.doctorbookingapp.database.AppDatabase;
import com.example.doctorbookingapp.database.BookingDao;

public class AdminBookingsActivity extends AppCompatActivity {

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

        // Accepted first
        Collections.sort(filtered, (a,b) -> b.status.compareTo(a.status));

        ListView list = new ListView(this);
        setContentView(list);

        ArrayAdapter<Booking> adapter = new ArrayAdapter<Booking>(this,0,filtered){
            public android.view.View getView(int pos, android.view.View v, android.view.ViewGroup p){

                LinearLayout layout = new LinearLayout(getContext());
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.setPadding(20,20,20,20);

                Booking b = filtered.get(pos);

                TextView tv = new TextView(getContext());
                tv.setText(b.name + "\n" + b.datetime + "\nStatus: " + b.status);

                Button accept = new Button(getContext());
                accept.setText("Accept");

                Button reject = new Button(getContext());
                reject.setText("Reject");

                accept.setOnClickListener(v1 -> {
                    db.bookingDao().updateStatus(b.id,"Accepted");
                    recreate();
                });

                reject.setOnClickListener(v1 -> {
                    db.bookingDao().updateStatus(b.id,"Rejected");
                    recreate();
                });

                layout.addView(tv);
                layout.addView(accept);
                layout.addView(reject);

                return layout;
            }
        };

        list.setAdapter(adapter);
    }
}