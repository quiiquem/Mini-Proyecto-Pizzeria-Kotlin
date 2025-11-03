package com.example.practica_kotlin_ev1

import android.R.attr.background
import android.R.id.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_kotlin_ev1.Objeto_Usuario.Data_Usuario

@Composable

fun Pantalla_Principal(modifier: Modifier = Modifier){
    Column(modifier
        .background(Color(0xFFFFEDE8)) //debo cambiar esto
        .fillMaxSize()){
        mensajebienvenida() //he empezado a dividrlo en partes más pequeñas como en los documentos por organización
        datosusuario()
        botonesmain()
    }
}

//Parte superior de bienvenida
@Composable
fun mensajebienvenida(modifier : Modifier = Modifier) {
    //Variables val para el text
    val mensajebienvenida = stringResource(R.string.mensajemain)
    val nombreusuario = Data_Usuario(nombre = ("Juan")) //Ya no es un string resource, si no un valor de un objeto

    Row(
        modifier
            .clip(RoundedCornerShape(2.dp)) //borde para las esquinas
        ,verticalAlignment = Alignment.CenterVertically
    ) { //Rediseño de la parte superior
        Text(
            "$mensajebienvenida , ${nombreusuario.nombre} ",//poner el nombre de data usuario
            textAlign = TextAlign.Left,
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis, // Overflow de texto, baja si se acaba el "espacio"
            modifier = Modifier.weight(1f) //hace que ocupe el espacio que tiene (evita muchos spacers)
                .padding(start = 20.dp)
        )
        Image(
            painterResource(R.drawable.bobeponja),
            contentDescription = stringResource(R.string.descfotomain),
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape) //hacer que este como un circulo
        )
    }
}


    //Card para mostrar los datos del usuario
    @Composable
    fun datosusuario(modifier: Modifier = Modifier) {
        val usuario = Data_Usuario( //Crear una variable que coga los valores de dataclass y ponerle datos
            nombre = "Juan",
            apellidos = "García López",
            correo = "juanitoperez04@gmail.com",
            tel = 422983910
        )

        val textonumero = stringResource(R.string.number) //localizaciones
        Card( //Card para mostrar los datos
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(8.dp), //hacer la tarjeta un poco "redonda"
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = usuario.nombre, fontSize = 18.sp)
                Text(text = usuario.apellidos, fontSize = 18.sp)
                Text(text =  usuario.correo, fontSize = 18.sp)
                Text(text = "$textonumero : ${usuario.tel}", fontSize = 18.sp) //telefono al ser int en data se pone de forma diferente
            }
        }
    }


    //Botones de listar pedido y realizar pedido
@Composable
    fun botonesmain(){
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
                Button({}) {
                    Text("$realizarpedido"
                        , fontSize = 25.sp
                        , textAlign = TextAlign.Center
                        , modifier = Modifier.weight(1F))
                }
            }
            }
    }