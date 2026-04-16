package com.example.lab04.ui.containers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.constraintlayout.compose.ConstraintLayout

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ContainersScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Containers Pro", style = MaterialTheme.typography.headlineSmall) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            // 🔹 Título principal
            item {
                Text("Lista de Contenedores 🔥", style = MaterialTheme.typography.titleLarge)
            }

            // 🔹 LazyRow mejorada
            item {
                Text("LazyRow con Cards", style = MaterialTheme.typography.labelLarge)
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(5) {
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Text("Item $it", Modifier.padding(16.dp))
                        }
                    }
                }
            }

            // 🔹 Grid con estilo
            item {
                Text("Grid de Layout", style = MaterialTheme.typography.labelLarge)
                Box(Modifier.height(150.dp)) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(6) {
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                                )
                            ) {
                                Text("Grid $it", Modifier.padding(16.dp))
                            }
                        }
                    }
                }
            }

            // 🔹 ConstraintLayout
            item {
                Text("ConstraintLayout", style = MaterialTheme.typography.labelLarge)
                ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                    val (a, b) = createRefs()

                    Text("Texto A", modifier = Modifier.constrainAs(a) {
                        top.linkTo(parent.top)
                    })

                    Text("Texto B", modifier = Modifier.constrainAs(b) {
                        top.linkTo(a.bottom, margin = 8.dp)
                    })
                }
            }

            // 🔹 Surface
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    tonalElevation = 4.dp
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Surface Component", style = MaterialTheme.typography.titleSmall)
                        Text("Contenido con elevación y bordes redondeados.")
                    }
                }
            }

            // 🔹 Chip
            item {
                AssistChip(
                    onClick = {},
                    label = { Text("Chip interactivo") }
                )
            }

            // 🔹 BackdropScaffold (Simulación segura)
            item {
                Surface(
                    tonalElevation = 2.dp,
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Backdrop Simulado", style = MaterialTheme.typography.titleSmall)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Esta es una representación visual limpia del componente.")
                    }
                }
            }
        }
    }
}