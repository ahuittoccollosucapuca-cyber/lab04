package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import com.example.lab04.ui.containers.ContainersScreen
import com.example.lab04.ui.theme.Lab04Theme
import com.example.lab04.ui.controls.ControlsScreen
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var showControls by remember { mutableStateOf(true) }

            Column {

                Button(onClick = { showControls = !showControls }) {
                    Text("Cambiar pantalla")
                }

                if (showControls) {
                    ControlsScreen()
                } else {
                    ContainersScreen()
                }
            }
        }
    }
}