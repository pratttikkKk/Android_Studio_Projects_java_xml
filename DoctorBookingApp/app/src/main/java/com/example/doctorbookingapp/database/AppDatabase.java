package com.example.doctorbookingapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.doctorbookingapp.models.Booking;

@Database(entities = {Booking.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract BookingDao bookingDao();
}