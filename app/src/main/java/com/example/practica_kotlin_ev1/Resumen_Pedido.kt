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
fun ResumirPedido() {

    val tipoPizza = stringResource(id = R.string.tipo)
    val extrasPizza = stringResource(id = R.string.extras)
    val tamanyoPizza = stringResource(id = R.string.tamanyo)
    val bebidas = stringResource(id = R.string.bebida)
    val cantidadPizzas = stringResource(id = R.string.cantidadPizzas)
    val cantidadBebidas = stringResource(id = R.string.cantidadBotellas)
    val precio = stringResource(id = R.string.precio)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top =100.dp)
            .background(Color(0xFFEDE7F6)),
        verticalArrangement = Arrangement.Center //centrar la columna verticalmente
    ) {

        Text("RESUMEN DEL PEDIDO:",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(40.dp)) // separador horizontal
        Text(
            "Tipo de Pizza: $tipoPizza" +
                    "\nExtras: $extrasPizza" +
                    "\nTamaño Pizza: $tamanyoPizza" +
                    "\nBebidas: $bebidas" +
                    "\nCantidad de Pizzas: $cantidadPizzas" +
                    "\nCantidad de Bebidas: $cantidadBebidas" +
                    "\nPrecio: $precio",
            fontSize = 20.sp,
            fontWeight = FontWeight.Black //ponerlo en negrita
        )
        Spacer(modifier = Modifier.height(40.dp)) // separador horizontal
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)) //color verde!
            ) {
                Text("PAGAR", color = Color.White, fontSize = 30.sp)
            }

            Spacer(modifier = Modifier.width(40.dp)) // separador horizontal

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)) //color rojo!
            ) {
                Text("CANCELAR", color = Color.White, fontSize = 30.sp)
            }
        }
    }
}