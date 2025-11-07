import androidx.compose.ui.Modifier

data class Data_Pedido(
    val tipo_pizza: String = "",
    val extra1: String = "",
    val extra2: String = "",
    val tamanyo_pizza: String = "",
    val precio_tamanyo: Double = 0.0,
    val tipo_bebida: String = "",
    val precio_bebida: Double = 0.0,
    val cantidad_pizzas: Int = 0,
    val cantidad_bebidas: Int = 0,
    val precio_total: Double = 0.0,
    val modifier: Modifier = Modifier
)
