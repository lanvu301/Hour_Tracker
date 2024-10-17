package com.example.hours_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.hours_tracker.screen.HomeScreen
import com.example.hours_tracker.ui.theme.HoursTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoursTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    HomeScreen() // Call HomeScreen
                }
            }
        }
    }
}
