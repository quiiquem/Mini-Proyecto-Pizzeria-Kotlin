package ui

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
import com.example.practica_kotlin_ev1.R

@Composable
fun ResumirPedido() {

    //VALORES (localizacion)
    val tipoPizza = stringResource(id = R.string.pizza_margarita)
    val extrasPizza = stringResource(id = R.string.extras)
    val tamanyoPizza = stringResource(id = R.string.tamanyo)
    val bebidas = stringResource(id = R.string.bebida)
    val cantidadPizzas = stringResource(id = R.string.cantidadPizzas)
    val cantidadBebidas = stringResource(id = R.string.cantidadBotellas)
    val precio = stringResource(id = R.string.precio)


    //BOTONES (localizacion)
    val pagar = stringResource(R.string.botonpagar)
    val cancelar = stringResource(R.string.botoncancelar)

    //OTROS (localizacion)
    val resumenpedidotexto = stringResource(R.string.resumenpedidotexto)
    val tipopizzatexto = stringResource(R.string.tipopizzatexto)
    val tamanyopizzatexto = stringResource(R.string.tamanyopizzatexto)
    val bebidatexto = stringResource(R.string.tipobebidatexto)
    val cantidadPizza = stringResource(R.string.cantidadpizzatexto)
    val cantidadBebida = stringResource(R.string.cantidadbotellastexto)
    val preciotexto = stringResource(R.string.preciotexto)



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top =100.dp)
            .background(Color(0xFFEDE7F6)),
        verticalArrangement = Arrangement.Center //centrar la columna verticalmente
    ) {

        Text("$resumenpedidotexto",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(40.dp)) // separador horizontal
        Text(
            "$tipopizzatexto $tipoPizza" +
                    "\nExtras: $extrasPizza" +
                    "\n$tamanyopizzatexto $tamanyoPizza" +
                    "\n$bebidatexto $bebidas" +
                    "\n$cantidadPizza $cantidadPizzas" +
                    "\n$cantidadBebida $cantidadBebidas" +
                    "\n$preciotexto $precio",
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
                Text("$pagar", color = Color.White, fontSize = 30.sp)
            }

            Spacer(modifier = Modifier.width(40.dp)) // separador horizontal

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)) //color rojo!
            ) {
                Text("$cancelar", color = Color.White, fontSize = 30.sp)
            }
        }
    }
}