package org.practicatrim2

/**
 * Clase que representa un coche.
 * @param id ID del coche.
 * @param tipoVeh Tipo de vehículo.
 * @param marca Marca del coche.
 * @param modelo Modelo del coche.
 * @param anio Año de fabricación del coche.
 * @param kilometros Kilometraje del coche.
 * @param caballos Caballos del coche.
 * @param estado Estado del coche (Nuevo, Roto, Reparado).
 * @param precio Precio del coche (null si no está en venta).
 * @param seVende Indica si el coche está en venta.
 */
class Coche (
    id: Int,
    tipoVeh: TipoVehiculo,
    marca: String,
    modelo: String,
    anio: Int,
    kilometros: Int,
    caballos: Int,
    estado: String,
    precio: Double? = null,
    seVende: Boolean = false,

) : Vehiculo(id, tipoVeh,marca, modelo, anio, kilometros, caballos, estado, precio, seVende){

    companion object {
        /**
         * Genera un objeto Coche a partir de los datos proporcionados por el usuario.
         * @param enVenta Indica si el coche está en venta (por defecto es false). Usado para pedir o no el precio.
         * @return Objeto Coche creado a partir de los datos proporcionados por el usuario.
         */
        fun crearCoche(enVenta: Boolean = false) : Coche {
            var coche: Coche? = null
            crearIdUnica()

            do {
                try {
                    coche = Coche(
                        idVehUnica,
                        TipoVehiculo.Coche,
                        GestionConsola.solicitarDato("Marca -> ", { it }),
                        GestionConsola.solicitarDato("Modelo -> ", { it }),
                        GestionConsola.solicitarDato("Año (1970 - 2024) -> ", { it.toInt() }),
                        GestionConsola.solicitarDato("Kms (0 - 1.000.000) -> ", { it.toInt() }),
                        GestionConsola.solicitarDato("Caballos (30 - 600) -> ", { it.toInt() }),
                        GestionConsola.solicitarDato("Introduce estado del coche (Nuevo, Roto, Reparado) -> ", {it.capitalizar()}),
                        if (enVenta) GestionConsola.solicitarDato("Precio -> ", { it.toDouble() }) else null,
                        enVenta
                    )
                } catch (e: Exception) {
                    GestionConsola.imprimirTexto("Error al crear el coche: ${e.message}. Prueba de nuevo.")
                }
            }while (coche == null)
            return coche
        }
    }

}