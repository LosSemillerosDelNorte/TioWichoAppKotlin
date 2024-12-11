package com.example.tiowichoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiowichoapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(innerPadding: PaddingValues) {
    // Estado para la imagen seleccionada
    var selectedImage by remember { mutableStateOf<Int?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen principal
        Image(
            painter = painterResource(id = R.drawable.tioblanco),
            contentDescription = "Imagen principal",
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.TopCenter)
                .offset(y = 0.dp)
        )

        // Texto de bienvenida
        Text(
            text = "Bienvenido a TioWichoApp",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 250.dp)
        )

        // Box para el carrusel
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 300.dp)
                .fillMaxWidth()
                .height(350.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color.DarkGray.copy(alpha = 0.5f))
                .padding(16.dp)
        ) {
            // Texto en el Box
            Text(
                text = "¡Mirá nuestros próximos eventos!",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.TopCenter)
            )

            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()

            // Desplazamiento continuo
            LaunchedEffect(listState) {
                while (true) {
                    coroutineScope.launch {
                        listState.scrollBy(4f)
                    }
                    delay(10L)
                }
            }

            // Carrusel horizontal infinito
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 70.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp),
                state = listState
            ) {
                val images = listOf(
                    R.drawable.evento1,
                    R.drawable.evento2,
                    R.drawable.evento3,
                    R.drawable.evento4,
                    R.drawable.evento5
                )

                // Carrusel con índice infinito
                items(Int.MAX_VALUE) { index ->
                    val imageRes = images[index % images.size]
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = "Evento",
                        modifier = Modifier
                            .size(250.dp)
                            .clickable { selectedImage = imageRes }
                    )
                }
            }
        }
    }

    // Mostrar la imagen seleccionada en una vista de zoom
    selectedImage?.let { imageRes ->
        ZoomableImageDialog(imageRes = imageRes) {
            selectedImage = null // Cierra el diálogo
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
    HomeScreen(innerPadding = PaddingValues())
}
