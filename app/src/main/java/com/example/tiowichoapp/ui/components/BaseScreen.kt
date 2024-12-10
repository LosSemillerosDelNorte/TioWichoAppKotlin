package com.example.tiowichoapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
            .background(Color.DarkGray)
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
                    .background(Color(0xFFF44336)) // Fondo naranja
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

        Box(
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho disponible
                .height(80.dp) // Ajusta la altura según sea necesario
                .clip(RoundedCornerShape(40.dp)) // Bordes redondeados
                .background(Color(0xFFF44336)) // Fondo rojo después de `clip`
                .align(Alignment.BottomCenter) // Alinea este Box en la parte inferior de la pantalla
        ) {
            // Fila para los tres botones
            Row(
                modifier = Modifier.fillMaxSize(), // Ocupa todo el tamaño del Box rojo
                horizontalArrangement = Arrangement.SpaceEvenly, // Espaciado uniforme entre los botones
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Botón Imagen 1
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido en la columna
                ) {
                    IconButton(
                        onClick = { /* Acción del botón 1 */ },
                        modifier = Modifier.size(48.dp) // Icono más pequeño
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.home_icon),
                            contentDescription = "Botón 1"
                        )
                    }
                    Text(
                        text = "Inicio",
                        fontSize = 18.sp, // Texto un poco más grande
                        color = Color.Black // Cambia el color según el diseño
                    )
                }

                // Botón Imagen 2
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = { /* Acción del botón 2 */ },
                        modifier = Modifier.size(48.dp) // Icono más pequeño
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.escaner_icon),
                            contentDescription = "Botón 2"
                        )
                    }
                    Text(
                        text = "Escanear",
                        fontSize = 18.sp, // Texto un poco más grande
                        color = Color.Black
                    )
                }

                // Botón Imagen 3
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = { /* Acción del botón 3 */ },
                        modifier = Modifier.size(48.dp) // Icono más pequeño
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sale_icon),
                            contentDescription = "Botón 3"
                        )
                    }
                    Text(
                        text = "Ofertas",
                        fontSize = 18.sp, // Texto un poco más grande
                        color = Color.Black
                    )
                }
            }
        }

    }
}
