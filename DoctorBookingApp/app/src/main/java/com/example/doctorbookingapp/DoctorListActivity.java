package com.example.doctorbookingapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import com.example.doctorbookingapp.models.Doctor;
import java.util.*;

public class DoctorListActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        RecyclerView rv = findViewById(R.id.recycler);

        rv.setLayoutManager(new LinearLayoutManager(this));

        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Sharma", "Cardiologist", "MBBS, MD", R.drawable.doc1),
                new Doctor("Dr. Mehta", "Dentist", "BDS, MDS", R.drawable.doc2),
                new Doctor("Dr. Patel", "General", "MBBS", R.drawable.doc3)
        );

        rv.setAdapter(new DoctorAdapter(this, doctors));
    }
}