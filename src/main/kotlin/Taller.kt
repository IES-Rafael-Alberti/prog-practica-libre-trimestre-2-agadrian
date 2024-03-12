package org.practicatrim2

/**
 * Objeto singleton que representa un taller de reparación de vehículos.
 * Contiene métodos para reparar vehículos de manera aleatoria.
 */
object Taller {
    private val inventarioVehiculos: GestorInventario<Vehiculo> = InventarioVehiculos()
    private val inventarioPiezas: InventarioPiezas = InventarioPiezas()


    /**
     * Repara un vehículo seleccionado aleatoriamente de los vehículos rotos en el inventario.
     * Selecciona piezas aleatorias del inventario de piezas para la reparación y actualiza el stock.
     */
    fun repararVehiculo(){
        val vehiculo = getVehiculoRotoAleatorio()
        if (vehiculo != null){
            GestionConsola.imprimirTexto("Reparando vehículo con ID ${vehiculo.id}...")

            val piezas = piezasAleatorias(vehiculo)

            // Muestra las piezas y cantidad necesaria, ala vez que se va restando la cantidad del stock del inventario
            GestionConsola.imprimirTexto("Piezas necesarias para la reparación:")

            piezas.forEach { (pieza, cantidad) ->
                GestionConsola.imprimirTexto("- ${pieza.nombre}: $cantidad unidades")
                if (pieza.cantidadStock < cantidad){
                    GestionConsola.imprimirTexto("No hay stock suficiente. Realizando pedido de el doble de cantidad necesaria...", false)
                    inventarioPiezas.realizarPedido(pieza.id, cantidad*2)
                }
                inventarioPiezas.disminuirStock(pieza.id, cantidad)
            }
            vehiculo.estado = "Reparado"
            GestionConsola.imprimirTexto("Reparación completada.")


        }else{
            GestionConsola.imprimirTexto("No hay vehiculos para reparar")
        }
    }


    /**
     * Obtiene un vehículo roto aleatorio del inventario de vehículos.
     * @return El vehículo roto aleatorio, o null si no hay vehículos rotos.
     */
    private fun getVehiculoRotoAleatorio(): Vehiculo?{
        val vehiculosRotos = inventarioVehiculos.listadoItems.values.filter { it.estado == "Roto" }
        return vehiculosRotos.randomOrNull()
    }


    /**
     * Selecciona piezas aleatorias necesarias para la reparación de un vehículo.
     * @param vehiculo El vehículo a reparar.
     * @return Un mapa que contiene las piezas necesarias como claves y la cantidad como valores.
     */
    private fun piezasAleatorias(vehiculo: Vehiculo): Map<Pieza, Int>{
        val piezasNecesarias = mutableMapOf<Pieza, Int>()
        val piezasDisponibles = inventarioPiezas.listadoItems.values.filter { it.vehiculoApto == vehiculo.tipoVehiculo }

        val randomNum = (1..5).random()
        for (i in 0..randomNum){
            val piezaAleatoria = piezasDisponibles.randomOrNull()
            if (piezaAleatoria != null) {
                val cantRandom = (1..3).random()
                piezasNecesarias[piezaAleatoria] = cantRandom
            }
        }
        return piezasNecesarias
    }



    fun mostrarVehiculosReparados() {
        inventarioVehiculos.listadoItems.values.filter { it.estado == "Reparado"  }.forEach{ println(it) }
    }


}