package com.example.tiowichoapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tiowichoapp.data.models.Item
import com.example.tiowichoapp.ui.components.ListItem
import com.example.tiowichoapp.ui.components.LoadingIndicator
import com.example.tiowichoapp.viewmodels.HomeViewModel
import com.example.tiowichoapp.data.states.ResourceState

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = viewModel()) {
    val itemsState by viewModel.itemsState.collectAsState()

    Scaffold(topBar = { TopAppBar(title = { Text("TioWichoApp") }) }) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
            when (val state = itemsState) {
                is ResourceState.Loading -> LoadingIndicator()
                is ResourceState.Success -> ItemList(state.data, navController)
                is ResourceState.Error -> ErrorMessage(state.message)
            }
        }
    }
}

@Composable
fun ItemList(items: List<Item>, navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(items) { item ->
            ListItem(item = item, onClick = {
                navController.navigate("details/${item.id}")
            })
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ErrorMessage(message: String?) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Error: ${message ?: "Unknown error"}", color = MaterialTheme.colors.error)
    }
}
