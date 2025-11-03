package com.example.practica_kotlin_ev1

import android.R.attr.checked
import android.R.attr.contentDescription
import android.R.attr.fontWeight
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_kotlin_ev1.Objeto_Pizza.Data_Pedido
import com.example.practica_kotlin_ev1.Objeto_Usuario.Data_Usuario

//----------------------------CÓDIGO DE REALIZAR PEDIDO----------------------

//Estructura general
@Composable
    fun Pantalla_RealizarPedido( modifier: Modifier = Modifier){
        var precioglobal by remember {mutableStateOf(0.0)} //lo pongo arriba del todo para poder usarlo en las demas funciones
        Column(modifier
            .fillMaxWidth()){
            seleccion_tipopizza(modifier)
            Spacer(modifier = Modifier.height(16.dp))
            seleccion_tamanyopizza(modifier)
            seleccion_bebida()
            seleccion_tipobebida()
            cantidades()
            precios()
        }
    }


@Composable
fun seleccion_tipopizza(modifier : Modifier) {
    val seleccionarpizza = stringResource(R.string.eligepizzatexto)
    val margarita = stringResource(R.string.tipo)
    val barbacoa = stringResource(R.string.pizza_barbacoa)
    val romana = stringResource(R.string.pizza_romana)
    val extra_piña = stringResource(R.string.extramargaritapiña)
    val extra_veg = stringResource(R.string.extramargaritavegana)
    val extra_poll = stringResource(R.string.extrabarbacoapollo)
    val extra_ter = stringResource(R.string.extrabarbacoaternera)
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
    var variable_tipopizza by remember { mutableStateOf("") }
    var variable_extra_1 by remember { mutableStateOf("") }
    var variable_extra_2 by remember { mutableStateOf("") }
    var variable_extra_3 by remember { mutableStateOf("") }

    Data_Pedido( //Poner primeros datos del objeto pizza
        tipo_pizza = variable_tipopizza,
        extra_1 = variable_extra_1,
        extra_2 = variable_extra_2,
        extra_3 = variable_extra_3
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
                , fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier
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

            Button(
                { variable_tipopizza = margarita
                    conPinaCheckbox = false
                    conVeganaCheckbox = false
                variable_extra_1= ""
                variable_extra_2= ""
                variable_extra_3= ""},
                modifier = Modifier.weight(1F)
            ) { //Boton margarita
                Text(
                    margarita, fontSize = 12.sp, textAlign = TextAlign.Center
                )
            }
            Button(
                { variable_tipopizza = barbacoa
                    conCarneCheckbox = false
                    conTerneraCheckbox = false
                    conPolloCheckbox = false
                    variable_extra_1= ""
                    variable_extra_2= ""
                    variable_extra_3= ""},
                modifier = Modifier.weight(1F)
            ) {
                Text(
                    barbacoa, fontSize = 12.sp, textAlign = TextAlign.Center
                )
            }
            Button(
                { variable_tipopizza = romana
                    conChampinonesCheckbox = false
                    variable_extra_1= ""
                    variable_extra_2= ""
                    variable_extra_3= ""},
                modifier = Modifier.weight(1F)
            ) {
                Text(
                    romana, fontSize = 12.sp, textAlign = TextAlign.Center
                )
            } }
        Spacer(modifier = Modifier.height(12.dp))

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

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = conTerneraCheckbox,
                        onCheckedChange = {
                            conTerneraCheckbox = it
                            if (it) variable_extra_3 = extra_ter
                            else if (!conTerneraCheckbox) variable_extra_3 = ""
                        }
                    )
                    Text(extra_ter)
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

