package org.practicatrim2

open class Vehiculo(
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


    fun editarMarca(nuevaMarca: String){
        if (nuevaMarca.isNotBlank()) this.marca = nuevaMarca

    }




    override fun toString(): String {
        return "ID: $id - Marca: $marca - Modelo: $modelo - Año: $anio - Kms: $kilometros - Cvs: $caballos - En venta: ${if (seVende) "Si" else "No"} ${if (precio != null) "- Precio: $precio€" else ""}"
    }
}