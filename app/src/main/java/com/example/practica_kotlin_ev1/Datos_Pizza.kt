package com.example.practica_kotlin_ev1

import androidx.annotation.StringRes

data class Datos_Pizza(

    @StringRes val stringResourceTipo: Int,
    @StringRes val stringResourceExtra: Int, //por si el usuario decide ponerle algo más    @StringRes val stringResourceTamanyo: Int,

)
