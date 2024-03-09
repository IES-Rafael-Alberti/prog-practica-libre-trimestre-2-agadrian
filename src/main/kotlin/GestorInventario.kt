package org.practicatrim2

interface GestorInventario<T>{
    val listadoItems: MutableMap<Int, T>
    fun agregar(item: T)
    fun eliminar(id: Int)
    fun editar(id: Int)
    fun buscar(id: Int): T?
    fun mostrar(id: Int)
    fun mostrarTodo()
}





class InventarioVehiculos(): GestorInventario<Vehiculo> {
    private val gestionConsola = GestionConsola()

    override val listadoItems: MutableMap<Int, Vehiculo> = mutableMapOf(
        1 to Coche(1, TipoVehiculo.COCHE, "Ford", "Focus", 2015, 80000, 120),
        2 to Coche(2, TipoVehiculo.COCHE, "Toyota", "Corolla", 2018, 60000, 140),
        3 to Coche(3, TipoVehiculo.COCHE, "Honda", "Civic", 2019, 55000, 130),
        4 to Coche(4, TipoVehiculo.COCHE, "Chevrolet", "Cruze", 2017, 70000, 125),
        5 to Coche(5, TipoVehiculo.COCHE, "BMW", "X3", 2016, 75000, 200),
        6 to Motocicleta(6, TipoVehiculo.MOTO, "Yamaha", "MT-07", 2019, 15000, 75, 600.0, false, 600),
        7 to Motocicleta(7, TipoVehiculo.MOTO,  "Kawasaki", "Ninja", 2017, 20000, 120, 1000.0, false, 1000),
        8 to Motocicleta(8, TipoVehiculo.MOTO,  "Suzuki", "GSX-R", 2018, 18000, 150, 750.0, false, 1000),
        9 to Motocicleta(9, TipoVehiculo.MOTO,  "Honda", "CBR600RR", 2016, 22000, 110, 600.0, false, 600),
        10 to Motocicleta(10, TipoVehiculo.MOTO,  "BMW", "S1000RR", 2017, 18000, 200, 1000.0, false, 1000)

    )

    override fun agregar(item: Vehiculo) {

        if (!listadoItems.containsKey(item.id)){
            listadoItems[item.id] = item
            println("Vehiculo agregado correctamente")
        }else{
            println("Error, ya existe un vehiculo con el ID: ${item.id}")
        }


    }

    override fun eliminar(id: Int) {
        if (!listadoItems.containsKey(id)){
            listadoItems.remove(id)
            println("Vehiculo agregado correctamente")
        }else{
            println("Error, ya existe un vehiculo con el ID: $id")
        }
    }

    override fun editar(id: Int) {
        val vehiculo = listadoItems[id]


        if (vehiculo != null){
            println("Introduce nuevos datos para el vehiculo con ID $id: ")

            var ok = false
            do {
                try {
                    vehiculo.apply {
                        editarMarca(
                            gestionConsola.solicitarDato(
                                "Ingresa nueva marca (Enter para no modificarla) -> ",
                                { it },
                                true
                            )
                        )

                        editarModelo(
                            gestionConsola.solicitarDato(
                                "Ingresa nuevo modelo (Enter para no modificarlo) -> ",
                                { it },
                                true
                            )
                        )

                        editarAnio(
                            gestionConsola.solicitarDato(
                                "Ingresa nuevo año (1970-2024) - (Enter para no modificarlo) -> ", { it.toInt() },
                                true
                            )
                        )

                        editarKms(
                            gestionConsola.solicitarDato(
                                "Ingresa nuevos kms (0 - 1.000.000) (Enter para no modificarlos) -> ",
                                { it.toInt() },
                                true
                            )
                        )

                        editarCvs(
                            gestionConsola.solicitarDato(
                                "Ingresa nuevos Cvs ${if (vehiculo.tipoVehiculo == TipoVehiculo.COCHE) "(30 - 600)" else "(30 - 220)"} (Enter para no modificarlos) -> ",
                                { it.toInt() },
                                true
                            )
                        )

                        if (vehiculo.getSeVende()) editarPrecio(
                            gestionConsola.solicitarDato(
                                "Ingresa nuevo precio (Enter para no modificarlo) -> ",
                                { it.toDouble() },
                                true
                            )
                        )
                    }

                    if (vehiculo is Motocicleta) vehiculo.editarCilindrada(
                        gestionConsola.solicitarDato(
                            "Ingresa nueva cilindrada (Enter para no modificarla) (300,600,1000) -> ",
                            { it.toInt() },
                            true
                        )
                    )

                    ok = true
                } catch (e: Exception) {
                    println("Error al modificar el vehiculo: ${e.message}. Prueba de nuevo:")
                }
            }while (!ok)

        }else{
            println("No existe el vehiculo con ID : $id")
        }
    }


    override fun buscar(id: Int): Vehiculo? {
        // TODO
        return null
    }

    override fun mostrar(id: Int) {

    }

    override fun mostrarTodo() {
        listadoItems.values.forEach { println(it) }
    }

    fun ponerEnVenta(id: Int, precio: Double){
        val vehiculo = listadoItems[id]
        vehiculo?.ponerAventa(precio) ?: println("El vehiculo con ID :$id no existe en el inventario")
    }

    fun quitarDeVentas(vehiculo: Vehiculo){
        vehiculo.retirarDeVenta()
    }


}


class InventarioPiezas(): GestorInventario<Pieza>{

    override val listadoItems: MutableMap<Int, Pieza> = mutableMapOf()


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

    override fun mostrar(id: Int) {
        TODO("Not yet implemented")
    }

    override fun mostrarTodo() {
        TODO("NOt yet")
    }


}

