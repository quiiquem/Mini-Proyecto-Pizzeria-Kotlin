package ui

import AppViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_kotlin_ev1.R

@Composable
fun ResumirPedido(
    onBotonSiguientePulsado: () -> Unit,
    onBotonAtrasPulsado: () -> Unit,
    viewModel: AppViewModel
) {

    Column(modifier = Modifier) {
        Resumen_Pago(viewModel)
        Botones_Navigation(
            onBotonSiguientePulsado, onBotonAtrasPulsado
        )
    }
}

@Composable
fun Resumen_Pago(viewModel: AppViewModel) {

    // VALORES (viewModel)
    val tipoPizza = viewModel.tipoPizza
    val extraPizza1 = viewModel.extra1
    val extraPizza2 = viewModel.extra2
    val tamanyoPizza = viewModel.tamanyoPizza
    val bebidaPizza = viewModel.tipoBebida
    val cantidadPizzas = viewModel.cantidad_Pizzas
    val cantidadBebidas = viewModel.cantidad_Bebidas
    val precioglobal = viewModel.precioGlobal

    // TEXTOS (localización)
    val resumenpedidotexto = stringResource(R.string.resumenpedidotexto)
    val tipopizzatexto = stringResource(R.string.tipopizzatexto)
    val tamanyopizzatexto = stringResource(R.string.tamanyopizzatexto)
    val bebidatexto = stringResource(R.string.tipobebidatexto)
    val cantidadPizza = stringResource(R.string.cantidadpizzatexto)
    val cantidadBebida = stringResource(R.string.cantidadbotellastexto)
    val preciotexto = stringResource(R.string.preciotexto)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = resumenpedidotexto,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                Text(
                    text = "$tipopizzatexto = $tipoPizza" +
                            "\n$tamanyopizzatexto = $tamanyoPizza" +
                            "\n$bebidatexto = $bebidaPizza" +
                            "\n$cantidadPizza = $cantidadPizzas" +
                            "\n$cantidadBebida = $cantidadBebidas" +
                            "\n$preciotexto: $precioglobal",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun Botones_Navigation(
    onBotonSiguientePulsado: () -> Unit, onBotonAtrasPulsado: () -> Unit
) {
    //BOTONES (localizacion)
    val pagar = stringResource(R.string.botonpagar)
    val cancelar = stringResource(R.string.botoncancelar)

    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { onBotonSiguientePulsado() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)) //color verde!
        ) {
            Text("$pagar", color = Color.White, fontSize = 30.sp)
        }

        Spacer(modifier = Modifier.width(40.dp)) // separador horizontal

        Button(
            onClick = { onBotonAtrasPulsado() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)) //color rojo!
        ) {
            Text("$cancelar", color = Color.White, fontSize = 30.sp)
        }
    }
}
