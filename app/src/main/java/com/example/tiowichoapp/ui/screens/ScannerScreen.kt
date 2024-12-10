package com.example.tiowichoapp.ui.screens

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.zxing.integration.android.IntentIntegrator
import com.example.tiowichoapp.ui.utils.Screens

@Composable
fun ScannerScreen(
    navController: NavHostController
) {
    var scannedContent by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    val scannerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val intentResult = IntentIntegrator.parseActivityResult(
            result.resultCode,
            result.data
        )
        if (result.resultCode == Activity.RESULT_OK && intentResult?.contents != null) {
            scannedContent = intentResult.contents
            if (scannedContent == "pedidomesa") {
                navController.navigate(Screens.PedidoMesa.route)
            } else {
                Toast.makeText(context, "Código QR no reconocido", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "Error al escanear o acción cancelada", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit) {
        val activity = context as? Activity
        if (activity != null) {
            val integrator = IntentIntegrator(activity)
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            integrator.setPrompt("Escanéa el QR de la mesa")
            integrator.setOrientationLocked(true)
            integrator.setBeepEnabled(true)
            scannerLauncher.launch(integrator.createScanIntent())
        } else {
            Toast.makeText(context, "Error: contexto inválido", Toast.LENGTH_SHORT).show()
        }
    }

}
