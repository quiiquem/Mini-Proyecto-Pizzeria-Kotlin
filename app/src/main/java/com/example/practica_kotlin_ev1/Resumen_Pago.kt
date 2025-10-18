package com.example.practica_kotlin_ev1

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResumirPago() {
    val numtarjeta = stringResource(id = R.string.numtarjeta)
    val fecha = stringResource(id = R.string.fechaCaducidad)
    val tipotarjeta = stringResource(id = R.string.tipotarjeta)
    val cvc = stringResource(id = R.string.CVC)
    val nombre = stringResource(id = R.string.nombre)
    val apellidos = stringResource(id = R.string.apellido)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top =100.dp)
            .background(Color(0xFFEDE7F6)),
        verticalArrangement = Arrangement.Center //centrar la columna verticalmente
    ) {

        Text("RESUMEN DEL PAGO:",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(40.dp))
        Text(
            "Tipo de tarjeta: $tipotarjeta" +
                    "\nNombre de la tarjeta: $nombre $apellidos" +
                    "\nFecha de Caducidad: $fecha" +
                    "\nCVC: $cvc" +
                    "\nNúmero de Tarjeta: $numtarjeta",
            fontSize = 20.sp,
            fontWeight = FontWeight.Black
        )
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text("ACEPTAR", color = Color.White, fontSize = 30.sp)
            }

            Spacer(modifier = Modifier.width(40.dp))

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
            ) {
                Text("ENVIAR", color = Color.White, fontSize = 30.sp)
            }
        }
    }
}