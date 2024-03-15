package org.practicatrim2
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Representa una factura generada para una reparación de vehículo.
 *
 * @property id El identificador único de la factura.
 * @property vehiculo El vehículo asociado a la factura.
 * @property piezasUtilizadas Un mapa que contiene las piezas utilizadas en la reparación junto con su cantidad.
 * @property costoTotal El costo total de la reparación.
 * @property fechaHora La fecha y hora en que se generó la factura. Se establece automáticamente en el momento de la creación de la factura si no se especifica.
 */
data class Factura(
    val id: Int,
    val vehiculo: Vehiculo,
    val piezasUtilizadas: Map<Pieza, Int>,
    val costoTotal: Double,
    val fechaHora: LocalDateTime = LocalDateTime.now()
){
    companion object{
        private var id = 0

        /**
         * Genera un nuevo ID para la factura.
         */
        fun generarID(): Int{
            id++
            return id
        }
    }


    /**
     * Convierte la factura a una cadena de caracteres con un formato específico.
     */
    override fun toString(): String {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss")
        val fechaHoraFormated = fechaHora.format(formatter)
        val piezasUsadas = piezasUtilizadas.keys.joinToString(", ") {it.nombre}
        return String.format("%8s %8s %90s %15s %25s",
            id,
            vehiculo.id,
            piezasUsadas,
            "${costoTotal}€",
            fechaHoraFormated
        )
    }
}
