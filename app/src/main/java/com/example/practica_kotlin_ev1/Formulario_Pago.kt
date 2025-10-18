package com.example.practica_kotlin_ev1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Formulario_Pago() {
    Column(modifier = Modifier
        .padding(top = 50.dp)
        .fillMaxWidth()) {

        var nombre by remember { mutableStateOf("") }
        var tarjetafinal by remember {mutableStateOf("")} //valor que debe guardar el select
        val tarjetas = listOf("VISA","MasterCard","Euro 6000") //valores a elegir, me escrio este comentario para q no se me olvide en el examen
        var numtarjeta by remember {mutableStateOf("")}
        var CVC by remember {mutableStateOf("")}
        var Fecha by remember{mutableStateOf("")}

        Text("| Proceso de Pago |",
            fontSize = 40.sp,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(40.dp))

        //PEDIR NOMBRE
        Text("Tipo de tarjeta: ")

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre y apellidos") },
            placeholder = { Text("Introduce el nombre de la tarjeta") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        //PEDIR TIPO TARJETA
        Text("Tipo de tarjeta: ")

        Column(Modifier.selectableGroup()) {
            tarjetas.forEach { opcion -> //recordatorio: aqui poner el val (el q tiene listOf)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .selectable(
                            selected = (tarjetafinal == opcion), //aqui el var para que se guarde la seleccion, no al reves
                            onClick = { tarjetafinal = opcion }
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (tarjetafinal == opcion),
                        onClick = { tarjetafinal = opcion }
                    )
                    Text(
                        opcion,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        //NUMERO DE TARJETA
        Text("Num. de tarjeta: ")
        TextField(
            value = numtarjeta,
            onValueChange = { numtarjeta = it },
            label = { Text("Número de tarjeta") },
            placeholder = { Text("Introduce el num. de la tarjeta") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        //FECHA
        Spacer(modifier = Modifier.height(40.dp))
        Text("Fecha de caducidad: ")
        TextField(
            value = Fecha,
            onValueChange = { Fecha = it },
            label = { Text("Fecha de caducidad") },
            placeholder = { Text("Introduce la fecha de caducidad") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(40.dp))
        //NUMERO DE TARJETA
        Text("Num. de tarjeta: ")
        TextField(
            value = numtarjeta,
            onValueChange = { numtarjeta = it },
            label = { Text("Número de tarjeta") },
            placeholder = { Text("Introduce el num. de la tarjeta") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        //CVC
        Spacer(modifier = Modifier.height(40.dp))
        Text("CVC: ")
        TextField(
            value = CVC,
            onValueChange = { CVC = it },
            label = { Text("CVC") },
            placeholder = { Text("Introduce el CVC") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

    //Botones
        Row(){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)) //color verde!
    ) {
        Text("PAGAR", color = Color.White, fontSize = 20.sp)
    }

    Spacer(modifier = Modifier.width(40.dp)) // separador horizontal

    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)) //color rojo!
    ) {
        Text("CANCELAR", color = Color.White, fontSize = 20.sp)
            }
}}
}

