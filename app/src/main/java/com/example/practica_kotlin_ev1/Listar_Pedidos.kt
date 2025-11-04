package com.example.practica_kotlin_ev1

import androidx.compose.foundation.background
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
fun ListaPedidos(){
    //VALORES PEDIDO
    val numtarjeta = stringResource(id = R.string.numtarjeta)
    val fecha = stringResource(id = R.string.fechaCaducidad)
    val tipotarjeta = stringResource(id = R.string.tipotarjeta)
    val cantidadBotella = stringResource(id = R.string.cantidadBotellas)
    val tipoPizza = stringResource(id = R.string.pizza_margarita)
    val bebida = stringResource(id = R.string.bebida)
    val cantidadPizza = stringResource(id = R.string.cantidadPizzas)
    val nombre = stringResource(id = R.string.nombre)
    val apellidos = stringResource(id = R.string.apellido)

    //VALORES de texto (localizacion)
    val nombretexto = stringResource(R.string.nomtexto)
    val apellidostexto = stringResource(R.string.apellidotexto)
    val tipopizzatexto = stringResource(R.string.tipopizzatexto)
     val tipobebidatexto = stringResource(R.string.tipobebidatexto)
     val cantidadPtexto =stringResource(R.string.cantidadpizzatexto)
     val cantidadBtexto =stringResource(R.string.cantidadbotellastexto)
     val tarjetatexto =stringResource(R.string.tarjetatexto)
     val numtarjetatexto = stringResource(R.string.numtarjetatexto)
     val fechacaducidadtexto =stringResource(R.string.fechacaducidadtexto)

    //BOTONES (loclizacion)
    val botonaceptar = stringResource(R.string.botonaceptar)
    val botonenviar = stringResource(R.string.botonenviar)

    //OTROS
    val textolistapedidos = stringResource(R.string.listapedidostexto)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top =100.dp)
            .background(Color(0xFFEDE7F6)),
        verticalArrangement = Arrangement.Center //centrar la columna verticalmente
    ) {

        Text(
            "$textolistapedidos",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text( "$nombretexto: $nombre \n$apellidostexto: $apellidos" +
                    "\n$tipopizzatexto $tipoPizza \n$tipobebidatexto $bebida" +
                    "\n$cantidadPtexto $cantidadPizza \n" +
                    "$cantidadBtexto $cantidadBotella" +
                    "\n$tarjetatexto $tipotarjeta\n$numtarjetatexto $numtarjeta" +
                    "\n$fechacaducidadtexto $fecha"
                , fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text("$botonaceptar", color = Color.White, fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.width(40.dp))

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
            ) {
                Text("$botonenviar", color = Color.White, fontSize = 20.sp)
            }
        }
    }
}
