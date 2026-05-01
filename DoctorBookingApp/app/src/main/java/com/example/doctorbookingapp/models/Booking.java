package com.example.doctorbookingapp.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Booking {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String doctor;
    public String datetime;
    public String status;

    public Booking(String name, String doctor, String datetime, String status) {
        this.name = name;
        this.doctor = doctor;
        this.datetime = datetime;
        this.status = status;
    }
}