package com.example.tiowichoapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tiowichoapp.data.models.Productos

@Composable
fun ListItem(categorias: List<Productos>,
             navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        categorias.forEach { categoria ->
            Text(
                text = categoria.nombre,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}