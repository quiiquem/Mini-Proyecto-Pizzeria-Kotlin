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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
         modifier = modifier //modificador que afecta a toda la columna
             .background(Color(0xFFFFF8E7)) //background de toda la pantalla
             .padding(top = 150.dp)
             .fillMaxWidth(), //hacer que ocupe toda la pantalla, para que no quede espacio en blanc
            horizontalAlignment = Alignment.CenterHorizontally,

     ) {

        Row( modifier = modifier
            .background(Color(0xFFFFF8E7)),
            verticalAlignment = Alignment.CenterVertically) { /*Un row para poder poner la
            imagen a la izquierda y el texto a la derecha como tenia pensado*/

            Image(
                painterResource(R.drawable.bobeponja), //la misma imagen
                contentDescription = "Foto de perfil del usuario", //descripcion de img en caso de que no cargue
                modifier = Modifier //permitir que podamos modificar propiedades de la img
                .size(130.dp) //poner tamaño a la img
                )

            val nombre = stringResource(id = R.string.nombre) //nombre del usuario que tenemos
            Text(
                //texto para darle la bienvenida
                "¡Bienvenido a Pizza Time " + nombre + "!",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
            )
        }

         //BOTON REALIZAR PEDIDO
         Button(
             onClick = {/*TODO*/ },
             colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
         ) {
             Text(
                 "Realizar Pedido",
                 fontSize = 40.sp
             )
         }

         Spacer(modifier = Modifier.padding(40.dp)) //separador ou yea

         //BOTON LISTAR PEDIDOS
         Button(
             onClick = {/*TODO*/ },
             colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
         ) {
             Text(
                 "Listar Pedidos",
                 fontSize = 40.sp
             )
         }

         //BOTON INFORMACION

         //Script que muestra datos
         var mostrardatos by remember { mutableStateOf(false) } //hacer que se acuerde y no lo muestre de repente
         if (mostrardatos) { //si se le da al boton y se habilita :
            //*vals para poner el nombre apellido gmail y telefono
             val nombre = stringResource(id = R.string.nombre)
            val apellidos = stringResource(id = R.string.apellido)
             val gmail = stringResource(id = R.string.gmail)
             val telefono = stringResource(id = R.string.num)

             AlertDialog( //Ventana emergente para que quede mucho mejor
                 onDismissRequest = { mostrardatos = false },
                 confirmButton = { //Boton para que confirme y se quite
                     Button(onClick = { mostrardatos = false }) { //que se quite si lo acepta
                         Text("Aceptar")
                     }
                 }, //contenido de la ventana:
                 title = { Text("Datos del usuario") },
                 text = { Text("Nombre: "+nombre+"\n" +
                         "Apellidos: "+apellidos+"\n" +
                         "Gmail: "+gmail+"\n"+
                         "Telefono: "+telefono) }
             )
         }

         Box( //para poder alinear un boton en concreto hay que meterlo en una caja
             modifier = Modifier.fillMaxSize() // hacer que llegue a esquina
         ) {
             Button(
                 onClick = { mostrardatos = true }, //habilita el script de mostrar datos de arriba
                 modifier = Modifier
                     .align(Alignment.BottomEnd) //ponerlo al fondo derecha (podria borrar esto la vdd)
                     .padding(bottom = 200.dp), //subirlo al centro
                 colors = ButtonDefaults.buttonColors(Color(0xCC2CA49F))
             ) {
                 Text("Mis Datos")
             }
         }
     }
}