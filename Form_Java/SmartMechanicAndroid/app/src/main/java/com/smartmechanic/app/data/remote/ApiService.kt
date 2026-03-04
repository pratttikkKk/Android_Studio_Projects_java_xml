package com.smartmechanic.app.data.remote

import com.smartmechanic.app.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    // Auth endpoints
    @POST("api/auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>
    
    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>
    
    @GET("api/auth/logout")
    suspend fun logout(): Response<AuthResponse>
    
    @GET("api/auth/me")
    suspend fun getCurrentUser(): Response<AuthResponse>
    
    @PUT("api/auth/profile")
    suspend fun updateProfile(@Body user: User): Response<AuthResponse>
    
    @POST("api/auth/forgotpassword")
    suspend fun forgotPassword(@Body email: Map<String, String>): Response<ApiResponse<String>>
    
    // Mechanics endpoints
    @GET("api/mechanics")
    suspend fun getMechanics(): Response<MechanicListResponse>
    
    @GET("api/mechanics/{id}")
    suspend fun getMechanic(@Path("id") id: String): Response<MechanicResponse>
    
    @GET("api/mechanics/me/profile")
    suspend fun getMyProfile(): Response<MechanicResponse>
    
    @PUT("api/mechanics/me")
    suspend fun updateMyProfile(@Body mechanic: Mechanic): Response<MechanicResponse>
    
    @PUT("api/mechanics/me/availability")
    suspend fun updateAvailability(@Body availability: Map<String, Boolean>): Response<MechanicResponse>
    
    // Bookings endpoints
    @POST("api/bookings")
    suspend fun createBooking(@Body request: CreateBookingRequest): Response<BookingResponse>
    
    @GET("api/bookings")
    suspend fun getBookings(): Response<BookingListResponse>
    
    @GET("api/bookings/{id}")
    suspend fun getBooking(@Path("id") id: String): Response<BookingResponse>
    
    @GET("api/bookings/mechanic/{mechanicId}")
    suspend fun getMechanicBookings(@Path("mechanicId") mechanicId: String): Response<BookingListResponse>
    
    @PUT("api/bookings/{id}/status")
    suspend fun updateBookingStatus(
        @Path("id") id: String,
        @Body status: Map<String, String>
    ): Response<BookingResponse>
    
    @PUT("api/bookings/{id}/cancel")
    suspend fun cancelBooking(
        @Path("id") id: String,
        @Body reason: Map<String, String>
    ): Response<BookingResponse>
    
    // Reviews endpoints
    @POST("api/reviews")
    suspend fun createReview(@Body request: CreateReviewRequest): Response<ReviewResponse>
    
    @GET("api/reviews/mechanic/{mechanicId}")
    suspend fun getMechanicReviews(@Path("mechanicId") mechanicId: String): Response<ReviewListResponse>
    
    // Payments endpoints
    @POST("api/payments")
    suspend fun createPayment(@Body request: CreatePaymentRequest): Response<PaymentResponse>
    
    @GET("api/payments/booking/{bookingId}")
    suspend fun getPaymentByBooking(@Path("bookingId") bookingId: String): Response<PaymentResponse>
    
    // Admin endpoints
    @GET("api/admin/users")
    suspend fun getAllUsers(): Response<ApiResponse<List<User>>>
    
    @PUT("api/admin/users/{id}/verify")
    suspend fun verifyUser(@Path("id") id: String): Response<ApiResponse<User>>
    
    @GET("api/admin/stats")
    suspend fun getAdminStats(): Response<ApiResponse<Map<String, Any>>>
}
