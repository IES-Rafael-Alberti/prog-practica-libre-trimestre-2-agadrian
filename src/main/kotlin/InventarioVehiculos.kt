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
    fun editarVehiculo(id: Int) {
        // todo comprobar que exista etc y pedir en bucle
        val vehiculo = vehiculos.find { it.id == id }

        //todo quitar el ? despues acabar la comprobacion de nulo arriba
        vehiculo?.apply {
            editarMarca(entradaDatos.pedirMarca(true))
            editarModelo(entradaDatos.pedirModelo(true))
            editarAnio(entradaDatos.pedirAnio(true))
            editarKilometros(entradaDatos.pedirKilometros(true))
            editarCaballos(entradaDatos.pedirCaballos(true))
            editarPrecio(entradaDatos.pedirPrecio(true))

            if (this is Motocicleta) {
                editarCilindrada(entradaDatos.pedirCilindrada())
            }
        }
        // TODO: Comprobar si se ha modificado o dejado igual, y variar el mensaje acorde a ello
        println("Vehiculo con ID: ${vehiculo?.id} modificado correctamente.")

        /*//Para editarlo si fuese necesario que se pudises elejir que editar de forma individual:
        * vehiculo?.apply {
        if (marca) editarMarca(entradaDatos.pedirMarca(true))
        if (modelo) editarModelo(entradaDatos.pedirModelo(true))
        if (anio) editarAnio(entradaDatos.pedirAnio(true))
        if (kilometros) editarKilometros(entradaDatos.pedirKilometros(true))
        if (caballos) editarCaballos(entradaDatos.pedirCaballos(true))
        if (precio) editarPrecio(entradaDatos.pedirPrecio(true))

        if (this is Motocicleta) {
            editarCilindrada(entradaDatos.pedirCilindrada())
        }
        */

    }





}