package com.example.practica_kotlin_ev1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RealizarPedido() {
    // Variables de estado (en remember para que no se cambie de repente)
    var tipoPizza by remember { mutableStateOf("") }
    var extraSeleccionado by remember { mutableStateOf("") }
    var mostrarTamanyo by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar la siguiente pantalla si ya se puso un extra
        if (mostrarTamanyo) {
            Tamanyo_Pizza(tipoPizza, extraSeleccionado) //guarda los datos elegidos para que no se queden aqui solo
            return // Para que se que asi
        }

        Text(
            "¿Qué pizza va a elegir?",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(20.dp))

        // PIZZA MARGARITA
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.margarita),
                contentDescription = "Pizza Margarita",
                modifier = Modifier.size(180.dp)
            )
            Button(onClick = { tipoPizza = "Margarita" }) {
                Text("Pizza Margarita", fontSize = 25.sp)
            }
        }

        // Extras Margarita
        if (tipoPizza == "Margarita") {
            val opcionesMargarita = listOf("Con Piña", "Versión Vegana", "Sin Extras")
            Column(Modifier.selectableGroup()) {
                Text(
                    "Extras disponibles:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )

                opcionesMargarita.forEach { extra ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (extraSeleccionado == extra),
                                onClick = {
                                    extraSeleccionado = extra
                                    mostrarTamanyo = true //pasar a mostrar tamaño
                                }
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (extraSeleccionado == extra),
                            onClick = {
                                extraSeleccionado = extra
                                mostrarTamanyo = true //pasar a mostrar tamaño
                            }
                        )
                        Text(extra, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(start = 16.dp))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        // PIZZA BARBACOA
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.barbacoa),
                contentDescription = "Pizza Barbacoa",
                modifier = Modifier.size(180.dp)
            )
            Button(onClick = { tipoPizza = "Barbacoa" }) {
                Text("Pizza Barbacoa", fontSize = 25.sp)
            }
        }

        // Extras Barbacoa
        if (tipoPizza == "Barbacoa") {
            val opcionesBarbacoa = listOf("Carne de cerdo", "Pollo", "Ternera", "Sin Extras")
            Column(Modifier.selectableGroup()) {
                Text(
                    "Extras disponibles:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )

                opcionesBarbacoa.forEach { extra ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (extraSeleccionado == extra),
                                onClick = {
                                    extraSeleccionado = extra
                                    mostrarTamanyo = true //pasar a mostrar tamaño
                                }
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (extraSeleccionado == extra),
                            onClick = {
                                extraSeleccionado = extra
                                mostrarTamanyo = true //pasar a mostrar tamaño
                            }
                        )
                        Text(extra, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(start = 16.dp))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        // PIZZA ROMANA
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.romana),
                contentDescription = "Pizza Romana",
                modifier = Modifier.size(180.dp)
            )
            Button(onClick = { tipoPizza = "Romana" }) {
                Text("Pizza Romana", fontSize = 25.sp)
            }
        }

        // Extras Romana
        if (tipoPizza == "Romana") {
            val opcionesRomana = listOf("Con champiñones", "Sin Extras")
            Column(Modifier.selectableGroup()) {
                Text(
                    "Extras disponibles:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )

                opcionesRomana.forEach { extra ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (extraSeleccionado == extra),
                                onClick = {
                                    extraSeleccionado = extra
                                    mostrarTamanyo = true //pasar a mostrar tamaño
                                }
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (extraSeleccionado == extra),
                            onClick = {
                                extraSeleccionado = extra
                                mostrarTamanyo = true //pasar a mostrar tamaño
                            }
                        )
                        Text(extra, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(start = 16.dp))
                    }
                }
            }
        }
    }
}
