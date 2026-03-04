package com.smartmechanic.app.data.repository

import com.smartmechanic.app.data.model.*
import com.smartmechanic.app.data.remote.ApiService
import com.smartmechanic.app.data.remote.RetrofitClient

class MechanicRepository(private val apiService: ApiService = RetrofitClient.apiService) {
    
    suspend fun getMechanics(): Result<List<Mechanic>> {
        return try {
            val response = apiService.getMechanics()
            if (response.isSuccessful && response.body() != null && response.body()!!.success) {
                Result.success(response.body()!!.data)
            } else {
                Result.failure(Exception("Failed to get mechanics"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun getMechanic(id: String): Result<Mechanic> {
        return try {
            val response = apiService.getMechanic(id)
            if (response.isSuccessful && response.body() != null && response.body()!!.success) {
                Result.success(response.body()!!.data!!)
            } else {
                Result.failure(Exception("Failed to get mechanic"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun getMyProfile(): Result<Mechanic> {
        return try {
            val response = apiService.getMyProfile()
            if (response.isSuccessful && response.body() != null && response.body()!!.success) {
                Result.success(response.body()!!.data!!)
            } else {
                Result.failure(Exception("Failed to get profile"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun updateMyProfile(mechanic: Mechanic): Result<Mechanic> {
        return try {
            val response = apiService.updateMyProfile(mechanic)
            if (response.isSuccessful && response.body() != null && response.body()!!.success) {
                Result.success(response.body()!!.data!!)
            } else {
                Result.failure(Exception("Failed to update profile"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun updateAvailability(isAvailable: Boolean): Result<Mechanic> {
        return try {
            val response = apiService.updateAvailability(mapOf("isAvailable" to isAvailable))
            if (response.isSuccessful && response.body() != null && response.body()!!.success) {
                Result.success(response.body()!!.data!!)
            } else {
                Result.failure(Exception("Failed to update availability"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
