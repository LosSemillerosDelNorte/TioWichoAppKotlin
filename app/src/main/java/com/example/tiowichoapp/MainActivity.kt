package com.example.tiowichoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QrCode2
import androidx.compose.material.icons.filled.Scanner
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tiowichoapp.ui.theme.TioWichoTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tiowichoapp.models.BottomNavigationItem
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
            var selectedItem by rememberSaveable {
                mutableIntStateOf(0)
            }
            TioWichoTheme {
                // Observa la ruta actual
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route ?: Screens.Home.route


                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (currentRoute != Screens.Login.route) {
                            var selectedItem = when (currentRoute) {
                                Screens.Home.route -> 0
                                Screens.PedidoMesa.route -> 1
                                Screens.Promocion.route -> 2
                                Screens.Scanner.route -> 3
                                else -> 0
                            }
                            AnimatedNavigationBar(
                                selectedIndex = selectedItem,
                                modifier = Modifier.height(100.dp),
                                barColor = MaterialTheme.colors.primary,
                                cornerRadius = shapeCornerRadius(34.dp)
                            ) {
                                // Aquí puedes configurar las pestañas dinámicas.
                                BottomNavigationItem.items.forEachIndexed { index, bottomNavigationItem ->
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .clickable{
                                        selectedItem = index
                                                when (index) {
                                                    0 -> navController.navigate(Screens.Home.route) {
                                                        launchSingleTop = true
                                                    }
                                                    1 -> navController.navigate(Screens.PedidoMesa.route) {
                                                        launchSingleTop = true
                                                    }
                                                    2 -> navController.navigate(Screens.Promocion.route) {
                                                        launchSingleTop = true
                                                    }
                                                    3 -> navController.navigate(Screens.Scanner.route) {
                                                        launchSingleTop = true
                                                    }
                                                }
                                    },
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Icon(
                                            imageVector = bottomNavigationItem.icon,
                                            contentDescription = bottomNavigationItem.title,
                                            tint = if(selectedItem == index)
                                                MaterialTheme.colors.onPrimary
                                            else
                                                MaterialTheme.colors.onPrimary.copy(alpha = 0.5f),
                                            modifier = Modifier.size(30.dp)
                                        )
                                        Text(
                                            bottomNavigationItem.title,
                                            color = MaterialTheme.colors.onPrimary)
                                    }
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Login.route
                    ) {
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