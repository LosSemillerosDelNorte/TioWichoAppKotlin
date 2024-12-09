package com.example.tiowichoapp.ui.screens

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.zxing.integration.android.IntentIntegrator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScannerScreen(
    onScannedResult: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    var scannedContent by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current // Acceso al contexto actual

    // Lanzador de actividad para el escáner QR
    val scannerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intentResult = IntentIntegrator.parseActivityResult(
                result.resultCode,
                result.data
            )
            if (intentResult != null) {
                scannedContent = intentResult.contents
                if (scannedContent != null) {
                    onScannedResult(scannedContent!!)
                } else {
                    Toast.makeText(context, "Escaneo cancelado", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Error al escanear", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Lanzar el escáner QR al iniciar la pantalla
    LaunchedEffect(Unit) {
        val integrator = IntentIntegrator(context as Activity)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        integrator.setPrompt("Escanéa el QR de la mesa que harás pedido")
        integrator.setBeepEnabled(true)
        scannerLauncher.launch(integrator.createScanIntent())
    }

    // UI de la pantalla
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Escáner QR") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            scannedContent?.let {
                Text("Resultado del escaneo: $it")
            } ?: Text("Esperando escaneo...")
        }
    }
}
