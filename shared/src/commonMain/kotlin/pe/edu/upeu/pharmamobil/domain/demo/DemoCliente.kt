package pe.edu.upeu.pharmamobil.domain.demo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pe.edu.upeu.pharmamobil.domain.model.Cliente
import pe.edu.upeu.pharmamobil.domain.model.Producto
import pe.edu.upeu.pharmamobil.domain.result.ResultadoProductos


fun probarCliente (){
    val cliente = Cliente(
        id = 1L,
        nombre = "Farmacia Nueva",
        correo = "ventas@central.pe",
        telefono = null
    )
    println(cliente.telefono)
}

private val productosSimulados = listOf(
    Producto(1, "Paracetamol", 8.50, 100),
    Producto(2, "Ibuprofeno", 12.00, 50),
    Producto(3, "Amoxicilina", 18.50, 20)
)

suspend fun obtenerProductos(): List<Producto> {
    delay(1000) // Simula espera de red
    return productosSimulados
}

fun procesarResultado(resultado: ResultadoProductos) {
    when (resultado) {
        is ResultadoProductos.Cargando -> {
            println("⏳ Cargando productos...")
        }
        is ResultadoProductos.Exito -> {
            println("✅ Productos obtenidos: ${resultado.list.size}")
            resultado.list.forEach { println("  - ${it.nombre} (S/.${it.precio})") }
        }
        is ResultadoProductos.Error -> {
            println("❌ Error: ${resultado.msg}")
        }
    }
}

//PASO DEL 9 AL 11
fun observarEstados(): Flow<String> = flow {
    emit("Iniciando")
    delay(1000)
    emit("Finalizado")
}


suspend fun probarFlow() {
    observarEstados().collect { estado ->
        println("📡 Estado: $estado")
    }
}

// PASO DEL 12 AL 14
fun observarProductos(): Flow<List<Producto>> = flow {
    emit(emptyList())           // Lista vacía primero
    delay(1000)                 // Simula espera
    emit(productosSimulados)    // Luego los productos
}

// PASO DEL 15 AL 17
fun cargarProductos(): Flow<ResultadoProductos> = flow {
    emit(ResultadoProductos.Cargando)          // Paso 15: estado Cargando
    delay(1000)                                // Simula operación asíncrona
    emit(ResultadoProductos.Exito(productosSimulados))  // Paso 16: estado Éxito con datos
}

