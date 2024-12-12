package com.example.tiowichoapp.data.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.QrCode2
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.tiowichoapp.ui.utils.Screens

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
) {
    companion object {
        val items = listOf(
            BottomNavigationItem(
                title = "Home",
                icon = Icons.Default.Home,
                route = Screens.Home.route
            ),
            BottomNavigationItem(
                title = "Scanner",
                icon = Icons.Default.QrCode2,
                route = Screens.Scanner.route
            ),
            BottomNavigationItem(
                title = "Promociones",
                icon = Icons.Default.MoneyOff,
                route = Screens.Promocion.route
            )
        )
    }
}

//Hello por aqui tambien colabore, Paolo 09/12/24 d :)


