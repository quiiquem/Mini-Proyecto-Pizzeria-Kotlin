package com.example.practica_kotlin_ev1

import android.R.attr.background
import android.app.AlertDialog
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.innerShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_kotlin_ev1.ui.theme.Practica_Kotlin_EV1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica_Kotlin_EV1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Pantalla_Inicial(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

 @Preview

@Composable
fun Pantalla_Inicial(modifier: Modifier = Modifier) {
     Column(
         modifier = modifier
             .background(Color(0xFFFFF8E7))
             .padding(15.dp)
             .fillMaxWidth()
     ) {
         val nombre = stringResource(id = R.string.nombre)

         Text(
             "¡Bienvenido a Pizza Time " + nombre + "!",
             fontSize = 30.sp,
             textAlign = TextAlign.Center,
         ) //hacer que ponga el nombre

         Image(
             painterResource(R.drawable.bobeponja),
             contentDescription = "imagen de la persona",
         )

         Button(
             onClick = {/*TODO*/ },
             colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
         ) {
             Text(
                 "Realizar Pedido",
                 fontSize = 40.sp
             )
         }

         Spacer(modifier = Modifier.padding(50.dp)) //separador ou yea

         Button(
             onClick = {/*TODO*/ },
             colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
         ) {
             Text(
                 "Listar Pedidos",
                 fontSize = 40.sp
             )
         }

         //Boton de abajo
         var mostrardatos by remember { mutableStateOf(false) }

         if (mostrardatos) {
             val nombre = stringResource(id = R.string.nombre)
            val apellidos = stringResource(id = R.string.apellido)
             val gmail = stringResource(id = R.string.gmail)
             val telefono = stringResource(id = R.string.num)

             AlertDialog(
                 onDismissRequest = { mostrardatos = false },
                 confirmButton = {
                     Button(onClick = { mostrardatos = false }) {
                         Text("Aceptar")
                     }
                 },
                 title = { Text("Datos del usuario") },
                 text = { Text("Nombre: "+nombre+"\n" +
                         "Apellidos: "+apellidos+"\n" +
                         "Gmail: "+gmail+"\n"+
                         "Telefono: "+telefono) }
             )
         }

         Button(onClick = { mostrardatos = true }, colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) {
                Text("i")

         }
     }
}