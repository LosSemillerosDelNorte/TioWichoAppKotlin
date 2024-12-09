package com.example.tiowichoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tiowichoapp.R
import com.example.tiowichoapp.ui.components.BaseScreen


@Composable
fun HomeScreen(innerPadding: NavHostController) {
    // Estado para controlar la imagen seleccionada y si se muestra el diálogo
    var selectedImage by remember { mutableStateOf<Int?>(null) }

    BaseScreen(
        title = "TioWichoApp",
        onMenuClick = { /* Acción del botón hamburguesa */ }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el tamaño de la pantalla
        ) {
            // Imagen principal
            Image(
                painter = painterResource(id = R.drawable.tioblanco), // Imagen principal
                contentDescription = "Imagen centrada",
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.TopCenter) // Centra horizontalmente
                    .offset(y = 20.dp) // Ajusta la posición vertical
            )

            // Texto de bienvenida
            Text(
                text = "Bienvenido a TioWichoApp",
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopCenter) // Centra horizontalmente
                    .offset(y = 250.dp) // Ajusta la posición vertical
            )

            // Box para el carrusel
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter) // Centra horizontalmente
                    .offset(y = 330.dp) // Ajusta la posición vertical
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(40.dp)) // Bordes redondeados
                    .background(Color.DarkGray.copy(alpha = 0.5f)) // Fondo translúcido
                    .padding(16.dp)
            ) {
                // Texto en el Box
                Text(
                    text = "¡Mirá nuestros próximos eventos!",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.TopCenter)
                )

                // Carrusel horizontal
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 70.dp), // Espaciado entre el texto y el carrusel
                    horizontalArrangement = Arrangement.spacedBy(8.dp), // Espaciado uniforme entre imágenes
                    contentPadding = PaddingValues(horizontal = 8.dp)
                ) {
                    val images = listOf(
                        R.drawable.evento1, // Reemplaza con tus imágenes
                        R.drawable.evento2,
                        R.drawable.evento3
                    )

                    items(images) { imageRes ->
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = "Evento",
                            modifier = Modifier
                                .size(150.dp) // Tamaño de las imágenes
                                .clickable { selectedImage = imageRes } // Acciones al hacer clic
                        )
                    }
                }
            }

            // Barra inferior con botones
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp) // Altura de la barra
                    .align(Alignment.BottomCenter) // Posiciona la barra en la parte inferior
                    .background(Color(0xFFF44336)) // Fondo rojo
                    .padding(horizontal = 16.dp) // Espaciado lateral
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Botón Inicio
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = { /* Acción del botón */ },
                            modifier = Modifier.size(48.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.home_icon),
                                contentDescription = "Inicio"
                            )
                        }
                        Text("Inicio", fontSize = 14.sp, color = Color.White)
                    }

                    // Botón Escanear
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = { /* Acción del botón */ },
                            modifier = Modifier.size(48.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.escaner_icon),
                                contentDescription = "Escanear"
                            )
                        }
                        Text("Escanear", fontSize = 14.sp, color = Color.White)
                    }

                    // Botón Ofertas
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = { /* Acción del botón */ },
                            modifier = Modifier.size(48.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.sale_icon),
                                contentDescription = "Ofertas"
                            )
                        }
                        Text("Ofertas", fontSize = 14.sp, color = Color.White)
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_5"
)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}