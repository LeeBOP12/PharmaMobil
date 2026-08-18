package pe.edu.upeu.pharmamobil.domain.model

import kotlin.test.Test
import kotlin.test.assertEquals

class ClienteTest {
    @Test
    fun probarCliente() {
        val cliente = Cliente(
            id = 1L,
            nombre = "Farmacia Nueva",
            correo = "ventas@central.pe",
            telefono = "999888777"
        )
        val resultado = cliente.obtenerTelefono()

        assertEquals(
            expected = "999888777",
            actual = resultado
        )
    }
}
