package com.example.tiowichoapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import com.example.tiowichoapp.R

@Composable
fun BaseScreen(
    title: String = "TioWichoApp",
    onMenuClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el espacio de la pantalla // Fondo blanco
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.oeste_fondo), // Tu recurso de imagen
            contentDescription = null, // Sin descripción para imágenes decorativas
            modifier = Modifier.fillMaxSize(), // La imagen ocupa todo el espacio disponible
            contentScale = ContentScale.Crop // Ajusta cómo se escala la imagen
        )
        // Contenido principal de la pantalla
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Encabezado con el título
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF44336))
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontSize = 40.sp,
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    onClick = onMenuClick,
                    modifier = Modifier.size(40.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.menu_icon),
                        contentDescription = "Menú",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }

            // Contenido variable proporcionado por cada pantalla
            content()
        }

        // Fila para los tres botones en la parte inferior
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF44336))
                .padding(16.dp)
                .align(Alignment.BottomCenter), // Ubica la fila en la parte inferior del dispositivo
            horizontalArrangement = Arrangement.SpaceEvenly, // Espaciado uniforme entre los botones
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botón Imagen 1
            IconButton(
                onClick = { /* Acción del botón 1 */ },
                modifier = Modifier.size(64.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home_icon), // Reemplaza con tu recurso de imagen
                    contentDescription = "Botón 1",
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Botón Imagen 2
            IconButton(
                onClick = { /* Acción del botón 2 */ },
                modifier = Modifier.size(64.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.escaner_icon), // Reemplaza con tu recurso de imagen
                    contentDescription = "Botón 2",
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Botón Imagen 3
            IconButton(
                onClick = { /* Acción del botón 3 */ },
                modifier = Modifier.size(64.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sale_icon), // Reemplaza con tu recurso de imagen
                    contentDescription = "Botón 3",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
