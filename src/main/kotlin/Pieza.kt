package org.practicatrim2

/**
 * Representa una pieza de repuesto en el inventario del taller.
 *
 * @property id El identificador único de la pieza.
 * @property nombre El nombre de la pieza.
 * @property descripcion La descripción de la pieza.
 * @property cantidadStock La cantidad de esta pieza en stock.
 * @property precio El precio de la pieza.
 * @property vehiculoApto El tipo de vehículo para el que es apta la pieza.
 */
data class Pieza(
    val id: Int,
    val nombre: String,
    var descripcion: String,
    var cantidadStock: Int,
    val precio: Double,
    val vehiculoApto: TipoVehiculo
    ){


    /**
     * Convierte la pieza a una cadena de caracteres con un formato específico.
     */
    override fun toString(): String {
        return String.format("%10s %30s %45s %15s %15s %15s",
            id,
            nombre.capitalizar(),
            descripcion,
            cantidadStock,
            precio,
            vehiculoApto.toString().capitalizar()
        )
    }
}



