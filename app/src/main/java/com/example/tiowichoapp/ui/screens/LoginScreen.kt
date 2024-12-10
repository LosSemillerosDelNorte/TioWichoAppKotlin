package com.example.tiowichoapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(innerPadding: PaddingValues, onLoginSuccess: () -> Unit) {
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var isEmailValid by remember { mutableStateOf(true) }
    var isPasswordValid by remember { mutableStateOf(true) }
    var loginError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding) // Se aplica innerPadding
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Inicio de Sesión",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para el usuario
        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
                isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(it.text).matches()
            },
            label = { Text("Correo Electrónico") },
            isError = !isEmailValid,
            modifier = Modifier.fillMaxWidth()
        )
        if (!isEmailValid && username.text.isNotEmpty()) {
            Text(
                text = "Correo inválido",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de texto para la contraseña
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                isPasswordValid = it.text.isNotEmpty()
            },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = !isPasswordValid,
            modifier = Modifier.fillMaxWidth()
        )
        if (!isPasswordValid && password.text.isNotEmpty()) {
            Text(
                text = "Contraseña requerida",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para iniciar sesión
        Button(
            onClick = {
                // Validar credenciales
                if (username.text == "tiowicho@gmail.com" && password.text == "1234") {
                    loginError = false
                    onLoginSuccess() // Llamar a la acción de éxito
                } else {
                    loginError = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar Sesión")
        }

        if (loginError) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Correo o contraseña incorrectos",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
