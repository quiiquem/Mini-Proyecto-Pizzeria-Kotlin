package com.example.practica_kotlin_ev1

import android.R.attr.fontWeight
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RealizarPedido() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "¿Qué pizza va a elegir?",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        var tipoPizza by remember { mutableStateOf("") } //Guardar tipo pizza
        var extrasPizza by remember { mutableStateOf("") } //Guardar extras


        Spacer(modifier = Modifier.padding(20.dp))
        Row( //PIZZA MARGARITA
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painterResource(R.drawable.margarita), // la misma imagen
                contentDescription = "Pizza Margarita", // descripcion de la img en caso de que no cargue
                modifier = Modifier
                    .size(180.dp) // poner tamaño a la imagen
            )

            // BOTON MARGARITA
            Button(onClick = { tipoPizza = "Margarita" }) {
                Text("Pizza Margarita" , fontSize = 25.sp)

            }
        }
        Spacer(modifier = Modifier.padding(10.dp)) // separador
        Row( //PIZZA BARBACOA
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painterResource(R.drawable.barbacoa), // la misma imagen
                contentDescription = "Pizza Barbacoa", // descripcion de la img en caso de que no cargue
                modifier = Modifier
                    .size(180.dp) // poner tamaño a la imagen
            )

            // BOTON MARGARITA
            Button(onClick = { tipoPizza = "Barbacoa" }) {
                Text("Pizza Barbacoa" , fontSize = 25.sp)

            }
        }

        Spacer(modifier = Modifier.padding(10.dp))
        Row( //PIZZA ROMANA
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painterResource(R.drawable.romana), // la misma imagen
                contentDescription = "Pizza Romana", // descripcion de la img en caso de que no cargue
                modifier = Modifier
                    .size(180.dp) // tiene mas ya que es mas pequeña que las otras 2 por algun motivo
            )

            // BOTON MARGARITA
            Button(onClick = { tipoPizza = "Romana" }) {
                Text("Pizza Romana" , fontSize = 25.sp)

            }
        }
    }
}