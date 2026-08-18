package pe.edu.upeu.pharmamobil.domain.model

sealed class EstadoPedido{
    data object Pendiente: EstadoPedido()
    data object Procesando: EstadoPedido()
    data object Ebtregado: EstadoPedido()
    data class Rechazado(
        val motivo: String
    ): EstadoPedido()
}