@Composable
fun seleccion_tamanyopizza(modifier: Modifier = Modifier) {

val textotamanyo = stringResource(R.string.tamanyoseleccionado)

  var size by remember {mutableStateOf("")}
    val peque = stringResource(R.string.pequeña)
    val mediana = stringResource(R.string.mediana)
    val grande = stringResource(R.string.grande)
    var sumarprecio by remember {mutableStateOf(0)}

    Data_Pedido( //Ir actualizando datos del objeto
         tamanyo_pizza = size
    )

    Row(modifier = Modifier){
        Text(textotamanyo
        , fontSize = 20.sp)
    }
    Row(
        modifier = Modifier, //Row para los botones
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(
            {size = peque
            sumarprecio + 4.95
            }, //basta con sumarlo (no se porque ponerlo con = no funciona)
            modifier = Modifier.weight(1F)
        ) {
            Text(
                peque, fontSize = 12.sp, textAlign = TextAlign.Center
            )
        }
        Button(
            { size = mediana },
            modifier = Modifier.weight(1F)
        ) {
            Text(
                mediana, fontSize = 12.sp, textAlign = TextAlign.Center
            )
        }
        Button(
            { size = grande
                    },
            modifier = Modifier.weight(1F)
        ) {
            Text(
                grande, fontSize = 12.sp, textAlign = TextAlign.Center
            )
        } }
}

@Composable
fun seleccion_bebida() {
    val tipobebida = stringResource(R.string.tipobebidatexto)
}

@Composable
fun seleccion_tipobebida() {
    // Aquí irá la selección del tipo de bebida
}

@Composable
fun cantidades() {
    // Aquí irá la selección de cantidades
}

@Composable
fun precios() {
    // Aquí se mostrarán los precios
}













