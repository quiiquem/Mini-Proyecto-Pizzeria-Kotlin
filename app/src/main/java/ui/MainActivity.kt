package ui

import AppViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import com.example.practica_kotlin_ev1.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ui.theme.Navegacion

enum class Pantallas(@StringRes val titulo: Int) {
    Inicio(R.string.mainPan),
    Form_Pedido(R.string.pedidoPan),
    Resumen_Pedido(R.string.resumenpedidoPan),
    Form_Pago(R.string.pagoPan),
    Resumen_Pago(R.string.resumenPago),
    Lista_Pedidos(R.string.listaPedidos)
}




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Navegacion() }
    }
}

@Composable
fun Navegacion(navController: NavHostController = rememberNavController()) {
    val viewModel: AppViewModel = viewModel()
    val pila by navController.currentBackStackEntryAsState()
    val pantallaActual = Pantallas.valueOf(pila?.destination?.route ?: Pantallas.Inicio.name)

    Scaffold(
        topBar = {
            AppTopBar(
                pantallaActual = pantallaActual,
                puedeNavegarAtras = navController.previousBackStackEntry != null,
                onNavegarAtras = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Pantallas.Inicio.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Pantallas.Inicio.name) {
                Pantalla_Principal(
                    viewModel = viewModel,
                    onBotonSiguientePulsado = {
                        navController.navigate(Pantallas.Form_Pedido.name)
                    },
                    onBotonListaPulsado = {
                        navController.navigate(Pantallas.Lista_Pedidos.name)
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
                    }, viewModel = viewModel
                )
            }

            composable(Pantallas.Form_Pago.name) {
                Formulario_Pago(
                    onBotonAtrasPulsado = {
                        navController.navigate(Pantallas.Resumen_Pedido.name)
                    },
                    onBotonSiguientePulsado = {
                        navController.navigate(Pantallas.Resumen_Pago.name)
                    }, viewModel = viewModel
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
                ListaPedidos(
                    onBotonAtrasPulsado = {
                        navController.popBackStack(Pantallas.Inicio.name,inclusive = false) //arreglar pila
                    }, viewModel = viewModel
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    pantallaActual: Pantallas,
    puedeNavegarAtras: Boolean,
    onNavegarAtras: () -> Unit
) {
    TopAppBar(
        title = { Text(stringResource(id = pantallaActual.titulo)) },
        navigationIcon = {
            if (puedeNavegarAtras) {
                IconButton(onClick = onNavegarAtras) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            }
        }
    )
}
