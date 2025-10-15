package com.example.practica_kotlin_ev1

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes

data class Datos_Persona(
    @StringRes val stringResourceId: Int,
    @StringRes val stringResourceApellidos: Int,
    @StringRes val stringResourceGmail: Int,
    @StringRes val stringResourceNum: Int, //prob sera mejor buscar algo para que sea solo numeros
    @DrawableRes val imagenResourceId: Int
)
