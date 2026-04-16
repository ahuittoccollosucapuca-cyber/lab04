package com.example.lab04.ui.containers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.constraintlayout.compose.ConstraintLayout

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ContainersScreen() {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Containers") })
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // 🔹 LazyColumn (base)
            item {
                Text("LazyColumn (base de la pantalla)")
            }

            // 🔹 LazyRow
            item {
                Text("LazyRow")
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(5) {
                        Card {
                            Text("Item $it", Modifier.padding(8.dp))
                        }
                    }
                }
            }

            // 🔹 Grid
            item {
                Text("Grid")
                Box(Modifier.height(120.dp)) {
                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                        items(6) {
                            Card(Modifier.padding(4.dp)) {
                                Text("Grid $it", Modifier.padding(8.dp))
                            }
                        }
                    }
                }
            }

            // 🔹 ConstraintLayout
            item {
                Text("ConstraintLayout")
                ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                    val (a, b) = createRefs()

                    Text("A", modifier = Modifier.constrainAs(a) {
                        top.linkTo(parent.top)
                    })

                    Text("B", modifier = Modifier.constrainAs(b) {
                        top.linkTo(a.bottom)
                    })
                }
            }

            // 🔹 Surface
            item {
                Text("Surface")
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    tonalElevation = 4.dp
                ) {
                    Text(
                        "Contenido dentro de Surface",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            // 🔹 Chip
            item {
                Text("Chip")
                AssistChip(
                    onClick = {},
                    label = { Text("Chip ejemplo") }
                )
            }



            // 🔹 BackdropScaffold (SIMULADO para evitar crash)
            item {
                Text("BackdropScaffold (simulación segura)")

                Surface(
                    tonalElevation = 4.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Back Layer (simulado)")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Front Layer (simulado)")
                    }
                }
            }
        }
    }
}