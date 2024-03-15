package org.practicatrim2

/**
 * Clase que representa una motocicleta.
 * Hereda de la clase Vehiculo e implementa las características específicas de una motocicleta.
 *
 * @property id El identificador único de la motocicleta.
 * @property tipoVeh El tipo de vehículo, en este caso, TipoVehiculo.Moto.
 * @property marca La marca de la motocicleta.
 * @property modelo El modelo de la motocicleta.
 * @property anio El año de fabricación de la motocicleta.
 * @property kilometros La cantidad de kilómetros recorridos por la motocicleta.
 * @property caballos La potencia en caballos de la motocicleta.
 * @property estado El estado actual de la motocicleta (Nuevo, Roto, Reparado).
 * @property precio El precio de venta de la motocicleta, nullable si no está en venta.
 * @property seVende Indica si la motocicleta está en venta (true) o no (false).
 * @property cilindrada La cilindrada de la motocicleta en centímetros cúbicos (cc).
 *
 * @constructor Crea una instancia de Motocicleta con los valores proporcionados.
 */
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


    /**
     * Verifica que la cilindrada de la motocicleta sea válida.
     * @param cilindrada La cilindrada a verificar.
     * @throws IllegalArgumentException Si la cilindrada no corresponde a valores predefinidos.
     */
    private fun comprobarCilindrada(cilindrada: Int){
        require(Cilindrada.entries.any {it.valor == cilindrada}) {"La cilidrada debe ser (${Cilindrada.entries.joinToString { "${it.valor}" }})"}
    }


    /**
     * Sobrescribe la función de verificación de caballos para ajustarse al rango específico de motocicletas.
     * @param caballos Los caballos de fuerza a verificar.
     * @throws IllegalArgumentException Si los caballos de fuerza están fuera del rango permitido.
     */
    override fun comprobarCvs(caballos: Int) {
        require(caballos in 30..220){"Los caballos deben estar en el rango (30 - 220)"}
    }


    /**
     * Permite editar la cilindrada de la motocicleta.
     * @param nuevaCilindrada La nueva cilindrada de la motocicleta.
     */
    fun editarCilindrada(nuevaCilindrada: Int){
        if (nuevaCilindrada != -1) {
            comprobarCilindrada(nuevaCilindrada)
            this.cilindrada = nuevaCilindrada
        }
    }


    companion object{
        /**
         * Funcion que crea un objeto tipo Motocicleta. Se inicializa como nulo y se pide los valores en bucle hasta que se introducen correctamente y se crea la moto.
         * @param enVenta Indica si el coche está en venta (por defecto es false). Usado para pedir o no el precio
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
                    GestionConsola.imprimirTexto("Error al crear la moto: ${e.message}. Prueba de nuevo")
                }
            }while (moto == null)
            return moto
        }
    }


    /**
     * Extiende la información de la vehiculo  añadiendo la cilindrada
     * @return Representación de cadena de caracteres de la motocicleta completa.
     */
    override fun toString(): String {
        return super.toString() + cilindrada
    }
}


/**
 * Enumeración que representa las cilindradas posibles de las motocicletas.
 * @property valor El valor de la cilindrada en centímetros cúbicos (cc).
 */
enum class Cilindrada(val valor: Int){
    CC300(300),
    CC600(600),
    CC1000(1000)
}