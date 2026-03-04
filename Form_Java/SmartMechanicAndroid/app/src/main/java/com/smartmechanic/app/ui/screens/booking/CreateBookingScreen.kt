package com.smartmechanic.app.ui.screens.booking

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.smartmechanic.app.data.model.*
import com.smartmechanic.app.data.repository.BookingRepository
import com.smartmechanic.app.data.repository.MechanicRepository
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateBookingScreen(navController: NavHostController, mechanicId: String) {
    var selectedServiceType by remember { mutableStateOf("general") }
    var vehicleMake by remember { mutableStateOf("") }
    var vehicleModel by remember { mutableStateOf("") }
    var vehicleYear by remember { mutableStateOf("") }
    var vehicleLicensePlate by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var scheduledDate by remember { mutableStateOf("") }
    var scheduledTime by remember { mutableStateOf("") }
    var estimatedCost by remember { mutableStateOf("") }
    var estimatedDuration by remember { mutableStateOf("60") }
    var isPickupRequired by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    
    val bookingRepository = remember { BookingRepository() }
    val mechanicRepository = remember { MechanicRepository() }
    val scope = rememberCoroutineScope()
    
    val serviceTypes = listOf("general", "repair", "maintenance", "inspection", "emergency", "detailing", "towing")
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Book Service") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Service Type
            Text(
                text = "Service Type",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            
            var expanded by remember { mutableStateOf(false) }
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it }
            ) {
                OutlinedTextField(
                    value = selectedServiceType.replaceFirstChar { it.uppercase() },
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    serviceTypes.forEach { type ->
                        DropdownMenuItem(
                            text = { Text(type.replaceFirstChar { it.uppercase() }) },
                            onClick = {
                                selectedServiceType = type
                                expanded = false
                            }
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Vehicle Info
            Text(
                text = "Vehicle Information",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            
            OutlinedTextField(
                value = vehicleMake,
                onValueChange = { vehicleMake = it },
                label = { Text("Make") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            OutlinedTextField(
                value = vehicleModel,
                onValueChange = { vehicleModel = it },
                label = { Text("Model") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = vehicleYear,
                    onValueChange = { vehicleYear = it },
                    label = { Text("Year") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
                OutlinedTextField(
                    value = vehicleLicensePlate,
                    onValueChange = { vehicleLicensePlate = it },
                    label = { Text("License Plate") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Description
            Text(
                text = "Problem Description",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Describe the issue") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                maxLines = 5
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Schedule
            Text(
                text = "Schedule",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            
            OutlinedTextField(
                value = scheduledDate,
                onValueChange = { scheduledDate = it },
                label = { Text("Date (YYYY-MM-DD)") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            OutlinedTextField(
                value = scheduledTime,
                onValueChange = { scheduledTime = it },
                label = { Text("Time (HH:MM)") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = estimatedDuration,
                    onValueChange = { estimatedDuration = it },
                    label = { Text("Duration (mins)") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
                OutlinedTextField(
                    value = estimatedCost,
                    onValueChange = { estimatedCost = it },
                    label = { Text("Estimated Cost") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Pickup Option
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isPickupRequired,
                    onCheckedChange = { isPickupRequired = it }
                )
                Text(
                    text = "Pickup Required",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            
            if (errorMessage.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Button(
                onClick = {
                    if (vehicleMake.isBlank() || vehicleModel.isBlank() || description.isBlank() || scheduledDate.isBlank() || scheduledTime.isBlank()) {
                        errorMessage = "Please fill all required fields"
                        return@Button
                    }
                    
                    scope.launch {
                        isLoading = true
                        errorMessage = ""
                        
                        val vehicle = Vehicle(
                            make = vehicleMake,
                            model = vehicleModel,
                            year = vehicleYear.toIntOrNull() ?: 0,
                            licensePlate = vehicleLicensePlate
                        )
                        
                        val request = CreateBookingRequest(
                            mechanicId = mechanicId,
                            vehicle = vehicle,
                            serviceType = selectedServiceType,
                            description = description,
                            symptoms = emptyList(),
                            scheduledDate = scheduledDate,
                            scheduledTime = scheduledTime,
                            estimatedDuration = estimatedDuration.toIntOrNull() ?: 60,
                            estimatedCost = estimatedCost.toDoubleOrNull() ?: 0.0,
                            isPickupRequired = isPickupRequired
                        )
                        
                        val result = bookingRepository.createBooking(request)
                        result.onSuccess {
                            navController.navigate("bookings") {
                                popUpTo(Screen.CreateBooking.route) { inclusive = true }
                            }
                        }.onFailure { e ->
                            errorMessage = e.message ?: "Failed to create booking"
                        }
                        isLoading = false
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                enabled = !isLoading
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text("Book Now")
                }
            }
        }
    }
}
