package com.example.tiowichoapp.data.network

import android.media.RouteListingPreference
import com.example.tiowichoapp.data.models.Productos

class Repository<T>(private val apiService: ApiService) {

    // Obtiene las categorías del bar
    suspend fun fetchBarItems(): List<RouteListingPreference.Item> = apiService.getCategoriasBar()

    // Obtiene las categorías de la cocina
    suspend fun fetchCocinaItems(): List<RouteListingPreference.Item> = apiService.getCategoriasCocina()

    // Obtiene los detalles de un producto específico basado en su ID
    suspend fun fetchItemDetails(itemId: Int): RouteListingPreference.Item = apiService.getItemDetails(itemId)
}
