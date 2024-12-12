package com.example.tiowichoapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiowichoapp.data.models.Productos
import com.example.tiowichoapp.data.states.ResourceState
import com.example.tiowichoapp.data.network.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.collections.*


class DetailsViewModel(private val repository: Repository<Any?>) : ViewModel() {

    private val _itemState = MutableStateFlow<ResourceState<Productos>>(ResourceState.Loading())
    val itemState: StateFlow<ResourceState<Productos>> = _itemState

    fun fetchItemDetails(itemId: Int) {
        viewModelScope.launch {
            try {
                val item = repository.fetchItemDetails(itemId)
                _itemState.value = ResourceState.Success(item)
            } catch (e: Exception) {
                _itemState.value = ResourceState.Error(e.message ?: "An error occurred")
            }
        }
    }
}

