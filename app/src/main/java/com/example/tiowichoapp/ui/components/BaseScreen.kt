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
import com.example.tiowichoapp.ui.utils.Screens

@Composable
fun BaseScreen(
    title: String = "TioWichoApp",
    onMenuClick: () -> Unit = {},
    currentRoute: String? = null, // Nueva propiedad para identificar la ruta actual
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize() // Ocupa todo el espacio de la pantalla
    ) {

        // Imagen de fondo (solo para la pantalla "Home")
        if (currentRoute == Screens.Home.route) {
            Image(
                painter = painterResource(id = R.drawable.oeste_fondo),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Superposición oscura (opcional)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            )
        }
        if (currentRoute == Screens.Promocion.route) {
            Image(
                painter = painterResource(id = R.drawable.fondooferta),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Superposición oscura (opcional)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            )
        }

        // Contenido principal
        Column(modifier = Modifier.fillMaxSize()) {
            // Encabezado con el título
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
                    )
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primary)
                    .statusBarsPadding()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        fontSize = 40.sp,
                        modifier = Modifier.weight(1f),
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
            }

            // Contenido proporcionado por la pantalla
            content()
        }
    }
}
