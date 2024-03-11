package org.practicatrim2

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
         * Funcion que crea un objeto tipo coche. Se inicializa como nulo y se pide los valores en bucle hasta que se introducen correctamente y se crea el coche.
         * @param enVenta Indica si el coche está en venta (por defecto es false). Usado para pedi o no el precio
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
                    println("Error al crear el coche: ${e.message}. Prueba de nuevo.")
                }
            }while (coche == null)
            return coche
        }
    }

    //TODO CREAR EL TOSTRING O OTRA FUNCION QUE HAGA LO MISMO PERO CON OTRO FORMATO PARA AGREGAR UN GENERADOR DE INFORME O ALGO PARECIDO

}