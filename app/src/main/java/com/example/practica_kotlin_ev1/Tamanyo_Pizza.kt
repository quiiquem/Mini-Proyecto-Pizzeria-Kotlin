package com.example.practica_kotlin_ev1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Tamanyo_Pizza(tipoPizza: String, extra: String) { //guarda los datos de antes para que no se pierdan en "Realizar Pedido"
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Has elegido $tipoPizza con $extra", //los muestra, esto es como poner el nombre en main
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        // Aquí puedes guardar los datos, mostrarlos o continuar con la selección
    }
}
