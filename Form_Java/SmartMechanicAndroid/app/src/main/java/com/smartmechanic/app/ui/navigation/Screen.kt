package com.smartmechanic.app.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Register : Screen("register")
    object ForgotPassword : Screen("forgot_password")
    object Home : Screen("home")
    object MechanicList : Screen("mechanic_list")
    object MechanicDetail : Screen("mechanic_detail/{mechanicId}") {
        fun createRoute(mechanicId: String) = "mechanic_detail/$mechanicId"
    }
    object CreateBooking : Screen("create_booking/{mechanicId}") {
        fun createRoute(mechanicId: String) = "create_booking/$mechanicId"
    }
    object BookingList : Screen("bookings")
    object BookingDetail : Screen("booking_detail/{bookingId}") {
        fun createRoute(bookingId: String) = "booking_detail/$bookingId"
    }
    object Chat : Screen("chat/{bookingId}") {
        fun createRoute(bookingId: String) = "chat/$bookingId"
    }
    object Profile : Screen("profile")
    object EditProfile : Screen("edit_profile")
    object Payment : Screen("payment/{bookingId}") {
        fun createRoute(bookingId: String) = "payment/$bookingId"
    }
}
