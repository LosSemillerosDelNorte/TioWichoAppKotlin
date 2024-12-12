package com.example.tiowichoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tiowichoapp.R
import com.example.tiowichoapp.ui.utils.Screens

@Composable
fun PedidoMesaScreen(innerPadding: PaddingValues, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding) // Aplica el padding recibido desde BaseScreen
    ) {
        // Fondo de pantalla
        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.fondopedido),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        // Superposición oscura (opcional)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        )

        // Contenido principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Botón Cocina
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 16.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .background(MaterialTheme.colors.onBackground.copy(alpha = 0.6f))
                    .clickable {
                        navController.navigate(Screens.Cocina.route)
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.cocina),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Cocina",
                        modifier = Modifier
                            .size(250.dp)
                            .padding(top = 10.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = "Cocina",
                        color = Color.White,
                        fontSize = 35.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            // Botón Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 16.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .background(MaterialTheme.colors.onBackground.copy(alpha = 0.6f))
                    .clickable {
                        navController.navigate(Screens.Bar.route)
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.bar),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Bar",
                        modifier = Modifier
                            .size(250.dp)
                            .padding(top = 10.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = "Bar",
                        color = Color.White,
                        fontSize = 35.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
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
fun PedidoMesaScreenPreview() {
    PedidoMesaScreen(innerPadding = PaddingValues() , navController = NavHostController(LocalContext.current))
}