/*Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState) // habilita scroll
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Título principal
        Text(
            "$eligepizzatexto",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(20.dp))

        // SELECT PIZZAS NORMALES
        Column(Modifier.selectableGroup()) {
            opcionesPizza.forEach { opcion ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .selectable(
                            selected = (tipoPizza == opcion),
                            onClick = {
                                tipoPizza = opcion
                                extras =
                                    "$ninguno" //basicamente para evitar que la gente ponga extras erroneos
                            }
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (tipoPizza == opcion),
                        onClick = {
                            tipoPizza = opcion
                            extras = "$ninguno"
                        }
                    )
                    Text(
                        opcion,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        //EXTRAS PIZZA
        if (tipoPizza == "$margarita") {
            Column(Modifier.selectableGroup()) {
                opcionesMargarita.forEach { opcion ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (extras == opcion),
                                onClick = { extras = opcion }
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (extras == opcion),
                            onClick = { extras = opcion }
                        )
                        Text(
                            opcion,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
        } else if (tipoPizza == "$barbacoa") { //2. BARBACOA
            Column(Modifier.selectableGroup()) {
                opcionesBarbacoa.forEach { opcion ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (extras == opcion),
                                onClick = { extras = opcion }
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (extras == opcion),
                            onClick = { extras = opcion }
                        )
                        Text(
                            opcion,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
        } else if (tipoPizza == "$romana") { //3. ROMANA
            Column(Modifier.selectableGroup()) {
                opcionesRomana.forEach { opcion ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (extras == opcion),
                                onClick = { extras = opcion }
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (extras == opcion),
                            onClick = { extras = opcion }
                        )
                        Text(
                            opcion,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        //mensaje que muestra lo elegido
        Row(
            modifier = Modifier
                .background(Color(0xFFEDE7F6))
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Text(
                "$pizzaseleccionada $tipoPizza \n$extraseleccionado $extras",
                fontSize = 15.sp,
                textAlign = TextAlign.Left
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        //ELEGIR TAMAÑO DE PIZZA
        Text(
            "$eligetamanyotexto",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left
        )

        Column(Modifier.selectableGroup()) {
            opcionesTamanyo.forEach { opcion ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .selectable(
                            selected = (tamanyo == opcion),
                            onClick = { tamanyo = opcion }
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (tamanyo == opcion),
                        onClick = { tamanyo = opcion }
                    )
                    Text(
                        opcion,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
            //mensaje que muestra lo elegido
            Row(
                modifier = Modifier
                    .background(Color(0xFFEDE7F6))
                    .padding(15.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "$tamanyoseleccionado $tamanyo",
                    fontSize = 23.sp,
                    textAlign = TextAlign.Left
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            //ELEGIR BEBIDA

            Text(
                "$eligebotellatexto ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left
            )
            Column(Modifier.selectableGroup()) {
                opcionesBebidas.forEach { opcion ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (bebida == opcion),
                                onClick = { bebida = opcion }
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (bebida == opcion),
                            onClick = { bebida = opcion }
                        )
                        Text(
                            opcion,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
            //CANTIDAD DE PIZZAS
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFEDE7F6))
            ) {
                Text(
                    "$cantidadp $cantidadPizzas",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(), // ocupar ancho para centrar
                verticalAlignment = Alignment.CenterVertically, // alinea botones e imagen verticalmente
                horizontalArrangement = Arrangement.Center // centrar el ROW entero
            ) {
                Button( //Boton para menos
                    onClick = {
                        if (cantidadPizzas > 0) {
                            cantidadPizzas--
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text("-", fontSize = 40.sp)
                }

                Spacer(modifier = Modifier.width(16.dp))  //separar boton de img

                if (tipoPizza == "$margarita") {
                    Image(
                        painterResource(R.drawable.margarita),
                        contentDescription = "Pizza Margarita",
                        modifier = Modifier.size(130.dp)
                    )
                } else if (tipoPizza == "$barbacoa") {
                    Image(
                        painterResource(R.drawable.barbacoa),
                        contentDescription = "Pizza Barbacoa",
                        modifier = Modifier.size(130.dp)
                    )
                } else if (tipoPizza == "$romana") {
                    Image(
                        painterResource(R.drawable.romana),
                        contentDescription = "Pizza Romana",
                        modifier = Modifier.size(130.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp)) //separar boton de img

                Button( //Boton para más
                    onClick = { cantidadPizzas++ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                ) {
                    Text("+", fontSize = 40.sp)
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

            //CANTIDAD DE BOTELLAS (prac. copia y pega de las pizzas)

            Spacer(modifier = Modifier.height(16.dp))

            //Pongo el texto arriba para que no se pueda confundir por las pizzas al inicio
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFEDE7F6))
            ) {
                Text(
                    "$cantidadb $cantidadBotellas",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            } //texto de cantidad de botellas

            Row(
                modifier = Modifier.fillMaxWidth(), // ocupar ancho para centrar
                verticalAlignment = Alignment.CenterVertically, // alinea botones e imagen verticalmente
                horizontalArrangement = Arrangement.Center // centrar el ROW entero
            ) {
                Button( //Boton para menos
                    onClick = {
                        if (cantidadBotellas > 0) {
                            cantidadBotellas--
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text("-", fontSize = 40.sp)
                }

                Spacer(modifier = Modifier.width(16.dp))  //separar boton de img

                if (bebida == agua) {
                    Image(
                        painterResource(R.drawable.agua),
                        contentDescription = "Agua",
                        modifier = Modifier.size(130.dp)
                    )
                } else if (bebida == "Cola") {
                    Image(
                        painterResource(R.drawable.cola),
                        contentDescription = "Cola",
                        modifier = Modifier.size(130.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp)) //separar boton de img

                Button( //Boton para más
                    onClick = { cantidadBotellas++ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                ) {
                    Text("+", fontSize = 40.sp)
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

            //Botones de aceptar o volver

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically //  centrarlo todo
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)) //color verde!
                ) {
                    Text(botonaceptar, color = Color.White, fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)) //color rojo!
                ) {
                    Text(botonvolver, color = Color.White, fontSize = 18.sp)
                }
            }


            //SUMAR PRECIOS
            val precioTamanyo = when (tamanyo) { //poner precios de tamaño
                stringResource(R.string.pequeña) -> 4.95
               stringResource(R.string.mediana) -> 6.95
                stringResource(R.string.grande) -> 10.95
                else -> 0.0
            }

            val precioBebida = when (bebida) { //poner precios de bebida
                stringResource(R.string.agua) -> 2.0
                "Cola" -> 2.5 //no hace falta
                "Sin bebida" -> 0.0 //no tiene valor asi que no hace falta ponerlo en stringResource
                else -> 0.0
            }

            val precioBebidaTotal =
                precioBebida * cantidadBotellas //calcular precio de todas las botellas de antemano

            //usar el val de tamaño para multiplicarlo x la cantidad de pizzas puesta
            val precioTotal = (precioTamanyo * cantidadPizzas + precioBebidaTotal)

            precio = precioTotal + precioBebida

            //ROW PARA PONER EL PRECIO TOTAL
            Row(
                modifier = Modifier
                    .background(Color(0xFFB19CD9))
                    .fillMaxWidth()
                    .padding(30.dp)
            ) {
                Text(
                    "$textoprecio $precio€",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}*/
