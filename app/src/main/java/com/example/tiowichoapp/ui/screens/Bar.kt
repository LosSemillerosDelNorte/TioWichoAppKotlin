package com.example.tiowichoapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tiowichoapp.data.models.Productos
import com.example.tiowichoapp.data.network.Repository



@Composable
fun Bar(navController: NavHostController, repository: Repository<Any>, innerPadding: PaddingValues) {
    var categorias by remember { mutableStateOf<List<Productos>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var hasError by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        try {
            categorias = repository.fetchBarItems()
            hasError = false
        } catch (e: Exception) {
            hasError = true
        } finally {
            isLoading = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        when {
            isLoading -> {
                CircularProgressIndicator()
            }
            hasError -> {
                Text("Error al cargar las categorías. Intenta nuevamente.")
            }
            else -> {
                CategoriaList(categorias = categorias)
            }
        }
    }
}

@Composable
fun CategoriaList(categorias: List<Productos>) {

}

