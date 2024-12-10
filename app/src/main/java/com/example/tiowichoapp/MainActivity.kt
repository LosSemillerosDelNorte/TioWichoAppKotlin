package com.example.tiowichoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tiowichoapp.ui.theme.TioWichoTheme
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tiowichoapp.ui.screens.HomeScreen
import com.example.tiowichoapp.ui.screens.LoginScreen
import com.example.tiowichoapp.ui.screens.PedidoMesaScreen
import com.example.tiowichoapp.ui.screens.PromocionScreen
import com.example.tiowichoapp.ui.utils.Screens
import com.exyte.animatednavbar.AnimatedNavigationBar


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            TioWichoTheme {
                Scaffold (modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AnimatedNavigationBar(selectedIndex = 0,){
                            Text("Home")
                            Text("test")
                            Text("test")
                        }
                    }) { innerPadding ->
                    NavHost(navController = navController, startDestination = Screens.Login.route) {

                        composable(route = Screens.Home.route) {
                            HomeScreen(innerPadding = innerPadding)
                        }
                        composable(route = Screens.PedidoMesa.route) {
                            PedidoMesaScreen(innerPadding = innerPadding)
                        }
                        composable(route = "promocion"){
                            PromocionScreen(innerPadding = innerPadding)
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

