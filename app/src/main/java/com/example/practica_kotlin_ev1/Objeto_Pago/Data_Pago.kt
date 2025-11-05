package com.example.practica_kotlin_ev1.Objeto_Pago

import java.util.Date

data class Data_Pago(

    val num_tarjeta: Int = 0,
    val fecha: Date = Date(), //Date() que pone la fecha de hoy
    val tipo_tarjeta: String = "",
    val CVC: Int = 0
)
