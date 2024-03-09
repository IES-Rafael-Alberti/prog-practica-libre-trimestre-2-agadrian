package org.practicatrim2

data class Pieza(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val cantidadStock: Int,
    val precio: Double,
    val vehiculoApto: TipoVehiculo
    )



