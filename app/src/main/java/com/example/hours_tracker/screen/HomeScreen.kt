package com.example.hours_tracker.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hours_tracker.viewmodels.MainViewModel

@OptIn(ExperimentalMaterial3Api::class) // Suppress experimental warning
@Composable
fun HomeScreen(viewModel: MainViewModel = viewModel()) {
    var hoursWorked by remember { mutableStateOf("") }
    var payRate by remember { mutableStateOf("") }
    var totalPay by remember { mutableStateOf(0.0) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(
            value = hoursWorked,
            onValueChange = { hoursWorked = it },
            label = { Text("Enter Hours Worked") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = payRate,
            onValueChange = { payRate = it },
            label = { Text("Enter Pay Rate") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val hours = hoursWorked.toDoubleOrNull() ?: 0.0
            val rate = payRate.toDoubleOrNull() ?: 0.0
            viewModel.logHours(hours)
            totalPay = calculateTotalPay(hours, rate)
            hoursWorked = ""
            payRate = ""
        }) {
            Text("Log Hours and Calculate Pay")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Logged Hours:", style = MaterialTheme.typography.titleMedium)
        viewModel.hoursLog.forEach {
            Text(it.toString(), style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Total Pay: $${totalPay}", style = MaterialTheme.typography.titleMedium)
    }
}

// Function to calculate total pay
private fun calculateTotalPay(hours: Double, rate: Double): Double {
    return hours * rate
}
