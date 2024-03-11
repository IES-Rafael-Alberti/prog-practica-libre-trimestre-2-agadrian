package org.practicatrim2

class Motocicleta(
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
    private var cilindrada: Int


) : Vehiculo(id, tipoVeh, marca, modelo, anio, kilometros, caballos, estado, precio, seVende){


    init {
        comprobarCilindrada(cilindrada)
    }

    private fun comprobarCilindrada(cilindrada: Int){
        require(Cilindrada.entries.any {it.valor == cilindrada}) {"La cilidrada debe ser (${Cilindrada.entries.joinToString { "${it.valor}" }})"}
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
         * @param enVenta Indica si el coche está en venta (por defecto es false). Usado para pedi o no el precio
         * @return Objeto Motocicleta creado a partir de los datos proporcionados por el usuario.
         */
        fun crearMoto(enVenta: Boolean = false) : Motocicleta {
            var moto: Motocicleta? = null
            crearIdUnica()
            do {
                try {
                     moto = Motocicleta(
                        idVehUnica,
                         TipoVehiculo.Moto,
                        GestionConsola.solicitarDato("Marca -> ", {it}),
                        GestionConsola.solicitarDato("Modelo -> ", {it}),
                        GestionConsola.solicitarDato("Año (1970 - 2024) -> ", {it.toInt()}),
                        GestionConsola.solicitarDato("Kms (0 - 1.000.000) -> ", {it.toInt()}),
                        GestionConsola.solicitarDato("Caballos (30 - 220) -> ", {it.toInt()}),
                         GestionConsola.solicitarDato("Introduce estado de la moto (Nuevo, Roto, Reparado) -> ", {it}),
                        if (enVenta) GestionConsola.solicitarDato("Precio -> ", {it.toDouble()}) else null,
                        enVenta,
                        GestionConsola.solicitarDato("Cilindrada (${Cilindrada.entries.joinToString { "${it.valor}" }}) -> ", {it.toInt()})
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