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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_kotlin_ev1.R

//----------------------------CÓDIGO DE REALIZAR PEDIDO----------------------

@Composable
fun Pantalla_RealizarPedido(
    modifier: Modifier = Modifier,
    onBotonSiguientePulsado: () -> Unit,
    onBotonAtrasPulsado: () -> Unit,
    viewModel: AppViewModel
) {
    // Estados locales
    var tipoSeleccionado by remember { mutableStateOf("") }
    var tamanyoPizza by remember { mutableStateOf("") }
    var tipoBotella by remember { mutableStateOf("") }
    var precioTamanyo by remember { mutableStateOf(0.0) }
    var precioBebida by remember { mutableStateOf(0.0) }
    var cantidadPizzas by remember { mutableStateOf(1) }
    var cantidadBotellas by remember { mutableStateOf(1) }

    // Precio global derivado
    val precioglobal = (cantidadPizzas * precioTamanyo) + (cantidadBotellas * precioBebida)

    Column(modifier.fillMaxWidth()) {
        seleccion_tipopizza()
        Spacer(modifier = Modifier.height(16.dp))

        seleccion_tipopizza()
        Spacer(modifier = Modifier.height(16.dp))

        seleccion_bebida()
        Spacer(modifier = Modifier.height(16.dp))

        cantidades_pedido()

        Spacer(modifier = Modifier.height(16.dp))

        precios( onBotonSiguientePulsado: () -> Unit,
            onBotonAtrasPulsado: () -> Unit)
    }
}
@Composable
fun seleccion_tipopizza() {

    val seleccionarpizza = stringResource(R.string.eligepizzatexto)
    val margarita = stringResource(R.string.pizza_margarita)
    val barbacoa = stringResource(R.string.pizza_barbacoa)
    val romana = stringResource(R.string.pizza_romana)
    val extra_piña = stringResource(R.string.extramargaritapiña)
    val extra_veg = stringResource(R.string.extramargaritavegana)
    val extra_poll = stringResource(R.string.extrabarbacoapollo)
    val extra_cer = stringResource(R.string.extrabarbacoacarne)
    val extra_ter = stringResource(R.string.extrabarbacoaternera)
    val extra_cha = stringResource(R.string.extraromanachampiñon


    Column(modifier = Modifier
            .fillMaxWidth()) {

        Row(
            modifier = Modifier //Row cabecera
                .fillMaxWidth(),
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
                seleccionarpizza //asi no hace falta poner "$ ya que solo pongo la variable"
                , fontSize = 25.sp, textAlign = TextAlign.Center, modifier = Modifier
                    .weight(1F)
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
            modifier = Modifier, //Row para los botones
            verticalAlignment = Alignment.CenterVertically
        ) {
//------BOTON MARGARITA-------
            Button(
                {},
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    margarita, fontSize = 15.sp, textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
//------BOTON BARBACOA-------
            /*TODO: hacerlo radiobuttons en barbacoa*/
            Button(
                { },
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    barbacoa, fontSize = 15.sp, textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
//------BOTON ROMANA-------
            Button(
                { },
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    romana, fontSize = 15.sp, textAlign = TextAlign.Center
                )
            }
        }
    }}
//------------SELECCIONAR TAMAÑO PIZZA-------------
@Composable
fun seleccion_tamanyopizza(modifier: Modifier = Modifier){

val textotamanyo = stringResource(R.string.tamanyopizzatexto)
  var tamanyoPizza = tamanyoPizza
    val peque = stringResource(R.string.pequeña)
    val mediana = stringResource(R.string.mediana)
    val grande = stringResource(R.string.grande)

    Data_Pedido( //Ir actualizando datos del objeto
         tamanyo_pizza = tamanyoPizza,
    )

    Row(modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically){
        Image(
            painterResource(R.drawable.size),
            contentDescription = "size",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .weight(1F)
        )

        Text(textotamanyo
        , fontSize = 25.sp,
            modifier = Modifier
                .weight(1F))

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
        modifier = Modifier, //Row para los botones
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(
            {onTamanyoChange(peque) //Poner tamaño en peque
                onTamanyoPrecioChange(4.95) //Hay que actualizrlo a un estado fijo , si no se acumulara
            },
            modifier = Modifier.weight(1F),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                peque, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(18.dp))
        Button(
            { onTamanyoChange(mediana) //Poner tamaño en mediana
                onTamanyoPrecioChange(6.95)},
            modifier = Modifier.weight(1F),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                mediana, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(18.dp))

        Button(
            {onTamanyoChange(grande) //Poner tamaño en grande
                onTamanyoPrecioChange(+10.0)},
            modifier = Modifier.weight(1F),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                grande, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        } }
    val textodeseleccion = stringResource(R.string.tamanyoseleccionado)
    Text("$textodeseleccion $tamanyoPizza",
        fontSize = 20.sp,
        textAlign = TextAlign.Left)
}

//------------SELECCIONAR BOTELLA-------------
@Composable
fun seleccion_bebida(){

    val textobebida = stringResource(R.string.eligebebida)
    val agua = stringResource(R.string.agua)
    val cocacola = stringResource(R.string.Cola)
    val nada = stringResource(R.string.ninguno)


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
            {onBotellaChange(agua) //cambiar a agua
                onTipoBebidaPrecioChange(1.5)
            },
            modifier = Modifier.weight(1F)
        ) {
            Text(
                agua, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        }
        Button(
            { onBotellaChange(cocacola)
                onTipoBebidaPrecioChange(2.0)},
            modifier = Modifier.weight(1F)
        ) {
            Text(
                cocacola, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        }
        Button(
            { onBotellaChange(nada)
            onTipoBebidaPrecioChange(0.0)},
            modifier = Modifier.weight(1F)
        ) {
            Text(
                nada, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        } }
}

@Composable
fun cantidades_pedido() {

    var tipoSeleccionado = tipoSeleccionado
    var cantidadPizzas = cantidadPizzas //saber cuantas pediremos
    var cantidadBebidas = cantidadBotellas //saber cuantas bebidas pediremos

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
    Text("$textcantidadpizza: $cantidadPizzas",
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 8.dp))


    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = {
                if (cantidadPizzas > 0) {
                    val nuevaCantidad = cantidadPizzas - 1
                    onCantidadPizza(nuevaCantidad)
                    onPrecioChange(nuevaCantidad * precio_tamanyo)
                }},
            colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFFDA0737))
        ) {
            Text("-", fontSize = 40.sp,
                fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.width(16.dp))

        when (tipoSeleccionado) {
            margarita -> Image(painterResource(R.drawable.margarita), margarita, Modifier.size(90.dp))
            barbacoa  -> Image(painterResource(R.drawable.barbacoa), barbacoa, Modifier.size(90.dp))
            romana    -> Image(painterResource(R.drawable.romana), romana, Modifier.size(90.dp))
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = {val nuevaCantidad = cantidadPizzas +1
                      onCantidadPizza(nuevaCantidad)
                      onPrecioChange(nuevaCantidad * precio_tamanyo)},
            colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFF16A41B))
        ) {
            Text("+", fontSize = 40.sp,
                fontWeight = FontWeight.Bold)
        }
    }
