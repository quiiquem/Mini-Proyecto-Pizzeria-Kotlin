package com.example.practica_kotlin_ev1.Objeto_Pago

import androidx.compose.ui.Modifier
import java.util.Date

data class Data_Pago(

    val num_tarjeta: String = "",
    val fecha: String = "",
    val tipo_tarjeta: String = "",
    val CVC: String = "",
    val modifier: Modifier = Modifier
)
