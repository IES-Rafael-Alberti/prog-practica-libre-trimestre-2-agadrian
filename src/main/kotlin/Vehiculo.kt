package org.practicatrim2

open class Vehiculo(
    id: Int,
    marca: String,
    modelo: String,
    anio: Int,
    kilometros: Int,
    caballos: Int,
    precio: Double
) {

    var id = id
        private set

    var marca = marca
        private set

    var modelo = modelo
        private set

    var anio = anio
        private set

    var kilometros = kilometros
        private set

    var caballos = caballos
        private set

    var precio = precio
        private set

    //TODO: HACER LO MISMO QUE EN MARCA EN TODOS
    fun editarMarca(nuevaMarca: String) {
        if (nuevaMarca.isNotBlank()) {
            marca = nuevaMarca
        }
    }

    fun editarModelo(nuevoModelo: String) {
        modelo = nuevoModelo
    }

    fun editarAnio(nuevoAnio: Int) {
        anio = nuevoAnio
    }

    fun editarCaballos(nuevosCaballos: Int) {
        caballos = nuevosCaballos
    }

    fun editarPrecio(nuevoPrecio: Double) {
        precio = nuevoPrecio
    }
}