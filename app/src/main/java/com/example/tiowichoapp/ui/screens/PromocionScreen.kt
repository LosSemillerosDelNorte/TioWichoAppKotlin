package com.example.tiowichoapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PromocionScreen(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Promociones",
            style = MaterialTheme.typography.h1
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Aquí puedes añadir contenido como una lista de promociones
        Text(
            text = "¡No te pierdas nuestras promociones exclusivas!",
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Acción de ejemplo
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Más")
        }
    }
}
