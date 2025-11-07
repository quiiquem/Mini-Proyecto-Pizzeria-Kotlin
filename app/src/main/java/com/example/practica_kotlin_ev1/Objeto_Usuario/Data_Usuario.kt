package com.example.practica_kotlin_ev1.Objeto_Usuario

import androidx.compose.ui.Modifier

data class Data_Usuario(
    val nombre: String = "",
    val apellidos: String = "",
    val correo: String = "",
    val tel : Int = 0,
    val modifier: Modifier = Modifier
)
