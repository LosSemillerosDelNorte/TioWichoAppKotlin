package com.example.tiowichoapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiowichoapp.data.models.Item
import com.example.tiowichoapp.data.network.Repository
import com.example.tiowichoapp.data.states.ResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {
    private val _itemsState = MutableStateFlow<ResourceState<List<Item>>>(ResourceState.Loading())
    val itemsState: StateFlow<ResourceState<List<Item>>> = _itemsState

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            try {
                val items = repository.fetchItems()
                _itemsState.value = ResourceState.Success(items)
            } catch (e: Exception) {
                _itemsState.value = ResourceState.Error(e.message ?: "Error")
            }
        }
    }
}
