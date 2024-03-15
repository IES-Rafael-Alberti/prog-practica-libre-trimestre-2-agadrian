package org.practicatrim2


/**
 * Clase abstracta que representa un vehículo.
 * Esta clase sirve como base para la creación de tipos específicos de vehículos.
 * @property id El identificador único del vehículo.
 * @property tipoVehiculo El tipo de vehículo.
 * @property marca La marca del vehículo.
 * @property modelo El modelo del vehículo.
 * @property anio El año de fabricación del vehículo.
 * @property kilometros Los kilómetros recorridos por el vehículo.
 * @property caballos La potencia en caballos del vehículo.
 * @property estado El estado del vehículo (por ejemplo, "Nuevo", "Usado", "Reparado", etc.).
 * @property precio El precio de venta del vehículo, si está a la venta.
 * @property seVende Indica si el vehículo está a la venta o no.
 */
abstract class Vehiculo(
    id: Int,
    val tipoVehiculo: TipoVehiculo,
    private var marca: String,
    private var modelo: String,
    private var anio: Int,
    private var kilometros: Int,
    private var caballos: Int,
    var estado: String,
    private var precio: Double? = null,
    private var seVende: Boolean = false,

) {

    var id = id
        private set




    init {
        comprobarMarca(marca)
        comprobarModelo(modelo)
        comprobarAnio(anio)
        comprobarKms(kilometros)
        comprobarCvs(caballos)
        comprobarPrecio(precio)
        comprobarEstado(estado)
    }


    /**
     * Verifica si el precio proporcionado es válido.
     * @param precio El precio a verificar.
     * @throws IllegalArgumentException Si el precio es nulo o no positivo.
     */
    private fun comprobarPrecio(precio: Double?){
        if (precio != null){
            require(precio > 0.0) {"El precio deber ser positivo"}
        }
    }


    /**
     * Verifica si la marca proporcionada es válida.
     * @param marca La marca a verificar.
     * @throws IllegalArgumentException Si la marca está vacía o en blanco.
     */
    private fun comprobarMarca(marca: String){
        require(marca.isNotBlank()) {"La marca no puede estar vacia"}
    }


    /**
     * Verifica si el modelo proporcionado es válido.
     * @param modelo El modelo a verificar.
     * @throws IllegalArgumentException Si el modelo está vacío o en blanco.
     */
    private fun comprobarModelo(modelo: String){
        require(modelo.isNotBlank()) {"El modelo no puede estar vacio"}
    }


    /**
     * Verifica si el año proporcionado está en el rango válido.
     * @param anio El año a verificar.
     * @throws IllegalArgumentException Si el año está fuera del rango (1970 - 2024).
     */
    private fun comprobarAnio(anio: Int){
        require(anio in 1970..2024 ) {"El año debe estar en el rango (1970 - 2024)"}
    }


    /**
     * Verifica si los kilómetros proporcionados están en el rango válido.
     * @param kilometros Los kilómetros a verificar.
     * @throws IllegalArgumentException Si los kilómetros están fuera del rango (0 - 1,000,000).
     */
    private fun comprobarKms(kilometros: Int){
        require(kilometros in 0..1000000) {"Los km deben estr en el reango (0 - 1.000.000)"}
    }


    /**
     * Verifica si los caballos proporcionados están en el rango válido.
     * @param caballos Los caballos a verificar.
     * @throws IllegalArgumentException Si los caballos están fuera del rango (30 - 600).
     */
    protected open fun comprobarCvs(caballos: Int){
        require(caballos in 30..600){"Los caballos deben estar en el rango (30 - 600)"}
    }


    /**
     * Verifica si el estado proporcionado es válido.
     * @param estado El estado a verificar.
     * @throws IllegalArgumentException Si el estado está vacío o no es uno de los estados válidos.
     */
    private fun comprobarEstado(estado: String){
        require(estado.isNotBlank()){"No puede estar vacio ${EstadoVehiculo.entries.joinToString { it.name }}"}
        require(estado.capitalizar() in EstadoVehiculo.entries.map { it.name.capitalizar() }) {"El estado debe ser uno de los siguientes: (${EstadoVehiculo.entries.joinToString { it.name.capitalizar() }})"}

    }

    /**
    * Objeto que proporciona métodos de utilidad para la gestión de identificadores únicos de vehículos.
    */
    companion object{
        var idVehUnica = 30
        fun crearIdUnica(): Int{
            idVehUnica++
            return idVehUnica
        }
    }


    /**
     * Obtiene el estado de venta del vehículo.
     * @return true si el vehículo está en venta, false en caso contrario.
     */
    fun getSeVende(): Boolean{
        return seVende
    }


    /**
     * Pone el vehículo en venta con el precio especificado.
     * @param precioVenta El precio de venta del vehículo.
     */
    fun ponerAventa(precioVenta: Double){
        if (!seVende) {
            try {
                comprobarPrecio(precioVenta)
                this.precio = precioVenta
                this.seVende = true
                GestionConsola.imprimirTexto("Puesto en venta correctamente")
            }catch (e: Exception){
                GestionConsola.imprimirTexto("Error - ${e.message}")
            }
        }else{
            GestionConsola.imprimirTexto("El vehiculo con ID $id ya estaba en venta")
        }
    }


    /**
     * Retira el vehículo de la venta.
     */
    fun retirarDeVenta(){
        if (seVende){
            this.precio = null
            this.seVende = false
            GestionConsola.imprimirTexto("Retirado de venta correctamente")
        }else{
            GestionConsola.imprimirTexto("El vehiculo con ID $id no esta en venta")
        }
    }



    /**
     * Edita la marca del vehículo.
     * Si la nueva marca no está vacía, se actualiza la marca del vehículo.
     * @param nuevaMarca La nueva marca del vehículo.
     */
    fun editarMarca(nuevaMarca: String){
        if (nuevaMarca.isNotBlank()) this.marca = nuevaMarca
    }


    /**
     * Edita el modelo del vehículo.
     * Si el nuevo modelo no está vacío, se actualiza el modelo del vehículo.
     * @param nuevoModelo El nuevo modelo del vehículo.
     */
    fun editarModelo(nuevoModelo: String){
        if (nuevoModelo.isNotBlank()) this.modelo = nuevoModelo
    }


    /**
     * Edita el año del vehículo.
     * Si el nuevo año es diferente de -1, se actualiza el año del vehículo y se comprueba su validez.
     * @param nuevoAnio El nuevo año del vehículo.
     */
    fun editarAnio(nuevoAnio: Int){
        if (nuevoAnio != -1) {
            comprobarAnio(nuevoAnio)
            this.anio = nuevoAnio
        }
    }


    /**
     * Edita los kilómetros del vehículo.
     * Si los nuevos kilómetros son diferentes de -1, se actualizan los kilómetros del vehículo y se comprueba su validez.
     * @param nuevoKms Los nuevos kilómetros del vehículo.
     */

    fun editarKms(nuevoKms: Int){
        if (nuevoKms != -1) {
            comprobarKms(nuevoKms)
            this.kilometros = nuevoKms
        }
    }


    /**
     * Edita los caballos del vehículo.
     * Si los nuevos caballos son diferentes de -1, se actualizan los caballos del vehículo y se comprueba su validez.
     * @param nuevosCvs Los nuevos caballos del vehículo.
     */
    fun editarCvs(nuevosCvs: Int){
        if (nuevosCvs != -1) {
            comprobarCvs(nuevosCvs)
            this.caballos = nuevosCvs
        }
    }


    /**
     * Edita el precio del vehículo.
     * Si el nuevo precio es diferente de -1.0, se actualiza el precio del vehículo y se comprueba su validez.
     * @param nuevoPrecio El nuevo precio del vehículo.
     */
    fun editarPrecio(nuevoPrecio: Double){
        if (nuevoPrecio != -1.0) {
            comprobarPrecio(nuevoPrecio)
            this.precio = nuevoPrecio
        }
    }


    /**
     * Devuelve una representación en formato de cadena del objeto Vehiculo.
     * El formato de la cadena incluye información sobre el ID, tipo de vehículo, marca, modelo,
     * año, kilometraje, caballos, si está en venta, precio (si está en venta), estado y
     * característica específica (si el vehículo es un coche).
     * @return Una cadena que representa el objeto Vehiculo.
     */
    override fun toString(): String {
        return String.format("%5s %10s %15s %20s %10s %10s %10s %10s %15s %10s %10s",
            id,
            tipoVehiculo.toString().capitalizar(),
            marca.capitalizar(),
            modelo.capitalizar(),
            anio,
            kilometros,
            caballos,
            if (seVende) "Si" else "No", if (precio != null) "$precio€" else "-",
            estado,
            if(tipoVehiculo == TipoVehiculo.Coche) "-" else ""
        )
    }


}
