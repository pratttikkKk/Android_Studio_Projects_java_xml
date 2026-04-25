package com.example.doctorbookingapp;

import androidx.room.*;
import java.util.List;

@Dao
public interface BookingDao {

    @Insert
    void insert(Booking booking);

    @Query("SELECT * FROM Booking")
    List<Booking> getAll();

    // count bookings for a slot (doctor + datetime)
    @Query("SELECT COUNT(*) FROM Booking WHERE doctor = :doctor AND datetime = :datetime")
    int countSlot(String doctor, String datetime);

    @Query("UPDATE Booking SET status = :status WHERE id = :id")
    void updateStatus(int id, String status);
}