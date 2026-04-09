package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab04.ui.theme.Lab04Theme
// IMPORTANTE: Estos dos quitan los errores de las líneas 48 y 69 (el error del 'by')
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Llamada al componente principal
                    MovieCounter(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MovieCounter(modifier: Modifier = Modifier) {

    var count by rememberSaveable { mutableIntStateOf(0) }
    var movieName by rememberSaveable { mutableStateOf("") }

    // LISTA DE ESTADO (Para el contenedor LazyColumn)
    val movieList = remember { mutableStateListOf<String>() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Has añadido $count películas",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        // CONTROL: Campo de texto para ingresar nombres
        OutlinedTextField(
            value = movieName,
            onValueChange = { movieName = it },
            label = { Text("Nombre de la película") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // CONTROL: Botón de acción
        Button(
            onClick = {
                if (movieName.isNotBlank()) {
                    movieList.add(movieName)
                    count++
                    movieName = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Película")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // CONTENEDOR: LazyColumn (Primer componente del lab pasado)
        Text(
            text = "Lista de Inventario:",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.align(Alignment.Start)
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(movieList) { movie ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Text(
                        text = movie,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}