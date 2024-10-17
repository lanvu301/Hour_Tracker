package com.example.hours_tracker.viewmodels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf

class MainViewModel : ViewModel() {
    // List to hold logged hours
    private val _hoursLog = mutableStateListOf<Double>()
    val hoursLog: List<Double> = _hoursLog

    // Function to log hours
    fun logHours(hours: Double) {
        if (hours > 0) {
            _hoursLog.add(hours)
        }
    }
}
