package com.example.doctorbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class AdminDoctorActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView list = new ListView(this);
        setContentView(list);

        List<String> doctors = Arrays.asList(
                "Dr. Sharma - Cardiologist",
                "Dr. Mehta - Dentist",
                "Dr. Patel - General"
        );

        list.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, doctors));

        list.setOnItemClickListener((p,v,pos,id)->{
            Intent i = new Intent(this, AdminBookingsActivity.class);
            i.putExtra("doctor", doctors.get(pos));
            startActivity(i);
        });
    }
}