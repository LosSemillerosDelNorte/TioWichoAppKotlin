package com.example.tiowichoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tiowichoapp.R
import com.example.tiowichoapp.ui.components.BaseScreen


@Composable
fun HomeScreen() {
    BaseScreen(
        title = "TioWichoApp",
        onMenuClick = { /* Acción del botón hamburguesa */ }
    ) {

    }
}
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp"
)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}