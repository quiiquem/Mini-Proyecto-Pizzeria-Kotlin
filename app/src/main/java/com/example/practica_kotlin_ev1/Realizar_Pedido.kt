package com.example.practica_kotlin_ev1

import android.R.attr.contentDescription
import android.R.attr.fontWeight
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HacerPedido() {
    var tipoPizza by remember { mutableStateOf("") } //tipo de pizza que es var porq puede cambiar
    var extras by remember { mutableStateOf("Ninguno") } //puede cambiar asi que se deja en var
    var tamanyo by remember { mutableStateOf("No seleccionado") }
    var bebida by remember { mutableStateOf("No seleccionado") }
    var cantidadPizzas by remember { mutableStateOf(0) }
    var cantidadBotellas by remember { mutableStateOf(0) }
    var precio by remember { mutableStateOf(0.0) }

    //todas las listas con las opciones de el formulario
    val opcionesPizza = listOf("Margarita", "Barbacoa", "Romana")
    val opcionesMargarita = listOf("Con Piña", "Versión Vegana", "Ningún Extra")
    val opcionesBarbacoa = listOf("Carne de cerdo", "Pollo", "Ternera", "Ningún Extra")
    val opcionesRomana = listOf("Con champiñones", "Ningún Extra")
    val opcionesTamanyo = listOf("Pequeña", "Mediana", "Grande")
    val opcionesBebidas = listOf("Agua", "Cola", "Sin bebida")
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
            "¿Qué pizza va a elegir?",
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
                                    "Ninguno" //basicamente para evitar que la gente ponga extras erroneos
                            }
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (tipoPizza == opcion),
                        onClick = {
                            tipoPizza = opcion
                            extras = "Ninguno"
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
        if (tipoPizza == "Margarita") {
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
        } else if (tipoPizza == "Barbacoa") { //2. BARBACOA
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
        } else if (tipoPizza == "Romana") { //3. ROMANA
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
                "Pizza seleccionada: $tipoPizza \nExtras seleccionados: $extras",
                fontSize = 15.sp,
                textAlign = TextAlign.Left
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        //ELEGIR TAMAÑO DE PIZZA
        Text(
            "Eliga un tamaño para la pizza: ",
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
                    "Tamaño seleccionada: $tamanyo",
                    fontSize = 23.sp,
                    textAlign = TextAlign.Left
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            //ELEGIR BEBIDA

            Text(
                "Eliga su bebida: ",
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
                    "Cantidad de pizzas: $cantidadPizzas",
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

                if (tipoPizza == "Margarita") {
                    Image(
                        painterResource(R.drawable.margarita),
                        contentDescription = "Pizza Margarita",
                        modifier = Modifier.size(130.dp)
                    )
                } else if (tipoPizza == "Barbacoa") {
                    Image(
                        painterResource(R.drawable.barbacoa),
                        contentDescription = "Pizza Barbacoa",
                        modifier = Modifier.size(130.dp)
                    )
                } else if (tipoPizza == "Romana") {
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
                    "Cantidad de botellas: $cantidadBotellas",
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

                if (bebida == "Agua") {
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
                    Text("Aceptar", color = Color.White, fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)) //color rojo!
                ) {
                    Text("Volver", color = Color.White, fontSize = 18.sp)
                }
            }


            //SUMAR PRECIOS
            val precioTamanyo = when (tamanyo) { //poner precios de tamaño
                "Pequeña" -> 4.95
                "Mediana" -> 6.95
                "Grande" -> 10.95
                else -> 0.0
            }

            val precioBebida = when (bebida) { //poner precios de bebida
                "Agua" -> 2.0
                "Cola" -> 2.5
                "Sin bebida" -> 0.0
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
                    "PRECIO TOTAL: $precio€",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}
