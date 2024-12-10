package com.example.tiowichoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tiowichoapp.ui.theme.TioWichoTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tiowichoapp.ui.screens.HomeScreen
import com.example.tiowichoapp.ui.screens.LoginScreen
import com.example.tiowichoapp.ui.screens.PedidoMesaScreen
import com.example.tiowichoapp.ui.screens.PromocionScreen
import com.example.tiowichoapp.ui.screens.ScannerScreen
import com.example.tiowichoapp.ui.utils.Screens
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            TioWichoTheme {
                // Observa la ruta actual
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (currentRoute != Screens.Login.route) {
                            AnimatedNavigationBar(selectedIndex = 0,
                                modifier = Modifier.height(100.dp),
                                barColor = MaterialTheme.colors.primary,
                                cornerRadius = shapeCornerRadius(cornerRadius = 34.dp)) {
                                Text("Home")
                                Text("test")
                                Text("test")
                            }
                        }
                    }) { innerPadding ->
                    NavHost(navController = navController, startDestination = Screens.Login.route) {
                        composable(route = Screens.Login.route) {
                            LoginScreen(
                                innerPadding = PaddingValues(), // O usa innerPadding si es necesario
                                onLoginSuccess = {
                                    navController.navigate(Screens.Home.route) // Navega al Home al iniciar sesión correctamente
                                }
                            )
                        }
                        composable(route = Screens.Home.route) {
                            HomeScreen(innerPadding = innerPadding)
                        }
                        composable(route = Screens.PedidoMesa.route) {
                            PedidoMesaScreen(innerPadding = innerPadding)
                        }
                        composable(route = Screens.Promocion.route) {
                            PromocionScreen(innerPadding = innerPadding)
                        }
                        composable(route = Screens.Scanner.route) {
                            ScannerScreen(
                                onScannedResult = { scannedData ->
                                    println("Resultado escaneado: $scannedData")
                                    navController.navigate(Screens.Home.route)
                                },
                                onNavigateBack = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp"
)
@Composable
fun HomeScreenPreview() {
    TioWichoTheme {
        HomeScreen(innerPadding = PaddingValues())
        }
}