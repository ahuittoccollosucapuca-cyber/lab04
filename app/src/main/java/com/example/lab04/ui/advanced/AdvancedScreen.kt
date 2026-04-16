package com.example.lab04.ui.advanced

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvancedScreen() {

    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Opción 1") }
    var showDialog by remember { mutableStateOf(false) }
    var selectedTab by remember { mutableStateOf(0) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    label = { Text("Inicio") },
                    icon = { Icon(Icons.Default.Home, null) }
                )
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

            // 🔹 OutlinedTextField
            OutlinedTextField(
                value = selectedOption,
                onValueChange = { selectedOption = it },
                label = { Text("Texto") }
            )

            // 🔹 DropdownMenu
            Box {
                Button(onClick = { expanded = true }) {
                    Text("Abrir menú")
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Opción 1") },
                        onClick = { selectedOption = "Opción 1"; expanded = false }
                    )
                    DropdownMenuItem(
                        text = { Text("Opción 2") },
                        onClick = { selectedOption = "Opción 2"; expanded = false }
                    )
                }
            }

            // 🔹 Divider
            HorizontalDivider()

            // 🔹 Tabs
            TabRow(selectedTabIndex = selectedTab) {
                Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }) {
                    Text("Tab 1")
                }
                Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }) {
                    Text("Tab 2")
                }
            }

            // 🔹 Grid (MODIFICADO: Tercer componente con estilo mejorado)
            Text("Grid de Acciones", style = MaterialTheme.typography.titleMedium)
            Box(Modifier.height(140.dp)) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(4) {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            modifier = Modifier.height(60.dp)
                        ) {
                            Box(contentAlignment = androidx.compose.ui.Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                Text("Item $it", style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                }
            }

            // 🔹 Resto de componentes (Snackbar, Dialog, etc.)
            Button(onClick = { scope.launch { snackbarHostState.showSnackbar("Hola Snackbar") } }) {
                Text("Mostrar Snackbar")
            }

            Button(onClick = { showDialog = true }) {
                Text("Mostrar Dialog")
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    confirmButton = { Button(onClick = { showDialog = false }) { Text("OK") } },
                    title = { Text("Dialog") },
                    text = { Text("Esto es un diálogo") }
                )
            }
        }
    }
}