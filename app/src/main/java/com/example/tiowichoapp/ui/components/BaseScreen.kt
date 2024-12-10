package com.example.tiowichoapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tiowichoapp.R
import com.example.tiowichoapp.ui.screens.HomeScreen
import com.example.tiowichoapp.ui.theme.TioWichoTheme

@Composable
fun BaseScreen(
    title: String = "TioWichoApp",
    onMenuClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el espacio de la pantalla // Fondo blanco
            .background(MaterialTheme.colors.background)
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.oeste_fondo), // Tu recurso de imagen
            contentDescription = null, // Sin descripción para imágenes decorativas
            modifier = Modifier.fillMaxSize(), // La imagen ocupa todo el espacio disponible
            contentScale = ContentScale.Crop // Ajusta cómo se escala la imagen
        )
        // Superposición oscura
        Box(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el espacio
                .background(Color.Black.copy(alpha = 0.5f)) // Fondo negro semitransparente
        )

        // Contenido principal de la pantalla
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Encabezado con el título dentro de un Box
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 30.dp,
                            bottomEnd = 30.dp
                        )
                    ) // Bordes redondeados)
                    .fillMaxWidth() // Ocupa todo el ancho disponible
                    .background(MaterialTheme.colors.primary) // Fondo naranja
                    .statusBarsPadding() // Añade padding para respetar la barra de notificaciones
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp), // Relleno dentro del Box
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        fontSize = 40.sp,
                        modifier = Modifier.weight(1f) // Hace que el texto ocupe el espacio restante
                            .align(Alignment.CenterVertically),
                    )

                    IconButton(
                        onClick = onMenuClick,
                        modifier = Modifier.size(40.dp) // Tamaño del botón
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.menu_icon),
                            contentDescription = "Menú",
                            modifier = Modifier.size(40.dp) // Tamaño del ícono
                        )
                    }
                }
            }


            // Contenido variable proporcionado por cada pantalla
            content()
        }


    }
}

