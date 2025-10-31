package com.example.practica_kotlin_ev1

import android.R.attr.background
import android.R.id.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun Pantalla_Principal(modifier: Modifier = Modifier){
    Column(modifier
        .background(Color(0xFFFFEDE8))
        .fillMaxSize()){
        mensajebienvenida() //he empezado a dividrlo en partes más pequeñas como en los documentos por organización
        //cosa que no hice la primera vez.

    }
}

@Composable
fun mensajebienvenida(modifier : Modifier = Modifier) {
    //Variables val para el text
    val mensajebienvenida = stringResource(R.string.mensajemain)
    val nombreusuario = stringResource(R.string.nombre)

    Box(modifier) { //Voy a hacer que sea la parte de arriba del todo, pero que tenga un fondo rojo para destacar
        Text(
            "$mensajebienvenida , $nombreusuario",
            textAlign = TextAlign.Left,
            fontSize = 30.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth() //hacer que ocupe
        )
    }
}