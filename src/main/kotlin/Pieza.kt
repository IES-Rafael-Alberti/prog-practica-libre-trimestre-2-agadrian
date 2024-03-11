package org.practicatrim2

data class Pieza(
    val id: Int,
    val nombre: String,
    var descripcion: String,
    var cantidadStock: Int,
    val precio: Double,
    val vehiculoApto: TipoVehiculo
    )



