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
import com.example.lab04.ui.advanced.AdvancedScreen
import androidx.compose.foundation.layout.*
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Lab04Theme {

                var screen by remember { mutableStateOf(0) }

                Column {

                    Row {
                        Button(onClick = { screen = 0 }) {
                            Text("Contenedores")
                        }
                        Button(onClick = { screen = 1 }) {
                            Text("Controles")
                        }
                        Button(onClick = { screen = 2 }) {
                            Text("Avanzado")
                        }
                    }

                    when (screen) {
                        0 -> ContainersScreen()
                        1 -> ControlsScreen()
                        2 -> AdvancedScreen()
                    }
                }
            }
        }
    }
}