package ui

import AppViewModel
import Data_Pedido
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practica_kotlin_ev1.R

@Composable
fun Pantalla_RealizarPedido(
    modifier: Modifier = Modifier,
    onBotonSiguientePulsado: () -> Unit,
    onBotonAtrasPulsado: () -> Unit,
    viewModel: AppViewModel = viewModel()
) {

    var precioTamanyo by remember { mutableStateOf(0.0) }
    var precioBebida by remember { mutableStateOf(0.0) }
    var cantidadPizzas by remember { mutableStateOf(1) }
    var cantidadBotellas by remember { mutableStateOf(1) }

    // Precio global derivado
    val precioglobal = (cantidadPizzas * precioTamanyo) + (cantidadBotellas * precioBebida)

    Column(modifier.fillMaxWidth()) {

        seleccion_tipopizza(viewModel) //para que sepa que existe
        Spacer(modifier = Modifier.height(16.dp))

        seleccion_tamanyopizza(viewModel)
        Spacer(modifier = Modifier.height(16.dp))

        seleccion_bebida(viewModel)
        Spacer(modifier = Modifier.height(16.dp))

        cantidades_pedido(viewModel)

        Spacer(modifier = Modifier.height(16.dp))

        precios(onBotonAtrasPulsado,onBotonSiguientePulsado,
            viewModel)
    }
}
@Composable
fun seleccion_tipopizza(viewModel: AppViewModel) {
    val seleccionarpizza = stringResource(R.string.eligepizzatexto)
    val margarita = stringResource(R.string.pizza_margarita)
    val barbacoa = stringResource(R.string.pizza_barbacoa)
    val romana = stringResource(R.string.pizza_romana)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.pizzalogo),
                contentDescription = "Pizza",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .weight(1F)
            )
            Text(
                seleccionarpizza,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1F)
            )
            Image(
                painterResource(R.drawable.pizzalogo),
                contentDescription = "Pizza",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .weight(1F)
            )
        }

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //------BOTON MARGARITA-------
            Button(
                onClick = {viewModel.actualizarTipo(margarita) }, //ponerle el tipo
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(margarita, fontSize = 15.sp, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.width(12.dp))

            //------BOTON BARBACOA-------
            Button(
                onClick = { viewModel.actualizarTipo(barbacoa) },
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(barbacoa, fontSize = 15.sp, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.width(12.dp))

            //------BOTON ROMANA-------
            Button(
                onClick = {viewModel.actualizarTipo(romana)},
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(romana, fontSize = 15.sp, textAlign = TextAlign.Center)
            }
        }
        Row() {
            val textodetipo = stringResource(R.string.pizzaeleccionadatexto)
            val tipopizza = viewModel.tipoPizza
            Text(
                "$textodetipo $tipopizza", // mostrar bebida
                fontSize = 20.sp,
                textAlign = TextAlign.Left
            )}
    }
}


//------------SELECCIONAR TAMAÑO PIZZA-------------
@Composable
fun seleccion_tamanyopizza(viewModel: AppViewModel){

    val preciotamanyo = 0
    val textotamanyo = stringResource(R.string.tamanyopizzatexto)
    val peque = stringResource(R.string.pequeña)
    val mediana = stringResource(R.string.mediana)
    val grande = stringResource(R.string.grande)

    Column {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.size),
                contentDescription = "size",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .weight(1F)
            )

            Text(
                textotamanyo,
                fontSize = 25.sp,
                modifier = Modifier.weight(1F)
            )

            Image(
                painterResource(R.drawable.size),
                contentDescription = "size",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .weight(1F)
            )
        }

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { viewModel.actualizarTamanyo(peque)
                          viewModel.actualizarPreciotamanyo(4.95)},
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(peque, fontSize = 20.sp, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.width(18.dp))

            Button(
                onClick = {
                    viewModel.actualizarTamanyo(mediana)
                    viewModel.actualizarPreciotamanyo(6.50)
                },
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(mediana, fontSize = 20.sp, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.width(18.dp))

            Button(
                onClick = {
                    viewModel.actualizarTamanyo(grande)
                    viewModel.actualizarPreciotamanyo(10.0)
                },
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(grande, fontSize = 20.sp, textAlign = TextAlign.Center)
            }
        }

        val textodeseleccion = stringResource(R.string.tamanyoseleccionado)
        val tamanyotexto = viewModel.tamanyoPizza
        Text(
            "$textodeseleccion $tamanyotexto", // mostrar tamaño
            fontSize = 20.sp,
            textAlign = TextAlign.Left
        )
    }}

