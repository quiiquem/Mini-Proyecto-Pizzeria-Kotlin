package com.example.practica_kotlin_ev1

import android.R.attr.background
import android.R.attr.fontWeight
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
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_kotlin_ev1.ui.theme.Practica_Kotlin_EV1


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica_Kotlin_EV1 {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Pantalla_Inicial(modifier = Modifier.padding(innerPadding)) //MAIN ACTIVITY
                   // HacerPedido() //SEGUNDA PANTALLA (ELEGIR PIZZA)
                 //  ResumirPedido() //TERCERA PANTALLA (RESUMEN DEL PEDIDO)
                  //  Formulario_Pago()    //CUARTA PANTALLA (HACER PAGO)
                  //  ResumirPago() //QUINTA PANTALLA (MOSTRAR PAGO)
                 //   ListaPedidos() //ULTIMA PANTALLA (LISTA PAGOS)
                }
            }
        }
    }
}
@Composable


fun Pantalla_Inicial (modifier: Modifier = Modifier
    .background(Color(0xFFFFF8E7))) {  //color de fondo para la pantalla de main

    //TEXTOS (localizacion)
    val mensajeinicio = stringResource(R.string.mensajemain)
    val nombre = stringResource(id = R.string.nombre) // nombre del usuario que tenemos
    val apellido = stringResource(R.string.apellido) //apellido
    val gmail = stringResource(R.string.gmail) //gmail
    val tel = stringResource(R.string.num) //num de telefono

    //BOTONES

    val realizarpedidos = stringResource(R.string.realizarpedido)
    val listarpedido = stringResource(R.string.listarpedidos)
    val datos = stringResource(R.string.misdatos)

    Column(
        modifier = modifier
            .padding(top = 150.dp) // lo empuja hacia abajo para que este mas al centro
            .fillMaxWidth(), // hacer que ocupe el ancho de toda la pantalla
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row para poner la imagen a la izquierda y el texto a la derecha
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
            .background(Color(0xFFE53935)) // fondo rojo intenso
        ) {

            Image(
                painterResource(R.drawable.bobeponja), // la foto del usuario
                contentDescription = "Foto de perfil del usuario", // descripcion de la img en caso de que no cargue
                modifier = Modifier
                    .size(130.dp) // poner tamaño a la imagen
            )


            Box(
                modifier = Modifier
                    .padding(start = 16.dp)

                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    "$mensajeinicio, $nombre", // texto de bienvenida
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White // texto en color blanco
                )
            }
        }

        //ROW DATOS
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .background(Color(0xFF4D0000)) // fondo rojo intenso
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 16.dp)

                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    "DATA:\n$nombre\n$apellido\n$gmail\n$tel", // texto de bienvenida
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White // texto blanco
                )
            }
        }

        // BOTON REALIZAR PEDIDO
        Button(
            onClick = { /*TODO*/},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF388E3C)) // verde
        ) {
            Text("$realizarpedidos", fontSize = 40.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))

        // BOTON LISTAR PEDIDOS
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64B5F6)) // azul
        ) {
            Text("$listarpedido", fontSize = 40.sp, color = Color.White)
        }

        // BOTON MOSTRAR DATOS
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = {/*TODO*/ },
                modifier = Modifier
                    .align(Alignment.BottomEnd) // ponerlo al fondo derecha
                    .padding(bottom = 200.dp), // subirlo al centro
                colors = ButtonDefaults.buttonColors(Color(0xCC2CA49F))
            ) {
                Text("$datos", fontSize = 17.sp, color = Color.White)
            }
        }
    }
}
