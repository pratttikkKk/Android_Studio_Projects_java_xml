package com.example.doctorbookingapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Booking.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BookingDao bookingDao();
}