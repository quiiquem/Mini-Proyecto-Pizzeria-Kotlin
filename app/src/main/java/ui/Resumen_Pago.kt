package ui

import AppViewModel
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
fun ResumirPago(     onBotonSiguientePulsado: () -> Unit,
                     onBotonAtrasPulsado: () -> Unit,
    viewModel: AppViewModel) {

    //VALORES DEL RESUMEN
    val numtarjeta = stringResource(id = R.string.numtarjeta)
    val fecha = stringResource(id = R.string.fechaCaducidad)
    val tipotarjeta = stringResource(id = R.string.tipotarjeta)
    val cvc = stringResource(id = R.string.CVC)

    //VALORES de texto (localizacion)
    val tarjetatexto =stringResource(R.string.tarjetatexto)
    val numtarjetatexto = stringResource(R.string.numtarjetatexto)
    val fechacaducidadtexto =stringResource(R.string.fechacaducidadtexto)

    //BOTONES (loclizacion)
    val botonaceptar = stringResource(R.string.botonaceptar)
    val botonenviar = stringResource(R.string.botonenviar)

    //OTROS
    val textoresumen = stringResource(R.string.resumenpagotexto)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top =100.dp)
            .background(Color(0xFFEDE7F6)),
        verticalArrangement = Arrangement.Center //centrar la columna verticalmente
    ) {

        Text("$textoresumen",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(40.dp))
        Text(
            "$tarjetatexto $tipotarjeta" +
                    "\n$fechacaducidadtexto: $fecha" +
                    "\nCVC: $cvc" +
                    "\n$numtarjetatexto: $numtarjeta",
            fontSize = 20.sp,
            fontWeight = FontWeight.Black
        )
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {  onBotonSiguientePulsado() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text("$botonaceptar", color = Color.White, fontSize = 30.sp)
            }

            Spacer(modifier = Modifier.width(40.dp))

            Button(
                onClick = { onBotonAtrasPulsado() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
            ) {
                Text("$botonenviar", color = Color.White, fontSize = 30.sp)
            }
        }
    }
}