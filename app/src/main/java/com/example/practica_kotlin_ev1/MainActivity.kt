package com.example.practica_kotlin_ev1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.practica_kotlin_ev1.ui.theme.Practica_Kotlin_EV1


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica_Kotlin_EV1 {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  Pantalla_Principal(modifier = Modifier.padding(innerPadding)) //MAIN ACTIVITY
                 //  HacerPedido() //SEGUNDA PANTALLA (ELEGIR PIZZA)
                 //  ResumirPedido() //TERCERA PANTALLA (RESUMEN DEL PEDIDO)
                  //  Formulario_Pago() //CUARTA PANTALLA (HACER PAGO)
                  //  ResumirPago() //QUINTA PANTALLA (MOSTRAR PAGO)
                 //  ListaPedidos() //ULTIMA PANTALLA (LISTA PAGOS)
                }
            }
        }
    }
}