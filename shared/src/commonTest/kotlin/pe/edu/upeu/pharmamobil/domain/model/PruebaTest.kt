package pe.edu.upeu.pharmamobil.domain.model

import kotlinx.coroutines.runBlocking
import pe.edu.upeu.pharmamobil.domain.demo.cargarProductos
import pe.edu.upeu.pharmamobil.domain.demo.observarEstados
import pe.edu.upeu.pharmamobil.domain.demo.observarProductos
import pe.edu.upeu.pharmamobil.domain.demo.procesarResultado
import kotlin.test.Test

class PruebaTest {
    @Test
    fun testCargarProductos() = runBlocking {
        println("=== INICIO DE PRUEBA ===")

        println("\n--- Probando cargarProductos() ---")
        cargarProductos().collect { resultado ->
            procesarResultado(resultado)
        }

        println("\n--- Probando observarProductos() ---")
        observarProductos().collect { lista ->
            println("📦 Lista recibida: ${lista.size} productos")
            lista.forEach { println("  - ${it.nombre} (stock: ${it.stock})") }
        }

        println("\n--- Probando observarEstados() ---")
        observarEstados().collect { estado ->
            println("📡 $estado")
        }

        println("\n=== FIN DE PRUEBA ===")
    }
}