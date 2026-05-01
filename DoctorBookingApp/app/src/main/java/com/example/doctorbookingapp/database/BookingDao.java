package com.example.doctorbookingapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.doctorbookingapp.models.Booking;

import java.util.List;

@Dao
public interface BookingDao {

    @Insert
    void insert(Booking booking);

    @Query("SELECT * FROM Booking")
    List<Booking> getAll();

    // Count bookings for slot (IMPORTANT)
    @Query("SELECT COUNT(*) FROM Booking WHERE doctor = :doctor AND datetime = :datetime")
    int countSlot(String doctor, String datetime);

    // Update status (Accept / Reject)
    @Query("UPDATE Booking SET status = :status WHERE id = :id")
    void updateStatus(int id, String status);
}