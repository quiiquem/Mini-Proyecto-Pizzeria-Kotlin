package ui

import AppViewModel
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_kotlin_ev1.R

@Composable
fun Formulario_Pago(
    onBotonSiguientePulsado: () -> Unit,
    onBotonAtrasPulsado: () -> Unit,
    viewModel: AppViewModel
) {
    Column() {
        FormularioProceso(viewModel)
        BotonesNavigation(
            onBotonSiguientePulsado,
            onBotonAtrasPulsado
        )
    }
}

@Composable
fun FormularioProceso(viewModel: AppViewModel) {
    Column(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth()
    ) {

        //TEXTOS (localizacion)
        val precesopagotexto = stringResource(R.string.formpagotexto)
        val tipotarjeta = stringResource(R.string.tipotarjetatexto)
        val numtarjetatexto = stringResource(R.string.introducenumtexto)
        val fechacaducidadtexto = stringResource(R.string.introducecaducidadtexto)
        val introduceCVC = stringResource(R.string.introducecvc)

        Text(
            "$precesopagotexto",
            fontSize = 35.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painterResource(R.drawable.tarjeta),
                contentDescription = "CreditCard",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .weight(1F)
            )
            Text(
                tipotarjeta,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1F)
            )
            Image(
                painterResource(R.drawable.tarjeta),
                contentDescription = "CreditCard",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .weight(1F)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            //BOTON MASTERCARD
            Button(
                onClick = { viewModel.actualizarTipoTarjeta("MasterCard") },
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("MasterCard", fontSize = 15.sp, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.width(12.dp))

            //------BOTON VISA-------
            Button(
                onClick = { viewModel.actualizarTipoTarjeta("VISA") },
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("VISA", fontSize = 15.sp, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.width(12.dp))

            //------BOTON MASTERCARD-------
            Button(
                onClick = { viewModel.actualizarTipoTarjeta("Euro6000") },
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Euro6000", fontSize = 15.sp, textAlign = TextAlign.Center)
            }
        }

        Text(
            text = "$tipotarjeta: ${viewModel.tipoTarjeta}",
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )

        Column {
            Text(
                text = numtarjetatexto,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )

            TextField( //Al tener que insertar los datos en un textfield he tenido q cambiar numtarjeta a texto
                value = viewModel.numTarjeta,
                onValueChange = { numActual ->
                    val soloNumeros = numActual.filter { it.isDigit() }
                    val limite = soloNumeros.take(16)
                    viewModel.actualizarNumTarjeta(limite)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true
            )
        }

        Text(
            text = fechacaducidadtexto,
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )

        TextField(
            value = viewModel.fecha,
            onValueChange = { nuevaFecha ->
                val soloNumeros = nuevaFecha.filter { it.isDigit() }
                // Máximo 8 dígitos (DDMMYYYY)
                val limite = soloNumeros.take(8)

                viewModel.actualizarFecha(limite)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Text(
            text = introduceCVC,
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )

        TextField(
            value = viewModel.CVC,
            onValueChange = { nuevoCVC ->
                val soloNumeros = nuevoCVC.filter { it.isDigit() }
                val limite = soloNumeros.take(3)
                viewModel.actualizarCVC(limite)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

    }
}


@Composable
fun BotonesNavigation(
    onBotonSiguientePulsado: () -> Unit,
    onBotonAtrasPulsado: () -> Unit
) {


    //BOTONES (localizacion)
    val pagar = stringResource(R.string.botonpagar)
    val cancelar = stringResource(R.string.botoncancelar)

    //Botones
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = { onBotonAtrasPulsado() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)) //color rojo!
        ) {
            Text(cancelar, color = Color.White, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.width(40.dp)) // separador horizontal
        Button(
            onClick = { onBotonSiguientePulsado() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)) //color verde!
        ) {
            Text(pagar, color = Color.White, fontSize =15.sp)
        }
    }
}


