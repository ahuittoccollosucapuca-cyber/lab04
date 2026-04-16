package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import com.example.lab04.ui.theme.Lab04Theme
import com.example.lab04.ui.containers.ContainersScreen

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Lab04Theme {
                ContainersScreen() // 👈 SOLO llamas tu pantalla
            }
        }
    }
}