package ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ui.theme.Practica_Kotlin_EV1

enum class Pantallas {
    Inicio,
    Form_Pedido,
    Resumen_Pedido,
    Form_Pago,
    Resumen_Pago,
    Lista_Pedidos
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Practica_Kotlin_EV1 {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                 //Pantalla_Principal(modifier = Modifier.padding(innerPadding)) //Pantalla principal
               Pantalla_RealizarPedido() //SEGUNDA PANTALLA (ELEGIR PIZZA)
                 //  ResumirPedido() //TERCERA PANTALLA (RESUMEN DEL PEDIDO)
                  //  Formulario_Pago() //CUARTA PANTALLA (HACER PAGO)
                  //  ResumirPago() //QUINTA PANTALLA (MOSTRAR PAGO)
                 //  ListaPedidos() //ULTIMA PANTALLA (LISTA PAGOS)
                }
            }
        }
    }
}
/*
@Composable
fun Navegacion(modifier: Modifier = Modifier,
              navController: NavHostController = rememberNavController()) {

    NavHost( //con navhost me defino rutas y navegacion entre pantallas
        navController = navController,
        startDestination = Pantallas.Inicio.name,
        modifier = modifier
    ) {

        //Rutas
        composable(route = Pantallas.Inicio.name){
            Pantalla_Principal(
                onBotonSiguientePulsado = {navController.navigate(Pantallas.Form_Pedido)},
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        composable(route = Pantallas.Form_Pedido.name){
            Pantalla_RealizarPedido(
                onBotonSiguientePulsado = {}
            )
        }

    }
}*/