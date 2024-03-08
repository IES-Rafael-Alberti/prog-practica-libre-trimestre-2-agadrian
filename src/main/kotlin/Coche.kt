package org.practicatrim2

class Coche (
    id: Int,
    marca: String,
    modelo: String,
    anio: Int,
    kilometros: Int,
    caballos: Int,
    precio: Double? = null,
    seVende: Boolean = false
) : Vehiculo(id, marca, modelo, anio, kilometros, caballos, precio, seVende){



}