package com.example.tiowichoapp.ui.utils

sealed  class Screens(val route : String) {
    data object Home : Screens("home")
    data object Login : Screens("login")
    data object PedidoMesa : Screens("pedido")
    data object Promocion : Screens("promocion")
}