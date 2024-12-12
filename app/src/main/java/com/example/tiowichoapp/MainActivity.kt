package com.example.tiowichoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
import com.example.tiowichoapp.ui.theme.TioWichoTheme
import com.example.tiowichoapp.ui.utils.Screens
import com.example.tiowichoapp.ui.components.BaseScreen
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
                            val selectedItem = when (currentRoute) {
                                Screens.Home.route -> 0
                                Screens.Scanner.route -> 1
                                Screens.Promocion.route -> 2
                                else -> 0
                            }
                            AnimatedNavigationBar(
                                selectedIndex = selectedItem,
                                modifier = Modifier.height(100.dp),
                                barColor = MaterialTheme.colors.primary,
                                cornerRadius = shapeCornerRadius(34.dp)
                            ) {
                                BottomNavigationItem.items.forEachIndexed { index, bottomNavigationItem ->
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .clickable {
                                                when (index) {
                                                    0 -> navController.navigate(Screens.Home.route) {
                                                        launchSingleTop = true
                                                    }
                                                    1 -> navController.navigate(Screens.Scanner.route) {
                                                        launchSingleTop = true
                                                    }
                                                    2 -> navController.navigate(Screens.Promocion.route) {
                                                        launchSingleTop = true
                                                    }
                                                }
                                            },
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Icon(
                                            imageVector = bottomNavigationItem.icon,
                                            contentDescription = bottomNavigationItem.title,
                                            tint = if (selectedItem == index)
                                                MaterialTheme.colors.onPrimary
                                            else
                                                MaterialTheme.colors.onPrimary.copy(alpha = 0.5f),
                                            modifier = Modifier.size(30.dp)
                                        )
                                        Text(
                                            bottomNavigationItem.title,
                                            color = MaterialTheme.colors.onPrimary
                                        )
                                    }
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Home.route
                    ) {
                        composable(route = Screens.Login.route) {
                            LoginScreen(
                                innerPadding = PaddingValues(),
                                onLoginSuccess = {
                                    navController.navigate(Screens.Home.route)
                                }
                            )
                        }
                        composable(route = Screens.Home.route) {
                            BaseScreen(
                                title = "TioWichoApp",
                                currentRoute = currentRoute, // Pasa la ruta actual al BaseScreen
                                onMenuClick = {  }
                            ) {
                                HomeScreen(innerPadding = innerPadding)
                            }
                        }
                        composable(route = Screens.PedidoMesa.route) {
                            BaseScreen(
                                title = "Pedido de Mesa",
                                currentRoute = currentRoute,
                                onMenuClick = { }
                            ) {
                                PedidoMesaScreen(innerPadding = innerPadding, navController  = navController)
                            }
                        }
                        composable(route = Screens.Promocion.route) {
                            BaseScreen(
                                title = "Promociones",
                                currentRoute = currentRoute,
                                onMenuClick = { }
                            ) {
                                PromocionScreen(innerPadding = innerPadding)
                            }
                        }
                        composable(route = Screens.Scanner.route) {
                            BaseScreen(
                                title = "Escáner",
                                currentRoute = currentRoute,
                                onMenuClick = { /* Acción personalizada si es necesario */ }
                            ) {
                                ScannerScreen(
                                    navController = navController
                                )
                            }
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



//hello por aqui coolabore, paolo 10/12/24 d:)