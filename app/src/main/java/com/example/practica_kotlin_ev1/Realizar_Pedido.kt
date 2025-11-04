package com.example.practica_kotlin_ev1

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
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_kotlin_ev1.Objeto_Pizza.Data_Pedido

//----------------------------CÓDIGO DE REALIZAR PEDIDO----------------------

//Estructura general
@Composable
    fun Pantalla_RealizarPedido( modifier: Modifier = Modifier){

        //Variables para que se pasen entre funciones luego
    var tipoSeleccionado by remember { mutableStateOf("") }  //tipo de pizza
    var tamanyoPizza by remember {mutableStateOf("")} //tamaño pizza
    var tipoBotella by remember {mutableStateOf("")}
    var extra1 by remember { mutableStateOf("") }  //tipo de pizza
    var extra2 by remember { mutableStateOf("") }  //tipo de pizza
    var cantidadPizzas by remember { mutableStateOf(1) } //cantidad de pizzas
    var cantidadBotellas by remember {mutableStateOf(1)}

    var precioglobal by remember {mutableStateOf(0.0)}



        Column(modifier
            .fillMaxWidth()){
            // Función que cambia el tipo de pizza
            seleccion_tipopizza(
                tipoSeleccionado = tipoSeleccionado,
                extra1 = extra1,
                extra2 = extra2,
                onTipoChange = { nuevoTipo ->
                    tipoSeleccionado = nuevoTipo
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            seleccion_tamanyopizza(
                    tamanyoPizza = tamanyoPizza,
                onTamanyoChange = { nuevoSize ->
                    tamanyoPizza = nuevoSize
                }
                    )
            Spacer(modifier = Modifier.height(16.dp))
            seleccion_bebida(
                tipoBotella = tipoBotella,
                onBotellaChange = { nuevaBebida ->
                    tipoBotella = nuevaBebida
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Función que muestra imagen y cantidad
            cantidades_pedido(
                tipoSeleccionado = tipoSeleccionado,
                tipoBotella = tipoBotella,
                cantidadPizzas = cantidadPizzas,
                cantidadBotellas = cantidadBotellas,
                onCantidadPizza = { nuevaCantidad ->
                    cantidadPizzas = nuevaCantidad
                },
                onCantidadBebida = { nuevaCantidad ->
                    cantidadBotellas = nuevaCantidad
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            precios()
        }
    }


@Composable
fun seleccion_tipopizza(
    tipoSeleccionado: String,
    extra1: String,
    extra2: String,
    onTipoChange: (String) ->Unit
    ) {

    var variable_tipopizza = tipoSeleccionado //variable tipopizza es el string para pasarlo a todas las funciones
    var variable_extra_1 = extra1
    var variable_extra_2  = extra2

    val seleccionarpizza = stringResource(R.string.eligepizzatexto)
    val margarita = stringResource(R.string.pizza_margarita)
    val barbacoa = stringResource(R.string.pizza_barbacoa)
    val romana = stringResource(R.string.pizza_romana)
    val extra_piña = stringResource(R.string.extramargaritapiña)
    val extra_veg = stringResource(R.string.extramargaritavegana)
    val extra_poll = stringResource(R.string.extrabarbacoapollo)
    val extra_cer = stringResource(R.string.extrabarbacoacarne)
    val extra_cha = stringResource(R.string.extraromanachampiñon)
    //booleanos de extras
    var conPinaCheckbox by remember { mutableStateOf(false)}
    var conVeganaCheckbox by remember {mutableStateOf(false)}
    var conPolloCheckbox by remember { mutableStateOf(false)}
    var conTerneraCheckbox by remember { mutableStateOf(false)}
    var conCarneCheckbox by remember { mutableStateOf(false)}
    var conChampinonesCheckbox by remember { mutableStateOf(false)}
    //Variables y extras



    Data_Pedido( //Poner primeros datos del objeto pizza
        tipo_pizza = variable_tipopizza,
        extra_1 = variable_extra_1,
        extra_2 = variable_extra_2
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier //Row cabecera
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.pizzalogo),
                contentDescription = stringResource(R.string.descfotomain),
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
                contentDescription = stringResource(R.string.descfotomain),
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
                { onTipoChange(margarita)
                    conPinaCheckbox = false //Al ponerlos false de nuevo evita que se puedan poner de mas
                    conVeganaCheckbox = false
                variable_extra_1= ""
                variable_extra_2= ""},
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)) {
                Text(
                    margarita, fontSize = 15.sp, textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
//------BOTON BARBACOA-------
            /*TODO: hacerlo radiobuttons en barbacoa*/
            Button(
                { onTipoChange(barbacoa)
                    conCarneCheckbox = false
                    conTerneraCheckbox = false
                    conPolloCheckbox = false
                    variable_extra_1= ""
                    variable_extra_2= ""},
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)) {
                Text(
                    barbacoa, fontSize = 15.sp, textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
//------BOTON ROMANA-------
            Button(
                { onTipoChange(romana)
                    conChampinonesCheckbox = false
                    variable_extra_1= ""
                    variable_extra_2= ""},
                modifier = Modifier.weight(1F),
                shape = RoundedCornerShape(8.dp)){
                Text(
                    romana, fontSize = 15.sp, textAlign = TextAlign.Center
                )
            } }


        // Extras para Margarita
        if (variable_tipopizza == margarita) {
            Column{
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = conPinaCheckbox,
                        onCheckedChange = {
                            conPinaCheckbox = it
                            if (it) variable_extra_1 = extra_piña //se asigna valor
                            else if (!conPinaCheckbox) variable_extra_1 = "" //si no se les seleccionan siguen igual
                        }
                    )
                    Text(extra_piña)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = conVeganaCheckbox,
                        onCheckedChange = {
                            conVeganaCheckbox = it
                            if (it) variable_extra_2 = extra_veg
                            else if (!conVeganaCheckbox) variable_extra_2 = ""
                        }
                    )
                    Text(extra_veg)
                }
            }
            //Extras barbacoa
        } else if (variable_tipopizza == barbacoa) {
            Column{
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = conPolloCheckbox,
                        onCheckedChange = {
                            conPolloCheckbox = it
                            if (it) variable_extra_1 = extra_poll
                            else if (!conPolloCheckbox) variable_extra_1 = "" //si no se les seleccionan siguen igual
                        }
                    )
                    Text(extra_poll)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = conCarneCheckbox,
                        onCheckedChange = {
                            conCarneCheckbox = it
                            if (it) variable_extra_2 = extra_cer
                            else if (!conCarneCheckbox) variable_extra_2 = ""
                        }
                    )
                    Text(extra_cer)
                }
            }
            //Extras romana
        } else if (variable_tipopizza == romana){
            Column{
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = conChampinonesCheckbox,
                        onCheckedChange = {
                            conChampinonesCheckbox = it
                            if (it) variable_extra_1 = extra_cha
                            else if (!conChampinonesCheckbox) variable_extra_1 = "" //si no se les seleccionan siguen igual
                        }
                    )
                    Text(extra_cha)
                }
        }
    }}}

