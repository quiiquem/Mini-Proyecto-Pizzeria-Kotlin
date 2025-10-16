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
import com.example.practica_kotlin_ev1.ui.theme.Practica_Kotlin_EV1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica_Kotlin_EV1 {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Pantalla_Inicial(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Pantalla_Inicial(modifier: Modifier = Modifier) {
    // Variable para mostrar la pantalla de Realizar Pedido
    var mostrarRealizarPedido by remember { mutableStateOf(false) }

    // Variable para mostrar ventana de información del usuario
    var mostrardatos by remember { mutableStateOf(false) }

    // Si el usuario pulsa el botón de Realizar Pedido, mostramos esa pantalla
    if (mostrarRealizarPedido) {
        RealizarPedido() // Composable del otro archivo
    } else {
        // Pantalla principal
        Column(
            modifier = modifier
                .background(Color(0xFFFFF8E7)) // background de toda la pantalla
                .padding(top = 150.dp) // lo empuja hacia abajo para que este mas al centro
                .fillMaxWidth(), // hacer que ocupe el ancho de toda la pantalla
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Row para poner la imagen a la izquierda y el texto a la derecha
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painterResource(R.drawable.bobeponja), // la misma imagen
                    contentDescription = "Foto de perfil del usuario", // descripcion de la img en caso de que no cargue
                    modifier = Modifier
                        .size(130.dp) // poner tamaño a la imagen
                )

                val nombre = stringResource(id = R.string.nombre) // nombre del usuario que tenemos
                Text(
                    "¡Bienvenido a Pizza Time $nombre!", // texto de bienvenida
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            Spacer(modifier = Modifier.padding(40.dp)) // separador entre filas

            // BOTON REALIZAR PEDIDO
            Button(
                onClick = { mostrarRealizarPedido = true }, // al pulsar, cambiamos el estado para mostrar RealizarPedido
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
                Text("Realizar Pedido", fontSize = 40.sp)
            }

            Spacer(modifier = Modifier.padding(40.dp)) // separador

            // BOTON LISTAR PEDIDOS
            Button(
                onClick = { /* TODO: acción de listar pedidos */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text("Listar Pedidos", fontSize = 40.sp)
            }

            // BOTON MOSTRAR DATOS
            Box(modifier = Modifier.fillMaxSize()) { // para alinear un botón en la caja
                Button(
                    onClick = { mostrardatos = true }, // habilita el script de mostrar datos
                    modifier = Modifier
                        .align(Alignment.BottomEnd) // ponerlo al fondo derecha
                        .padding(bottom = 200.dp), // subirlo al centro
                    colors = ButtonDefaults.buttonColors(Color(0xCC2CA49F))
                ) {
                    Text("Mis Datos")
                }
            }

            // Script que muestra datos
            if (mostrardatos) { // si se le da al botón y se habilita:
                val nombre = stringResource(id = R.string.nombre)
                val apellidos = stringResource(id = R.string.apellido)
                val gmail = stringResource(id = R.string.gmail)
                val telefono = stringResource(id = R.string.num)

                AlertDialog( // Ventana emergente para que quede mucho mejor visualmente
                    onDismissRequest = { mostrardatos = false },
                    confirmButton = { // Botón para que confirme y el onclick de mostrardatos vuelva a false
                        Button(onClick = { mostrardatos = false }) { // que se quite si lo acepta
                            Text("Aceptar")
                        }
                    },
                    title = { Text("Datos del usuario") },
                    text = { Text(
                        "Nombre: $nombre\n" +
                                "Apellidos: $apellidos\n" +
                                "Gmail: $gmail\n" +
                                "Telefono: $telefono"
                    ) }
                )
            }
        }
    }
}
