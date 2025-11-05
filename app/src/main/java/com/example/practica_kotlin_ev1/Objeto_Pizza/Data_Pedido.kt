package com.example.practica_kotlin_ev1.Objeto_Pizza

data class Data_Pedido(
    val tipo_pizza: String = "",
    val extra_1: String = "",
    val extra_2: String = "",
    val extra_3: String = "",
    val tipo_bebida: String = "",
    val tamanyo_pizza: String = "",
    val precio_botella: Double = 0.0,
    val cantidad_pizza: Int = 0,
    val cantidad_bebida: Int = 0,
    val precio_final: Double = 0.0
)