//------------SELECCIONAR TAMAÑO PIZZA-------------
@Composable
fun seleccion_tamanyopizza(modifier: Modifier = Modifier,
tamanyoPizza: String ,
      onTamanyoChange: (String) -> Unit) {

val textotamanyo = stringResource(R.string.tamanyopizzatexto)

  var tamanyoPizza by remember {mutableStateOf("")}
    val peque = stringResource(R.string.pequeña)
    val mediana = stringResource(R.string.mediana)
    val grande = stringResource(R.string.grande)
    var sumarprecio by remember {mutableStateOf(0)}

    Data_Pedido( //Ir actualizando datos del objeto
         tamanyo_pizza = tamanyoPizza
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
            {tamanyoPizza = peque
            sumarprecio + 4.95
            }, //basta con sumarlo (no se porque ponerlo con = no funciona)
            modifier = Modifier.weight(1F),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                peque, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(18.dp))
        Button(
            { tamanyoPizza = mediana
            sumarprecio + 6.95},
            modifier = Modifier.weight(1F),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                mediana, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(18.dp))

        Button(
            { tamanyoPizza = grande
            sumarprecio + 10},
            modifier = Modifier.weight(1F),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                grande, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        } }
}

//------------SELECCIONAR BOTELLA-------------
@Composable
fun seleccion_bebida(
    tipoBotella: String,
    onBotellaChange: (String) ->Unit
) {


    val textobebida = stringResource(R.string.eligebebida)

    var bebida = tipoBotella
    val agua = stringResource(R.string.agua)
    val cocacola = stringResource(R.string.Cola)
    val nada = stringResource(R.string.ninguno)
    var sumarprecio by remember {mutableStateOf(0)}

    Data_Pedido( //Ir actualizando datos del objeto
        tipo_bebida = bebida
    )


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
                sumarprecio + 1.5
            }, //basta con sumarlo (no se porque ponerlo con = no funciona)
            modifier = Modifier.weight(1F)
        ) {
            Text(
                agua, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        }
        Button(
            { onBotellaChange(cocacola)
                sumarprecio + 2},
            modifier = Modifier.weight(1F)
        ) {
            Text(
                cocacola, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        }
        Button(
            { onBotellaChange(nada)
            },
            modifier = Modifier.weight(1F)
        ) {
            Text(
                nada, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        } }
}

@Composable
fun cantidades_pedido(
    tipoSeleccionado: String,
    tipoBotella: String,
    cantidadPizzas: Int,
    cantidadBotellas: Int,
    onCantidadPizza: (Int) -> Unit,
    onCantidadBebida: (Int) -> Unit

) {
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
            onClick = { if (cantidadPizzas > 0) onCantidadPizza(cantidadPizzas--) }, //Poner onCantidadChange (si no no se acualizara)
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
            onClick = { onCantidadPizza(cantidadPizzas++) },
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
            onClick = { if (cantidadBebidas > 0) onCantidadBebida(cantidadBebidas--) }, //Poner onCantidadChange (si no no se acualizara)
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
            onClick = { onCantidadBebida(cantidadBebidas++) },
            colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFF16A41B))
        ) {
            Text("+", fontSize = 40.sp,
                fontWeight = FontWeight.Bold)
        }
    }
        }



@Composable
fun precios() {
   Row(modifier = Modifier
       .fillMaxWidth()){

       val pagar = stringResource(R.string.botonpagar)
       val cancelar = stringResource(R.string.botoncancelar)

    Button(onClick = { },
        modifier = Modifier.weight(1F),
       colors = ButtonDefaults.buttonColors
       (containerColor =  Color(0xFFDA0737)))
       {
        Text(cancelar)
    }
       Button(onClick = { },
           modifier = Modifier.weight(1F),
           colors = ButtonDefaults.buttonColors
               (containerColor =  Color(0xFF1B9A0C)))
           {
        Text(pagar)
       }
   }
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color(color = 0xFF4432AB))
        .border(
            width = 3.dp,
            color = Color.Black,
            shape = RoundedCornerShape(8.dp)
        )){
        Text("Precio",
            textAlign = TextAlign.Center
            , color = White
            , fontWeight = FontWeight.Bold
        , fontSize = 20.sp)
    }
}