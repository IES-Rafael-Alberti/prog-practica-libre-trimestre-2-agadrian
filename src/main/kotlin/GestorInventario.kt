package org.practicatrim2

interface GestorInventario<T>{
    fun agregar(item: T)
    fun eliminar(id: Int)
    fun editar(id: Int)
    fun buscar(id: Int): T?
    fun mostrar()
    fun mostrarTodo()
}


class InventarioVehiculos(): GestorInventario<Vehiculo> {

    private val listaVehiculos: MutableMap<Int, Vehiculo> = mutableMapOf(
        1 to Coche(1, "Ford", "Focus", 2015, 80000, 120),
        2 to Coche(2, "Toyota", "Corolla", 2018, 60000, 140),
        3 to Coche(3, "Honda", "Civic", 2019, 55000, 130),
        4 to Coche(4, "Chevrolet", "Cruze", 2017, 70000, 125),
        5 to Coche(5, "BMW", "X3", 2016, 75000, 200),
        6 to Motocicleta(6, "Yamaha", "MT-07", 2019, 15000, 75, 600.0, false, 600),
        7 to Motocicleta(7, "Kawasaki", "Ninja", 2017, 20000, 120, 1000.0, false, 1000),
        8 to Motocicleta(8, "Suzuki", "GSX-R", 2018, 18000, 150, 750.0, false, 750),
        9 to Motocicleta(9, "Honda", "CBR600RR", 2016, 22000, 110, 600.0, false, 600),
        10 to Motocicleta(10, "BMW", "S1000RR", 2017, 18000, 200, 1000.0, false, 1000)
    )

    override fun agregar(item: Vehiculo) {
        listaVehiculos[item.id] = item
    }

    override fun eliminar(id: Int) {
        TODO("Not yet implemented")
    }

    override fun editar(id: Int) {
        val vehiculo = listaVehiculos[id]

        vehiculo?.apply {
           //TODO editarMarca()
        }
    }

    override fun buscar(id: Int): Vehiculo? {
        TODO("Not yet implemented")
    }

    override fun mostrar() {
        TODO("Not yet implemented")
    }

    override fun mostrarTodo() {
        for (vehiculo in listaVehiculos.entries) {
            println(vehiculo.toString())
        }
    }

    fun ponerEnVenta(id: Int, precio: Double){
        val vehiculo = listaVehiculos[id]
        vehiculo?.ponerAventa(precio) ?: println("El vehiculo con ID :$id no existe en el inventario")
    }

    fun quitarDeVentas(vehiculo: Vehiculo){
        vehiculo.retirarDeVenta()
    }


}


class InventarioPiezas(): GestorInventario<Pieza>{

    private val listaPiezas: MutableMap<Int, Pieza> = mutableMapOf(
        1 to Pieza(1, "Bujia", "Bujia para motor gasolina generico", 12, 10.0, TipoVehiculo.COCHE),
        2 to Pieza(2, "Filtro de aire", "Filtro de aceite para motos", 20, 9.0, TipoVehiculo.MOTO)
    )


    override fun agregar(item: Pieza) {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int) {
        TODO("Not yet implemented")
    }

    override fun editar(id: Int) {
        TODO("Not yet implemented")
    }

    override fun buscar(id: Int): Pieza? {
        TODO("Not yet implemented")
    }

    override fun mostrar() {
        TODO("Not yet implemented")
    }

    override fun mostrarTodo() {

    }


}

