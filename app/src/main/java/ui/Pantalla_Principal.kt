package ui

import AppViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practica_kotlin_ev1.Objeto_Usuario.Data_Usuario
import com.example.practica_kotlin_ev1.R

@Composable

fun Pantalla_Principal(modifier: Modifier = Modifier,
 onBotonSiguientePulsado: () -> Unit,
   viewModel: AppViewModel = viewModel()){


    Column(modifier
        .background(Color(0xFFFFEDE8))
        .fillMaxSize()){
        mensajebienvenida("Juan") //he empezado a dividrlo en partes más pequeñas como en los documentos por organización
        datosusuario(viewModel)
        botonesmain(onBotonSiguientePulsado)
    }
}

//Parte superior de bienvenida
@Composable
fun mensajebienvenida(nombre: String) {
    val mensaje = stringResource(R.string.mensajemain)

    Row(
        modifier = Modifier
            .background(Color(0x94EC020A))
            .clip(RoundedCornerShape(2.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$mensaje, $nombre",
            textAlign = TextAlign.Left,
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(1f)
                .padding(start = 20.dp)
        )
        Image(
            painter = painterResource(R.drawable.bobeponja),
            contentDescription = stringResource(R.string.descfotomain),
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
    }
}

//Card del usuario
@Composable
fun datosusuario(
    viewModel: AppViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    // Observar el flujo de datos del usuario
    val usuario = viewModel.public_DataUsuario.collectAsState().value //coger el valor del usuario
    val textonumero = stringResource(R.string.number)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Nombre: ${usuario.nombre}", fontSize = 18.sp)
            Text(text = "Apellidos: ${usuario.apellidos}", fontSize = 18.sp)
            Text(text = "Correo: ${usuario.correo}", fontSize = 18.sp)
            Text(text = "$textonumero: ${usuario.tel}", fontSize = 18.sp)
        }
    }
}


    //Botones de listar pedido y realizar pedido
@Composable
    fun botonesmain(onBotonSiguientePulsado: () -> Unit){
        Spacer(modifier = Modifier.height(5.dp)) //Separarlo de la tarjeta de datos
        val listarpedidos = stringResource(R.string.listarpedidos)
        val realizarpedido = stringResource(R.string.realizarpedido)

        Box(modifier = Modifier //Box primero para centrarlo verticalmente
            .fillMaxWidth()
        , contentAlignment = Alignment.Center){
            Column( //Column dentro de box para poder centrar horizontalmente (y que los botones sean de arriba a abajo)
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                //Listar pedidos
                Button({}) {
                    Text("$listarpedidos"
                        , fontSize = 25.sp
                        , textAlign = TextAlign.Center
                        , modifier = Modifier.weight(1F))
                }
                Spacer(modifier = Modifier.height(25.dp))
                //Realizar pedidos
                Button(onClick = { onBotonSiguientePulsado() }) {
                    Text("$realizarpedido"
                        , fontSize = 25.sp
                        , textAlign = TextAlign.Center
                        , modifier = Modifier.weight(1F))
                }
            }
            }
    }