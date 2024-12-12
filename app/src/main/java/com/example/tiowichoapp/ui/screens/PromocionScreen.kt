package com.example.tiowichoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.tiowichoapp.R
import com.example.tiowichoapp.ui.components.BaseScreen
import com.example.tiowichoapp.ui.theme.TioWichoTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PromocionScreen(innerPadding: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .offset(y = -80.dp)

                .background(
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f), // Color de fondo
                    shape = RoundedCornerShape(8.dp) // Bordes redondeados (opcional)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp) // Espaciado interno
        ) {
            Text(
                text = "¡Promoción!",
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.h2
            )
        }

        // Estado del LazyRow
        val listState = rememberLazyListState()
        var selectedImage by remember { mutableStateOf<Int?>(null) } // Imagen seleccionada

        // Efecto de desplazamiento automático
        LaunchedEffect(listState) {
            while (true) {
                launch {
                    listState.scrollBy(4f) // Desplaza 3 píxeles para mayor velocidad
                }
                delay(10L) // Retraso para un movimiento más fluido
            }
        }

        // Carrusel horizontal infinito
        LazyRow(
            state = listState, // Aplica el estado al LazyRow
            modifier = Modifier
                .fillMaxWidth()
                .padding(top =0.dp), // Espaciado entre el texto y el carrusel
            horizontalArrangement = Arrangement.spacedBy(-20.dp), // Espaciado uniforme entre imágenes
            contentPadding = PaddingValues(horizontal = 4.dp)
        ) {
            val images = listOf(
                R.drawable.promo1, // Reemplaza con tus imágenes
                R.drawable.promo2, // Reemplaza con tus imágenes
                R.drawable.promo3, // Reemplaza con tus imágenes
                R.drawable.promo4,  // Reemplaza con tus imágenes
                R.drawable.promo5,  // Reemplaza con tus imágenes
                R.drawable.promo6,  // Reemplaza con tus imágenes
            )

            // Usa un índice infinito
            items(Int.MAX_VALUE) { index ->
                val imageRes = images[index % images.size] // Calcula el índice circular
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Evento",
                    contentScale = ContentScale.Crop, // Ajusta el contenido
                    modifier = Modifier
                        .size(450.dp) // Tamaño de las imágenes
                        .clickable {
                            selectedImage = imageRes // Establece la imagen seleccionada
                        }
                )
            }
        }

        // Mostrar la imagen ampliada si se selecciona
        if (selectedImage != null) {
            ZoomableImageDialog(
                imageRes = selectedImage!!,
                onDismiss = { selectedImage = null }
            )
        }
    }
}


@Composable
fun ZoomableImageDialog(imageRes: Int, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Fit, // Ajusta la imagen al tamaño disponible
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f) // Ajusta la altura
                    .clickable { onDismiss() } // Cierra al hacer clic
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp"
)
@Composable
fun PromocionScreenPreview() {
    TioWichoTheme {
        PromocionScreen(innerPadding = PaddingValues())
    }
}
