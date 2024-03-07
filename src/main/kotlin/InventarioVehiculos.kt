package org.practicatrim2

class InventarioVehiculos(private val entradaDatos: EntradaDatos) {

    // Creamos una lista de vehiculos
    private val vehiculos: MutableList<Vehiculo> = mutableListOf()

    /**
     * Agregar un vehiculo al inventario de vehiculos
     */
    fun agregarVehiculo(vehiculo: Vehiculo){
        // TODO: Comprobar y hacer logica de si ya existe el vehiculo, etc con ID
        vehiculos.add(vehiculo)
    }


    /**
     * Elimina un vehiculo de la lista mediante su ID
     */
    fun eliminarVehiculo(id: Int){
        //TODO: AÑADIR LOGICA
        vehiculos.removeAll {it.id == id}
    }

    /**
     * Edita un vehiculo mediante su ID
     */
    fun editarVehiculo(id: Int, entradaDatos: EntradaDatos) {
        // todo comprobar que exista etc y pedir en bucle
        val vehiculo = vehiculos.find { it.id == id }

        //todo quitar el ? despues acabar la comprobacion de nulo arriba
        vehiculo?.apply {
            editarMarca(entradaDatos.pedirMarca(true))
            editarModelo(entradaDatos.pedirModelo())
            editarAnio(entradaDatos.pedirAnio())
            editarCaballos(entradaDatos.pedirCaballos())
            editarPrecio(entradaDatos.pedirPrecio())

            if (this is Motocicleta) {
                editarCilindrada(entradaDatos.pedirCilindrada())
            }

        }
    }




}