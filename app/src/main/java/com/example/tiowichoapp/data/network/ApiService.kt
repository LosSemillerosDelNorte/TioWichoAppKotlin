package com.example.tiowichoapp.data.network

import android.media.RouteListingPreference
import com.example.tiowichoapp.data.models.Productos
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("categories/bar")
    suspend fun getCategoriasBar(): List<RouteListingPreference.Item>

    @GET("categories/cocina")
    suspend fun getCategoriasCocina(): List<RouteListingPreference.Item>

    @GET("categories/details/{id}")
    suspend fun getItemDetails(@Path("id") itemId: Int): RouteListingPreference.Item
}