//---------CANTIDAD BEBIDAS

    // Mostrar cantidad actual de bebidas
    Text("$textcantidadbotella: $cantidadBebidas",
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 8.dp))

    Row(  modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){

        Button(
            onClick = {
                if (cantidadBebidas > 0) {
                    val nuevaCantidad = cantidadBebidas - 1
                    onCantidadBebida(nuevaCantidad)
                    onPrecioChange((cantidadPizzas * precio_botella) + (nuevaCantidad * precio_botella))
                }
            } ,
            colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFFDA0737))
        ) {
            Text("-", fontSize = 40.sp,
                fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.width(16.dp))

        when (tipoBotella) {
            agua -> Image(painterResource(R.drawable.agua), agua, Modifier.size(90.dp))
            cocacola  -> Image(painterResource(R.drawable.cola), cocacola, Modifier.size(90.dp))
            nada -> Image(painterResource(R.drawable.x), contentDescription = nada, Modifier.size(90.dp))
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = { val nuevaCantidad = cantidadBebidas +1
                onCantidadBebida(nuevaCantidad)
                onPrecioChange(nuevaCantidad * precio_tamanyo) },
            colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFF16A41B))
        ) {
            Text("+", fontSize = 40.sp,
                fontWeight = FontWeight.Bold)
        }
    }
        }

@Composable
fun ponerPrecio(){

}
@Composable
fun precios(
    onBotonAtrasPulsado: () -> Unit,
    onBotonSiguientePulsado: () ->Unit
) {
    val preciotexto = stringResource(R.string.preciotexto)
    val pagar = stringResource(R.string.botonpagar)
    val cancelar = stringResource(R.string.botoncancelar)

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { onBotonAtrasPulsado() }, modifier = Modifier.weight(1F)) {
                Text(cancelar)
            }
            Button(
                onClick = {
                    viewModel.actualizarPedido(nuevoPedido)
                    onBotonSiguientePulsado()
                },
                modifier = Modifier.weight(1F),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B9A0C))
            ) {
                Text(pagar)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("$preciotexto $preciofinal €",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4432AB),
            modifier = Modifier.padding(16.dp)
        )
    }
}
