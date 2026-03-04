package com.smartmechanic.app.data.repository

import com.smartmechanic.app.data.model.*
import com.smartmechanic.app.data.remote.ApiService
import com.smartmechanic.app.data.remote.RetrofitClient

class BookingRepository(private val apiService: ApiService = RetrofitClient.apiService) {
    
    suspend fun createBooking(request: CreateBookingRequest): Result<Booking> {
        return try {
            val response = apiService.createBooking(request)
            if (response.isSuccessful && response.body() != null && response.body()!!.success) {
                Result.success(response.body()!!.data!!)
            } else {
                Result.failure(Exception(response.body()?.message ?: "Failed to create booking"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun getBookings(): Result<List<Booking>> {
        return try {
            val response = apiService.getBookings()
            if (response.isSuccessful && response.body() != null && response.body()!!.success) {
                Result.success(response.body()!!.data)
            } else {
                Result.failure(Exception("Failed to get bookings"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun getBooking(id: String): Result<Booking> {
        return try {
            val response = apiService.getBooking(id)
            if (response.isSuccessful && response.body() != null && response.body()!!.success) {
                Result.success(response.body()!!.data!!)
            } else {
                Result.failure(Exception("Failed to get booking"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun getMechanicBookings(mechanicId: String): Result<List<Booking>> {
        return try {
            val response = apiService.getMechanicBookings(mechanicId)
            if (response.isSuccessful && response.body() != null && response.body()!!.success) {
                Result.success(response.body()!!.data)
            } else {
                Result.failure(Exception("Failed to get mechanic bookings"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun updateBookingStatus(bookingId: String, status: String): Result<Booking> {
        return try {
            val response = apiService.updateBookingStatus(bookingId, mapOf("status" to status))
            if (response.isSuccessful && response.body() != null && response.body()!!.success) {
                Result.success(response.body()!!.data!!)
            } else {
                Result.failure(Exception("Failed to update booking status"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun cancelBooking(bookingId: String, reason: String): Result<Booking> {
        return try {
            val response = apiService.cancelBooking(bookingId, mapOf("reason" to reason))
            if (response.isSuccessful && response.body() != null && response.body()!!.success) {
                Result.success(response.body()!!.data!!)
            } else {
                Result.failure(Exception("Failed to cancel booking"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
