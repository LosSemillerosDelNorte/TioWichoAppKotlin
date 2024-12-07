package com.example.tiowichoapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiowichoapp.data.models.Item
import com.example.tiowichoapp.data.states.ResourceState
import com.example.tiowichoapp.data.network.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(private val repository: Repository) : ViewModel() {

    private val _itemState = MutableStateFlow<ResourceState<Item>>(ResourceState.Loading())
    val itemState: StateFlow<ResourceState<Item>> = _itemState

    fun fetchItemDetails(itemId: Int) {
        viewModelScope.launch {
            try {
                val item = repository.fetchItems().find { it.id == itemId }
                if (item != null) {
                    _itemState.value = ResourceState.Success(item)
                } else {
                    _itemState.value = ResourceState.Error("Item not found")
                }
            } catch (e: Exception) {
                _itemState.value = ResourceState.Error(e.message ?: "An error occurred")
            }
        }
    }
}
