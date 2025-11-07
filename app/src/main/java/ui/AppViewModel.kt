import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.practica_kotlin_ev1.Objeto_Pago.Data_Pago
import com.example.practica_kotlin_ev1.Objeto_Usuario.Data_Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import java.util.Date


class AppViewModel : ViewModel() {

    //USUARIO -- datos ya predefinidios
    private val priv_DataUsuario = MutableStateFlow(
        Data_Usuario(
            nombre = "Juan",
            apellidos = "Perez García",
            correo = "CorreodeJuan@gmail.com",
            tel = 604293920
        )
    )
    val public_DataUsuario: StateFlow<Data_Usuario> =
        priv_DataUsuario.asStateFlow() //para poder mostrrlo en la UI


    // --- PEDIDO ---
    private val priv_DataPedido = MutableStateFlow(
        Data_Pedido(
            tipo_pizza = "",
            tamanyo_pizza = "",
            tipo_bebida = "",
            cantidad_pizzas = 1,
            cantidad_bebidas = 0,
            precio_total = 0.0
        )
    )
    val public_DataPedido: StateFlow<Data_Pedido> = priv_DataPedido.asStateFlow()

    fun actualizarPedido(nuevoPedido: Data_Pedido) {
        priv_DataPedido.value = nuevoPedido
    }


    var tipoPizza by mutableStateOf("")
        private set

    var extra1 by mutableStateOf("")
        private set

    var extra2 by mutableStateOf("")
        private set

    var tamanyoPizza by mutableStateOf("")
        private set

    var precioTamanyo by mutableStateOf(0.0)
        private set

    var tipoBebida by mutableStateOf("")
        private set

    var precioBebida by mutableStateOf(0.0)
    private set

    var cantidad_Pizzas by mutableStateOf(1)
        private set

    var cantidad_Bebidas by mutableStateOf(0)
        private set

    var precioGlobal by mutableStateOf(0.0)
        private set

    fun actualizarTipo(tipo: String) { //funcion para actualizar el tipo
        tipoPizza = tipo

        priv_DataPedido.update { tipoActual -> //update para que se pueda cambiar los datos
            tipoActual.copy(
                tipo_pizza = tipoPizza //copiar y pasarlo al valor del objeto
            )
        }
    }

    fun actualizarExtra1(extra_1: String) {
        extra1 = extra_1

        priv_DataPedido.update { extra1Actual ->
            extra1Actual.copy(
                extra1 = extra_1
            )
        }
    }

    fun actualizarExtra2(extra_2: String) {
        extra2 = extra_2

        priv_DataPedido.update { extra2Actual ->
            extra2Actual.copy(
                extra2 = extra_2
            )
        }
    }

    fun actualizarTamanyo(tamanyo: String) {
        tamanyoPizza = tamanyo

        priv_DataPedido.update { tamanyoActual ->
            tamanyoActual.copy(
                tamanyo_pizza = tamanyoPizza
            )
        }
    }

    fun actualizarPreciotamanyo(valprecio: Double) {
        precioTamanyo = valprecio

        priv_DataPedido.update { precioTactual ->
            precioTactual.copy(
                precio_tamanyo = precioTamanyo
            )
        }
    }


    fun actualizarBebida(bebida: String) {
        tipoBebida = bebida

        priv_DataPedido.update { bebidaActual ->
            bebidaActual.copy(
                tipo_bebida = tipoBebida
            )
        }
    }

    fun actualizarPrecioBebida(valprecio: Double) {
        precioBebida = valprecio

        priv_DataPedido.update { precioBactual ->
            precioBactual.copy(
                precio_bebida = precioBebida
            )
        }
    }

    fun actualizarCantidadPizzas(cantidadpizza: Int) {
        cantidad_Pizzas = cantidadpizza

        priv_DataPedido.update { cantidadPizzaActual ->
            cantidadPizzaActual.copy(
                cantidad_pizzas = cantidad_Pizzas
            )
        }
    }

    fun actualizarCantidadBebidas(cantidadbebida: Int) {
        cantidad_Bebidas = cantidadbebida

        priv_DataPedido.update { cantidadPizzaActual ->
            cantidadPizzaActual.copy(
                cantidad_bebidas = cantidad_Bebidas
            )
        }
    }

    fun actualizarPrecioGlobal(precioglobal: Double) {
        precioGlobal = precioglobal

        priv_DataPedido.update { precioGlobalActual ->
            precioGlobalActual.copy(
                precio_total = precioGlobal
            )
        }
    }

    //PAGO
    private val priv_DataPago = MutableStateFlow(Data_Pago())

    val public_DataPago: StateFlow<Data_Pago> = priv_DataPago.asStateFlow()

    var tipoTarjeta by mutableStateOf("")
        private set

    var numTarjeta by mutableStateOf(0)
        private set

    var fecha by mutableStateOf(Date()) //Poder poner fecha
        private set

    var CVC by mutableStateOf(0)
        private set

    fun actualizarTipoTarjeta(tipoactual: String) {
        tipoTarjeta = tipoactual

        priv_DataPago.update { tipoTarjetaActual ->
            tipoTarjetaActual.copy(
                tipo_tarjeta = tipoTarjeta
            )
        }
    }

    fun actualizarNumTarjeta(numActual: Int) {
        numTarjeta = numActual

        priv_DataPago.update { numTarjetaActual ->
            numTarjetaActual.copy(
                num_tarjeta = numTarjeta
            )
        }
    }

    fun actualizarCVC(CVCActual: Int) {
        CVC = CVCActual

        priv_DataPago.update { CVCNuevo ->
            CVCNuevo.copy(
                CVC = CVC
            )
        }
    }


    fun actualizarFecha(FechaActual: Date) {
        fecha = FechaActual

        priv_DataPago.update { FechaNueva ->
            FechaNueva.copy(
                fecha = fecha
            )
        }
    }
}