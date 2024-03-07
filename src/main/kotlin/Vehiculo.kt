package org.practicatrim2

open class Vehiculo(
    id: Int,
    private var marca: String,
    private var modelo: String,
    private var anio: Int,
    private var kilometros: Int,
    private var caballos: Int,
    private var precio: Double
) {

    var id = id
        private set



    fun editarMarca(nuevaMarca: String) {
        if (nuevaMarca.isNotBlank()) marca = nuevaMarca
    }

    fun editarModelo(nuevoModelo: String) {
        if (nuevoModelo.isNotBlank()) modelo = nuevoModelo
    }

    fun editarAnio(nuevoAnio: Int) {
        if (nuevoAnio != -1) anio = nuevoAnio
    }

    fun editarKilometros(nuevoKilometros: Int) {
        if (nuevoKilometros != -1) kilometros = nuevoKilometros
    }

    fun editarCaballos(nuevosCaballos: Int) {
        if (nuevosCaballos != -1) caballos = nuevosCaballos
    }

    fun editarPrecio(nuevoPrecio: Double) {
        if (nuevoPrecio != -1.0) precio = nuevoPrecio
    }

    override fun toString(): String {
        return "ID: $id - Marca: $marca - Modelo: $modelo - Año: $anio - Kms: $kilometros - Cvs: $caballos - Precio: $precio"
    }
}