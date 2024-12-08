package com.example.tiowichoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tiowichoapp.data.network.ApiClient
import com.example.tiowichoapp.data.network.Repository
import com.example.tiowichoapp.ui.screens.DetailsScreen
import com.example.tiowichoapp.ui.screens.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(
            innerPadding = TODO()
        ) }
        composable("details/{itemId}") { backStackEntry ->
            DetailsScreen(
                itemId = backStackEntry.arguments?.getString("itemId"),
                repository = Repository(ApiClient.apiService)) // Pasa tu repositorio aquí
        }
    }
}

