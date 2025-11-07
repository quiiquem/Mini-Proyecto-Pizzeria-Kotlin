package ui

import AppViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ui.theme.Navegacion

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
            Navegacion()
        }
    }


    @Composable
    fun Navegacion(
        navController: NavHostController = rememberNavController()
    ) {
        val viewModel: AppViewModel = viewModel()

        NavHost(
            navController = navController,
            startDestination = Pantallas.Inicio.name
        ) {
            composable(Pantallas.Inicio.name) {
                Pantalla_Principal(
                    viewModel = viewModel,
                    onBotonSiguientePulsado = {
                        navController.navigate(Pantallas.Form_Pedido.name)
                    }
                )
            }

    composable(Pantallas.Form_Pedido.name) {
                Pantalla_RealizarPedido(
                    onBotonAtrasPulsado = {
                        navController.navigate(Pantallas.Inicio.name)
                    },
                    onBotonSiguientePulsado = {
                        navController.navigate(Pantallas.Resumen_Pedido.name)
                    },
                    viewModel = viewModel //hay que pasarle el viewmodel en nav. o dara error
                )
            }

            composable(Pantallas.Resumen_Pedido.name) {
                ResumirPedido(
                    onBotonAtrasPulsado = {
                        navController.navigate(Pantallas.Form_Pedido.name)
                    },
                    onBotonSiguientePulsado = {
                        navController.navigate(Pantallas.Form_Pago.name)
                    }
                        , viewModel = viewModel)
            }

            composable(Pantallas.Form_Pago.name) {
                Formulario_Pago(
                    onBotonAtrasPulsado = {
                        navController.navigate(Pantallas.Resumen_Pedido.name)
                    },
                    onBotonSiguientePulsado = {
                        navController.navigate(Pantallas.Resumen_Pago.name)
                    }
                )
            }

            composable(Pantallas.Resumen_Pago.name) {
                ResumirPago(
                    onBotonAtrasPulsado = {
                        navController.navigate(Pantallas.Form_Pago.name)
                    },
                    onBotonSiguientePulsado = {
                        navController.navigate(Pantallas.Lista_Pedidos.name)
                    }, viewModel = viewModel
                        )
            }

            composable(Pantallas.Lista_Pedidos.name) {
                ListaPedidos( onBotonAtrasPulsado = {
                    navController.navigate(Pantallas.Inicio.name)
                })}
            }
        }
    }
