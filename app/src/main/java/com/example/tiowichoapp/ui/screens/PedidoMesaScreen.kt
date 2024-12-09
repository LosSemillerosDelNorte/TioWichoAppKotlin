package com.example.tiowichoapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PedidoMesaScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Pedido de Mesa",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Aquí puedes añadir contenido como un listado de productos o la funcionalidad para tomar pedidos
        Button(
            onClick = {
                // Acción de ejemplo
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Realizar Pedido")
        }
    }
}
