package com.smartmechanic.app.data.model

import com.google.gson.annotations.SerializedName

// User Models
data class User(
    @SerializedName("_id") val id: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val role: String = "user",
    val profileImage: String = "",
    val address: Address? = null,
    val isVerified: Boolean = false,
    val createdAt: String = ""
)

data class Address(
    val street: String = "",
    val city: String = "",
    val state: String = "",
    val zipCode: String = "",
    val country: String = ""
)

data class LoginRequest(
    val email: String,
    val password: String
)

data class RegisterRequest(
    val name: String,
    val email: String,
    val phone: String,
    val password: String
)

data class AuthResponse(
    val success: Boolean = false,
    val token: String = "",
    val user: User? = null,
    val message: String = ""
)

// Mechanic Model
data class Mechanic(
    @SerializedName("_id") val id: String = "",
    val user: User? = null,
    val specialization: List<String> = listOf(),
    val experience: Int = 0,
    val rating: Double = 0.0,
    val totalReviews: Int = 0,
    val isAvailable: Boolean = false,
    val serviceArea: ServiceArea? = null,
    val hourlyRate: Double = 0.0,
    val profileImage: String = "",
    val bio: String = "",
    val certifications: List<String> = listOf(),
    val createdAt: String = ""
)

data class ServiceArea(
    val city: String = "",
    val radius: Int = 0 // in km
)

data class MechanicResponse(
    val success: Boolean = false,
    val data: Mechanic? = null,
    val message: String = ""
)

data class MechanicListResponse(
    val success: Boolean = false,
    val data: List<Mechanic> = listOf(),
    val count: Int = 0
)

// Booking Models
data class Booking(
    @SerializedName("_id") val id: String = "",
    val user: String = "",
    val mechanic: Mechanic? = null,
    val vehicle: Vehicle? = null,
    val serviceType: String = "",
    val description: String = "",
    val symptoms: List<String> = listOf(),
    val scheduledDate: String = "",
    val scheduledTime: String = "",
    val estimatedDuration: Int = 0,
    val estimatedCost: Double = 0.0,
    val status: String = "pending",
    val location: Location? = null,
    val isPickupRequired: Boolean = false,
    val parts: List<Part> = listOf(),
    val laborCost: Double = 0.0,
    val totalCost: Double = 0.0,
    val paymentStatus: String = "pending",
    val notes: List<Note> = listOf(),
    val createdAt: String = ""
)

data class Vehicle(
    val make: String = "",
    val model: String = "",
    val year: Int = 0,
    val licensePlate: String = "",
    val VIN: String = "",
    val mileage: Int = 0,
    val fuelType: String = "petrol"
)

data class Location(
    val type: String = "Point",
    val address: String = "",
    val coordinates: List<Double> = listOf()
)

data class Part(
    val partName: String = "",
    val partNumber: String = "",
    val quantity: Int = 1,
    val unitPrice: Double = 0.0,
    val isOriginal: Boolean = true
)

data class Note(
    val text: String = "",
    val addedBy: String = "",
    val createdAt: String = ""
)

data class CreateBookingRequest(
    val mechanicId: String,
    val vehicle: Vehicle,
    val serviceType: String,
    val description: String,
    val symptoms: List<String>,
    val scheduledDate: String,
    val scheduledTime: String,
    val estimatedDuration: Int,
    val estimatedCost: Double,
    val isPickupRequired: Boolean = false,
    val pickupAddress: Address? = null
)

data class BookingResponse(
    val success: Boolean = false,
    val data: Booking? = null,
    val message: String = ""
)

data class BookingListResponse(
    val success: Boolean = false,
    val data: List<Booking> = listOf(),
    val count: Int = 0
)

// Review Models
data class Review(
    @SerializedName("_id") val id: String = "",
    val booking: String = "",
    val user: User? = null,
    val mechanic: String = "",
    val rating: Int = 0,
    val comment: String = "",
    val createdAt: String = ""
)

data class CreateReviewRequest(
    val bookingId: String,
    val mechanicId: String,
    val rating: Int,
    val comment: String
)

data class ReviewResponse(
    val success: Boolean = false,
    val data: Review? = null,
    val message: String = ""
)

data class ReviewListResponse(
    val success: Boolean = false,
    val data: List<Review> = listOf(),
    val count: Int = 0
)

// Payment Models
data class Payment(
    @SerializedName("_id") val id: String = "",
    val booking: String = "",
    val user: String = "",
    val amount: Double = 0.0,
    val method: String = "",
    val status: String = "pending",
    val transactionId: String = "",
    val createdAt: String = ""
)

data class CreatePaymentRequest(
    val bookingId: String,
    val amount: Double,
    val method: String = "card"
)

data class PaymentResponse(
    val success: Boolean = false,
    val data: Payment? = null,
    val message: String = ""
)

// API Response wrapper
data class ApiResponse<T>(
    val success: Boolean = false,
    val data: T? = null,
    val message: String = ""
)

data class Message(
    val _id: String = "",
    val bookingId: String = "",
    val sender: String = "",
    val text: String = "",
    val createdAt: String = ""
)
