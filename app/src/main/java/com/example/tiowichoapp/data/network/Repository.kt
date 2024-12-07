package com.example.tiowichoapp.data.network

class Repository(private val apiService: ApiService) {
    suspend fun fetchItems() = apiService.getItems()
}
