package com.example.tiowichoapp.data.network

import com.example.tiowichoapp.data.models.Item
import retrofit2.http.GET

interface ApiService {
    @GET("endpoint")
    suspend fun getItems(): List<Item>
}
