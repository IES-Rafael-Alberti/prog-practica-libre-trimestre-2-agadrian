package org.practicatrim2

class Motocicleta(
    id: Int,
    tipoVeh: TipoVehiculo,
    marca: String,
    modelo: String,
    anio: Int,
    kilometros: Int,
    caballos: Int,
    precio: Double? = null,
    seVende: Boolean = false,
    private var cilindrada: Int

) : Vehiculo(id, tipoVeh, marca, modelo, anio, kilometros, caballos, precio, seVende){


    init {
        comprobarCilindrada(cilindrada)
    }

    private fun comprobarCilindrada(cilindrada: Int){
        require(Cilindrada.entries.any {it.valor == cilindrada}) {"La cilidrada debe ser (300, 600 o 1000)"}
    }

    override fun comprobarCvs(caballos: Int) {
        require(caballos in 30..220){"Los caballos deben estar en el rango (30 - 220)"}
    }


    fun editarCilindrada(nuevaCilindrada: Int){
        if (nuevaCilindrada != -1) {
            comprobarCilindrada(nuevaCilindrada)
            this.cilindrada = nuevaCilindrada
        }
    }


    companion object{
        /**
         * Funcion que crea un objeto tipo Motocicleta. Se inicializa como nulo y se pide los valores en bucle hasta que se introducen correctamente y se crea la moto.
         * @param gestionConsola Objeto GestionConsola utilizado para solicitar los datos al usuario.
         * @param enVenta Indica si el coche está en venta (por defecto es false). Usado para pedi o no el precio
         * @return Objeto Motocicleta creado a partir de los datos proporcionados por el usuario.
         */
        fun crearMoto(gestionConsola: GestionConsola, enVenta: Boolean = false) : Motocicleta {
            var moto: Motocicleta? = null
            crearIdUnica()
            do {
                try {
                     moto = Motocicleta(
                        idVehUnica,
                         TipoVehiculo.MOTO,
                        gestionConsola.solicitarDato("Marca -> ", {it}),
                        gestionConsola.solicitarDato("Modelo -> ", {it}),
                        gestionConsola.solicitarDato("Año (1970 - 2024) -> ", {it.toInt()}),
                        gestionConsola.solicitarDato("Kms (0 - 1.000.000) -> ", {it.toInt()}),
                        gestionConsola.solicitarDato("Caballos (30 - 220) -> ", {it.toInt()}),
                        if (enVenta) gestionConsola.solicitarDato("Precio -> ", {it.toDouble()}) else null,
                        enVenta,
                        gestionConsola.solicitarDato("Cilindrada (300, 600, 1000) -> ", {it.toInt()})
                    )
                } catch (e: Exception) {
                    println("Error al crear la moto: ${e.message}. Prueba de nuevo")
                }
            }while (moto == null)
            return moto
        }
    }




    override fun toString(): String {
        return super.toString() + " - Cilindrada: $cilindrada"
    }
}


enum class Cilindrada(val valor: Int){
    CC300(300),
    CC600(600),
    CC1000(1000)
}