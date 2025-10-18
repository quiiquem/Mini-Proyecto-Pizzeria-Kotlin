package com.example.practica_kotlin_ev1

import android.R.attr.contentDescription
import android.R.attr.fontWeight
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HacerPedido() {

    val ninguno = stringResource(R.string.ninguno) //para los extras
    val noseleccionado = stringResource(R.string.noseleccionado)
    val textoprecio = stringResource(R.string.preciofinal)

    //VALORES PRINCIPALES
    var tipoPizza by remember { mutableStateOf("") } //tipo de pizza que es var porq puede cambiar
    var extras by remember { mutableStateOf("$ninguno") } //puede cambiar asi que se deja en var
    var tamanyo by remember { mutableStateOf("$noseleccionado") }
    var bebida by remember { mutableStateOf("$noseleccionado") }
    var cantidadPizzas by remember { mutableStateOf(0) }
    var cantidadBotellas by remember { mutableStateOf(0) }
    var precio by remember { mutableStateOf(0.0) }

    //TIPOS DE PIZZA
    val margarita = stringResource(R.string.tipo) //se llama tipo para no crear otra que sea "margarita"
    val barbacoa = stringResource(R.string.pizza_barbacoa)
    val romana = stringResource(R.string.pizza_romana)


    val ningunextra = stringResource(R.string.ningunextra)
    //OPCIONES MARGARITA
    val pinya = stringResource(R.string.extramargaritapiña)
    val vegana = stringResource(R.string.extramargaritavegana)

    //OPCIONES BARBACOA
    val carnecerdo = stringResource(R.string.extrabarbacoacarne)
    val pollo = stringResource(R.string.extrabarbacoapollo)
    val ternera = stringResource(R.string.extrabarbacoaternera)

    //OPCIONES ROMANA
    val champinyon = stringResource(R.string.extraromanachampiñon)

    //TIPOS DE BOTELLA
    val agua = stringResource(R.string.agua)
    //cola no necesita porq es igual en ingles
    val nobebida = stringResource(R.string.SinBebida)

    //OTROS (textos)
    val eligepizzatexto = stringResource(R.string.eligepizzatexto)
    val eligetamanyotexto = stringResource(R.string.eligetamanyotexto)
    val tamanyoseleccionado = stringResource(R.string.tamanyoseleccionado)
    val  eligebotellatexto =  stringResource(R.string.botellaseleccionada)
    val pizzaseleccionada = stringResource(R.string.pizzaeleccionadatexto)
    val extraseleccionado = stringResource(R.string.extraseleccionado)

    //TAMAÑOS
    val pequeño = stringResource(R.string.pequeña)
    val mediana = stringResource(R.string.mediana)
    val grande = stringResource(R.string.grande)

    //CANTIDADES
    val cantidadp = stringResource(R.string.cantidadpizzatexto)
    val cantidadb = stringResource(R.string.cantidadbotellastexto)

    //BOTONES (loclizacion)
    val botonaceptar = stringResource(R.string.botonaceptar)
    val botonvolver = stringResource(R.string.botonvolver)

    //todas las listas con las opciones de el formulario
    val opcionesPizza = listOf("$margarita", "$barbacoa", "$romana")
    val opcionesMargarita = listOf("$pinya", "$vegana", "$ningunextra")
    val opcionesBarbacoa = listOf("$carnecerdo", "$pollo", "$ternera", "$ningunextra")
    val opcionesRomana = listOf("$champinyon", "$ningunextra")
    val opcionesTamanyo = listOf("$pequeño", "$mediana", "$grande")
    val opcionesBebidas = listOf("$agua", "Cola", "$nobebida")
    val scrollState = rememberScrollState() //permite scrollear a traves de una columna

    // toda la interfaz va dentro de un único Column para mantener la estructura visual correcta
    Column(
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

                if (bebida == "$agua") {
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
                    Text("${botonaceptar}", color = Color.White, fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)) //color rojo!
                ) {
                    Text("$botonvolver", color = Color.White, fontSize = 18.sp)
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
}
