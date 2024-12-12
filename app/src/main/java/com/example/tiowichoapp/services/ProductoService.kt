package com.example.tiowichoapp.services

import com.example.tiowichoapp.data.models.Productos
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ProductoService {
    @GET("bar/categorias")
    suspend fun getCategoriasBar(): List<Productos>

    @GET("cocina/categorias")
    suspend fun getCategoriasCocina(): List<Productos>
}

object RetrofitClient {
    private const val BASE_URL = "http://192.168.1.70:8000/"

    val instance: ProductoService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductoService::class.java)
    }
}
