package com.example.lab04.ui.controls

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ControlsScreen() {

    // 🔥 ESTADOS
    var text by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    var sliderValue by remember { mutableStateOf(0f) }
    var showDialog by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("A") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Controles + Estado") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "FAB")
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // 🔹 TextField
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            // 🔹 Checkbox
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it }
                )
                Text("Aceptar términos")
            }

            // 🔹 Switch
            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it }
                )
                Text("Activar opción")
            }

            // 🔹 Slider
            Text("Valor: ${sliderValue.toInt()}")
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                valueRange = 0f..100f
            )

            // 🔹 RadioButton
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedOption == "A",
                    onClick = { selectedOption = "A" }
                )
                Text("Opción A")

                Spacer(modifier = Modifier.width(16.dp))

                RadioButton(
                    selected = selectedOption == "B",
                    onClick = { selectedOption = "B" }
                )
                Text("Opción B")
            }

            // 🔹 Card
            Card(modifier = Modifier.fillMaxWidth()) {
                Text("Esto es una Card", modifier = Modifier.padding(16.dp))
            }

            // 🔹 Icon
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Icono"
            )

            // 🔹 Image (simulada)
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Imagen",
                modifier = Modifier.size(64.dp)
            )

            // 🔹 ProgressBar
            CircularProgressIndicator()

            // 🔹 Botón
            Button(
                onClick = { showDialog = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Mostrar resumen")
            }

            // 🔹 Resultados
            Text("Texto: $text")
            Text("Checkbox: $isChecked")
            Text("Opción: $selectedOption")
        }

        // 🔹 AlertDialog
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                },
                title = { Text("Resumen") },
                text = {
                    Text("Nombre: $text\nCheck: $isChecked\nOpción: $selectedOption\nValor: ${sliderValue.toInt()}")
                }
            )
        }
    }
}