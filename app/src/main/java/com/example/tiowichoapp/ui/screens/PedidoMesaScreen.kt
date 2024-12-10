package com.example.tiowichoapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tiowichoapp.ui.components.BaseScreen

@Composable
fun PedidoMesaScreen(innerPadding: PaddingValues) {
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.onPrimary)) { // Agregamos el Box que envuelve todo
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Pedido de Mesa",
                    style = MaterialTheme.typography.h1
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
    }


