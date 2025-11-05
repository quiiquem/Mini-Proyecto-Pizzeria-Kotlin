package ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.practica_kotlin_ev1.Objeto_Pago.Data_Pago
import com.example.practica_kotlin_ev1.Objeto_Pizza.Data_Pedido
import com.example.practica_kotlin_ev1.Objeto_Usuario.Data_Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppViewModel : ViewModel(){

    //USUARIO VIEWMODEL
    private val _DatosUsuario = MutableStateFlow(Data_Usuario())
    val datosusuario_VM: StateFlow<Data_Usuario> = _DatosUsuario.asStateFlow()
    var nom_usuario by mutableStateOf("")
    var correo by mutableStateOf("")
    var telefono by mutableStateOf(0)

    //PEDIDO VIEWMODEL
    private val _DatosPedido = MutableStateFlow(Data_Pedido())

    val datospedido_VM: StateFlow<Data_Pedido> = _DatosPedido.asStateFlow()
    var tipo_pizza by mutableStateOf("")
    var tipo_bebida by mutableStateOf("")
    var tamanyo_pizza by mutableStateOf("")
    var precio_final by mutableStateOf(0.0)

    //PAGO VIEWMODEL
    private val _DatosPago = MutableStateFlow(Data_Pago())

    val datospago_VM: StateFlow<Data_Pago> = _DatosPago.asStateFlow()
    var num_tarjeta by mutableStateOf(0)
    var tipo_tarjeta by mutableStateOf("")
    var CVC by mutableStateOf(0)

}