//------------SELECCIONAR BOTELLA-------------
@Composable
fun seleccion_bebida(viewModel: AppViewModel){


    val textobebida = stringResource(R.string.eligebebida)
    val agua = stringResource(R.string.agua)
    val cocacola = stringResource(R.string.Cola)
    val nada = stringResource(R.string.ninguno)

Column(){
    Row(modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically){
        Image(
            painterResource(R.drawable.botellalogo),
            contentDescription = "size",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .weight(1F)
        )

        Text(textobebida
            , fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1F))

        Image(
            painterResource(R.drawable.botellalogo),
            contentDescription = "size",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .weight(1F)
        )
    }
    Row(
        modifier = Modifier, //Row para los botones
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(
            { viewModel.actualizarBebida(agua)
                viewModel.actualizarPrecioBebida(1.5)},
            modifier = Modifier.weight(1F)
        ) {
            Text(
                agua, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        }
        Button(
            { viewModel.actualizarBebida(cocacola)
                viewModel.actualizarPrecioBebida(2.0)},
            modifier = Modifier.weight(1F)
        ) {
            Text(
                cocacola, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        }
        Button(
            {   viewModel.actualizarBebida(nada)
                viewModel.actualizarPrecioBebida(0.0)},
            modifier = Modifier.weight(1F)
        ) {
            Text(
                nada, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        }



    }
    val textodeseleccion = stringResource(R.string.botellaseleccionada)
    val tipobebida = viewModel.tipoBebida
    Text(
        "$textodeseleccion $tipobebida", // mostrar bebida
        fontSize = 20.sp,
        textAlign = TextAlign.Left
    )}
}


@Composable
fun cantidades_pedido(viewModel: AppViewModel) {
    val textcantidadpizza = stringResource(R.string.cantidadpizzatexto)
    val textcantidadbotella = stringResource(R.string.cantidadbotellastexto)


    val margarita = stringResource(R.string.pizza_margarita)
    val barbacoa = stringResource(R.string.pizza_barbacoa)
    val romana = stringResource(R.string.pizza_romana)

    val agua = stringResource(R.string.agua)
    val cocacola = stringResource(R.string.Cola)
    val nada = stringResource(R.string.ninguno)

//----------CANTIDAD PIZZAS
    // Mostrar cantidad actual
    val cantidadPizzas = viewModel.cantidad_Pizzas
    Text("$textcantidadpizza: $cantidadPizzas",
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 8.dp))


    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        if(viewModel.cantidad_Pizzas == 1 ){
            Button( {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A0425))
            ){
                Text(
                    text = "-",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A) // gris medio oscuro para el texto
                )
            }
        } else {
        Button(
            onClick = {
                viewModel.actualizarCantidadPizzas(viewModel.cantidad_Pizzas-1)
            },
            colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFFDA0737))
        ) {
            Text("-", fontSize = 40.sp,
                fontWeight = FontWeight.Bold)
        }}

        Spacer(modifier = Modifier.width(16.dp))

        when (viewModel.tipoPizza) { //viewmodel que mira el tipo de pizza
            margarita -> Image(painterResource(R.drawable.margarita), margarita, Modifier.size(90.dp))
            barbacoa  -> Image(painterResource(R.drawable.barbacoa), barbacoa, Modifier.size(90.dp))
            romana    -> Image(painterResource(R.drawable.romana), romana, Modifier.size(90.dp))
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = {viewModel.actualizarCantidadPizzas(viewModel.cantidad_Pizzas+1)},
            colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFF16A41B))
        ) {
            Text("+", fontSize = 40.sp,
                fontWeight = FontWeight.Bold)
        }
    }
//---------CANTIDAD BEBIDAS

    // Mostrar cantidad actual de bebidas
    val cantidadBebida = viewModel.cantidad_Bebidas

    Text("$textcantidadbotella: $cantidadBebida",
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 8.dp))

    Row(  modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){

        if(viewModel.cantidad_Bebidas == 0){
            Button( {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A0425))
            ){
                Text(
                    text = "-",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A) // gris medio oscuro para el texto
                )
            }
        } else {
            Button(
                onClick = { viewModel.actualizarCantidadBebidas(viewModel.cantidad_Bebidas - 1) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDA0737))
            ) {
                Text(
                    "-", fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))

        when (viewModel.tipoBebida) {
            agua -> Image(painterResource(R.drawable.agua), agua, Modifier.size(90.dp))
            cocacola  -> Image(painterResource(R.drawable.cola), cocacola, Modifier.size(90.dp))
            nada -> Image(painterResource(R.drawable.x), contentDescription = nada, Modifier.size(90.dp))
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = {viewModel.actualizarCantidadBebidas(viewModel.cantidad_Bebidas+1)},
            colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFF16A41B))
        ) {
            Text("+", fontSize = 40.sp,
                fontWeight = FontWeight.Bold)
        }
    }
        }

@Composable
fun precios(
    onBotonAtrasPulsado: () -> Unit,
    onBotonSiguientePulsado: () ->Unit,
    viewModel: AppViewModel
) {
    val preciotexto = stringResource(R.string.preciotexto)
    val pagar = stringResource(R.string.botonpagar)
    val cancelar = stringResource(R.string.botoncancelar)

    val pedido = viewModel.public_DataPedido.collectAsState().value
    val precioTotal = (pedido.cantidad_pizzas * pedido.precio_tamanyo) +
            (pedido.cantidad_bebidas * pedido.precio_bebida)

    viewModel.actualizarPrecioGlobal(precioTotal)

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { onBotonAtrasPulsado() }, modifier = Modifier.weight(1F)) {
                Text(cancelar)
            }
            Button(
                onClick = {
                    onBotonSiguientePulsado()
                },
                modifier = Modifier.weight(1F),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B9A0C))
            ) {
                Text(pagar)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
Row(modifier= Modifier
    .background(Color(0xFF5509CB))
    .fillMaxWidth()
    .border(
        width = 4.dp,
        color = Color.Black,
        shape = RectangleShape
    )
    .padding(8.dp), // opcional: espacio interno
        ){
    Text("$preciotexto, $precioTotal €",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier.padding(16.dp)
    )
}

    }
}
