package org.practicatrim2

abstract class Vehiculo(
    id: Int,
    private var marca: String,
    private var modelo: String,
    private var anio: Int,
    private var kilometros: Int,
    private var caballos: Int,
    private var precio: Double? = null,
    private var seVende: Boolean = false
) {

    var id = id
        private set

    init {
        require(marca.isNotBlank()) {"La marca no puede estar vacia"}
        require(modelo.isNotBlank()) {"El modelo no puede estar vacio"}
        require(anio in 1970..2024 ) {"El año debe estar en el rango (1970 - 2024)"}
        require(kilometros in 0..1000000) {"Los km deben estr en el reango (0 - 1000000)"}
        require(caballos in 30..600)
        //require(!seVende || (precio != null && precio!! in 5000.0..400000.0)) { "Si se vende, el precio debe estar en el rango (5.000 - 400.000), si no,  el precio debe ser nulo." }
    }


    companion object{

        var idVehUnica = 10
        fun crearIdUnica(): Int{
            idVehUnica++
            return idVehUnica
        }

        fun crearMoto(gestionConsola: GestionConsola, enVenta: Boolean = false){
            val moto = Motocicleta(
                crearIdUnica(),
                gestionConsola.solicitarDato("Marca: ", {it}),
                gestionConsola.solicitarDato("Modelo: ", {it}),
                gestionConsola.solicitarDato("Año: ", {it.toInt()}),
                gestionConsola.solicitarDato("Kms: ", {it.toInt()}),
                gestionConsola.solicitarDato("Caballos: ", {it.toInt()}),
                if (enVenta) gestionConsola.solicitarDato("Precio: ", {it.toDouble()}) else null,
                enVenta,
                gestionConsola.solicitarDato("Cilindrada: ", {it.toInt()})
            )

        }
    }




    fun ponerAventa(precioVenta: Double){
        if (!seVende) {
            this.precio = precioVenta
            this.seVende = true
            println("Puesto en venta correctamente")
        }
    }

    fun retirarDeVenta(){
        if (seVende){
            this.precio = null
            this.seVende = false
            println("Retirado de en venta correctamente")
        }
    }


    // TODO: O CREAR UNA FUNCION PARA CADA UNA, O HACER TODSA LAS PORPIEDADES PUBLICAS Y HACERLE UN SET , EN EL QUE MODIFIQUE CON EL NUEVO VALOR SI NO ES BLANCO, Y QUE LANZA REQUIRE. PARA LO DEL REQUIRE CREAR UNA FUNCION YA QUE LO LLAMO EN EL SET Y EN EL INIT.
    fun editarMarca(nuevaMarca: String){
        if (nuevaMarca.isNotBlank()) this.marca = nuevaMarca

    }


    override fun toString(): String {
        return "ID: $id - Marca: $marca - Modelo: $modelo - Año: $anio - Kms: $kilometros - Cvs: $caballos - En venta: ${if (seVende) "Si" else "No"} ${if (precio != null) "- Precio: $precio€" else ""}"
    }
}