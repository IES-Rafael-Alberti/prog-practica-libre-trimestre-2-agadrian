package org.practicatrim2

abstract class Vehiculo(
    id: Int,
    val tipoVehiculo: TipoVehiculo,
    private var marca: String,
    private var modelo: String,
    private var anio: Int,
    private var kilometros: Int,
    private var caballos: Int,
    private val estado: String,
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


    private fun comprobarPrecio(precio: Double?){
        if (precio != null){
            require(precio > 0.0) {"El precio deber ser positivo"}
        }
    }

    private fun comprobarMarca(marca: String){
        require(marca.isNotBlank()) {"La marca no puede estar vacia"}
    }

    private fun comprobarModelo(modelo: String){
        require(modelo.isNotBlank()) {"El modelo no puede estar vacio"}
    }

    private fun comprobarAnio(anio: Int){
        require(anio in 1970..2024 ) {"El año debe estar en el rango (1970 - 2024)"}
    }

    private fun comprobarKms(kilometros: Int){
        require(kilometros in 0..1000000) {"Los km deben estr en el reango (0 - 1.000.000)"}
    }

    protected open fun comprobarCvs(caballos: Int){
        require(caballos in 30..600){"Los caballos deben estar en el rango (30 - 600)"}
    }

    private fun comprobarEstado(estado: String){
        require(estado.isNotBlank()){"No puede estar vacio ${EstadoVehiculo.entries.joinToString { it.name }}"}
        require(estado.capitalizar() in EstadoVehiculo.entries.map { it.name.capitalizar() }) {"El estado debe ser uno de los siguientes: (${EstadoVehiculo.entries.joinToString { it.name.capitalizar() }})"}
    }


    companion object{

        var idVehUnica = 10
        fun crearIdUnica(): Int{
            idVehUnica++
            return idVehUnica
        }
    }

    fun getSeVende(): Boolean{
        return seVende
    }



    fun ponerAventa(precioVenta: Double){
        if (!seVende) {
            this.precio = precioVenta
            this.seVende = true
            println("Puesto en venta correctamente")
        }else{
            println("El vehiculo con ID $id ya esta en venta")
        }
    }

    fun retirarDeVenta(){
        if (seVende){
            this.precio = null
            this.seVende = false
            println("Retirado de en venta correctamente")
        }else{
            println("El vehiculo con ID $id no esta en venta")
        }
    }




    // TODO: O CREAR UNA FUNCION PARA CADA UNA, O HACER TODSA LAS PORPIEDADES PUBLICAS Y HACERLE UN SET , EN EL QUE MODIFIQUE CON EL NUEVO VALOR SI NO ES BLANCO, Y QUE LANZA REQUIRE. PARA LO DEL REQUIRE CREAR UNA FUNCION YA QUE LO LLAMO EN EL SET Y EN EL INIT.
    /**
     * Si la nueva marca introducida esta vacia, se deja la misma que tenia.
     * Si no, se modifica por la nueva
     */
    fun editarMarca(nuevaMarca: String){
        if (nuevaMarca.isNotBlank()) this.marca = nuevaMarca
    }

    fun editarModelo(nuevoModelo: String){
        if (nuevoModelo.isNotBlank()) this.modelo = nuevoModelo
    }

    fun editarAnio(nuevoAnio: Int){
        if (nuevoAnio != -1) {
            comprobarAnio(nuevoAnio)
            this.anio = nuevoAnio
        }
    }

    fun editarKms(nuevoKms: Int){
        if (nuevoKms != -1) {
            comprobarKms(nuevoKms)
            this.kilometros = nuevoKms
        }
    }

    fun editarCvs(nuevosCvs: Int){
        if (nuevosCvs != -1) {
            comprobarCvs(nuevosCvs)
            this.caballos = nuevosCvs
        }
    }

    fun editarPrecio(nuevoPrecio: Double){
        if (nuevoPrecio != -1.0) {
            comprobarPrecio(nuevoPrecio)
            this.precio = nuevoPrecio
        }
    }



    override fun toString(): String {
        return "ID: $id - Vehiculo: ${tipoVehiculo.toString().capitalizar()} - Marca: ${marca.capitalizar()} - Modelo: ${modelo.capitalizar()} - Año: $anio - Kms: $kilometros - Cvs: $caballos - En venta: ${if (seVende) "Si" else "No"} ${if (precio != null) "- Precio: $precio€" else ""} - Estado: $estado"
    }
}