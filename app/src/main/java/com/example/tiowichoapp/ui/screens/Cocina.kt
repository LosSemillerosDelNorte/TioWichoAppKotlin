import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tiowichoapp.data.models.Productos
import com.example.tiowichoapp.data.network.Repository

@Composable
fun Cocina (navController: NavHostController, repository: Repository<Any>, innerPadding: PaddingValues) {
    var categorias by remember { mutableStateOf<List<Productos>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var hasError by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        try {
            categorias = repository.fetchCocinaItems()
            hasError = false
        } catch (e: Exception) {
            hasError = true
        } finally {
            isLoading = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        when {
            isLoading -> {
                CircularProgressIndicator()
            }
            hasError -> {
                Text("Error al cargar las categorías. Intenta nuevamente.")
            }
            else -> {
                CategoriaList(categorias = categorias)
            }
        }
    }
}

@Composable
fun CategoriaList(categorias: List<Productos>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
    ) {
        items(categorias) { categoria ->
            CategoriaItem(categoria = categoria)
        }
    }
}

@Composable
fun CategoriaItem(categoria: Productos) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = categoria.nombre, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Precio: ${categoria.precio}", style = MaterialTheme.typography.body2)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CocinaPreview() {
    val dummyData = listOf(
        Productos(id = 1, nombre = "Hamburguesa", precio = 85.0, categoria = "Platillos"),
        Productos(id = 2, nombre = "Tacos", precio = 50.0, categoria = "Platillos"),
        Productos(id = 3, nombre = "Camarones", precio = 150.0, categoria = "Mariscos")
    )
    CategoriaList(categorias = dummyData)
}
