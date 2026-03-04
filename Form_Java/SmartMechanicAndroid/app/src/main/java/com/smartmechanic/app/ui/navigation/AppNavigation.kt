package com.smartmechanic.app.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.smartmechanic.app.ui.screens.auth.LoginScreen
import com.smartmechanic.app.ui.screens.auth.RegisterScreen
import com.smartmechanic.app.ui.screens.home.HomeScreen
import com.smartmechanic.app.ui.screens.mechanic.MechanicListScreen
import com.smartmechanic.app.ui.screens.mechanic.MechanicDetailScreen
import com.smartmechanic.app.ui.screens.booking.CreateBookingScreen
import com.smartmechanic.app.ui.screens.booking.BookingListScreen
import com.smartmechanic.app.ui.screens.booking.BookingDetailScreen
import com.smartmechanic.app.ui.screens.profile.ProfileScreen
import com.smartmechanic.app.ui.screens.profile.EditProfileScreen
import com.smartmechanic.app.ui.screens.chat.ChatScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    val showBottomBar = currentRoute in listOf(
        Screen.Home.route,
        Screen.MechanicList.route,
        Screen.BookingList.route,
        Screen.Profile.route
    )
    
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            // Auth screens
            composable(Screen.Login.route) {
                LoginScreen(navController = navController)
            }
            composable(Screen.Register.route) {
                RegisterScreen(navController = navController)
            }
            
            // Main screens
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(Screen.MechanicList.route) {
                MechanicListScreen(navController = navController)
            }
            composable(
                route = Screen.MechanicDetail.route,
                arguments = listOf(navArgument("mechanicId") { type = NavType.StringType })
            ) { backStackEntry ->
                val mechanicId = backStackEntry.arguments?.getString("mechanicId") ?: ""
                MechanicDetailScreen(navController = navController, mechanicId = mechanicId)
            }
            composable(
                route = Screen.CreateBooking.route,
                arguments = listOf(navArgument("mechanicId") { type = NavType.StringType })
            ) { backStackEntry ->
                val mechanicId = backStackEntry.arguments?.getString("mechanicId") ?: ""
                CreateBookingScreen(navController = navController, mechanicId = mechanicId)
            }
            composable(Screen.BookingList.route) {
                BookingListScreen(navController = navController)
            }
            composable(
                route = Screen.BookingDetail.route,
                arguments = listOf(navArgument("bookingId") { type = NavType.StringType })
            ) { backStackEntry ->
                val bookingId = backStackEntry.arguments?.getString("bookingId") ?: ""
                BookingDetailScreen(navController = navController, bookingId = bookingId)
            }
            composable(
                route = Screen.Chat.route,
                arguments = listOf(navArgument("bookingId") { type = NavType.StringType })
            ) { backStackEntry ->
                val bookingId = backStackEntry.arguments?.getString("bookingId") ?: ""
                ChatScreen(navController = navController, bookingId = bookingId)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController = navController)
            }
            composable(Screen.EditProfile.route) {
                EditProfileScreen(navController = navController)
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem(Screen.Home.route, "Home", Icons.Default.Home),
        BottomNavItem(Screen.MechanicList.route, "Mechanics", Icons.Default.Person),
        BottomNavItem(Screen.BookingList.route, "Bookings", Icons.Default.List),
        BottomNavItem(Screen.Profile.route, "Profile", Icons.Default.Person)
    )
    
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(Screen.Home.route) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

data class BottomNavItem(
    val route: String,
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)
