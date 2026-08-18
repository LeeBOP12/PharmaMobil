package pe.edu.upeu.pharmamobil.domain.demo

import pe.edu.upeu.pharmamobil.domain.model.Cliente


fun probarCliente (){
    val cliente = Cliente(
        id = 1L,
        nombre = "Farmacia Nueva",
        correo = "ventas@central.pe",
        telefono = null
    )
    println(cliente.telefono)
}