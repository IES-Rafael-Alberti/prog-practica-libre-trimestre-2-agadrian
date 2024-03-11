package org.practicatrim2

interface GestorInventario<T>{
    val listadoItems: MutableMap<Int, T>
    fun preguntarId(): Int
    fun eliminar()
    fun editar()
    fun mostrar()
    fun mostrarTodo()
}

// TODO: REVISAR SI ES BUENA PRACTICA CREAR UNA INSTANCIA DE GESTION CONSOLA EN AMBAS CLASES DE INVENTARIO

class InventarioVehiculos(): GestorInventario<Vehiculo> {
    private val gestionConsola = GestionConsola()

    override val listadoItems: MutableMap<Int, Vehiculo> = mutableMapOf(
        1 to Coche(1, TipoVehiculo.COCHE, "Ford", "Focus", 2015, 80000, 120, "Nuevo"),
        2 to Coche(2, TipoVehiculo.COCHE, "Toyota", "Corolla", 2018, 60000, 140, "Nuevo"),
        3 to Coche(3, TipoVehiculo.COCHE, "Honda", "Civic", 2019, 55000, 130, "Nuevo"),
        4 to Coche(4, TipoVehiculo.COCHE, "Chevrolet", "Cruze", 2017, 70000, 125, "Nuevo"),
        5 to Coche(5, TipoVehiculo.COCHE, "BMW", "X3", 2016, 75000, 200, "Nuevo"),
        6 to Motocicleta(6, TipoVehiculo.MOTO, "Yamaha", "MT-07", 2019, 15000, 75, "Nuevo", null, false, 600),
        7 to Motocicleta(7, TipoVehiculo.MOTO,  "Kawasaki", "Ninja", 2017, 20000, 120, "Nuevo", null, false, 1000),
        8 to Motocicleta(8, TipoVehiculo.MOTO,  "Suzuki", "GSX-R", 2018, 18000, 150, "Nuevo", null, false, 1000),
        9 to Motocicleta(9, TipoVehiculo.MOTO,  "Honda", "CBR600RR", 2016, 22000, 110, "Nuevo", null, false, 600),
        10 to Motocicleta(10, TipoVehiculo.MOTO,  "BMW", "S1000RR", 2017, 18000, 200, "Nuevo", null, false, 1000)

    )


    private fun solicitarTipoVeh(): TipoVehiculo{
        println("Tipos de vehiculos: ")
        TipoVehiculo.entries.forEachIndexed { index, tipo ->
            println("${index + 1}. $tipo")
        }
        var opc: Int
        do {
            opc = gestionConsola.solicitarDato("Introduce opcion -> ", {it.toInt()})
            if (opc !in 1..TipoVehiculo.entries.size ) print("Opcion no valida. ")
        }while (opc !in 1..TipoVehiculo.entries.size)
        return TipoVehiculo.entries[opc - 1]
    }


    private fun crearVeh(): Vehiculo{
        val tipoVehiculo = solicitarTipoVeh()

        val veh = when (tipoVehiculo){
            TipoVehiculo.COCHE -> Coche.crearCoche(gestionConsola)
            TipoVehiculo.MOTO -> Motocicleta.crearMoto(gestionConsola)
        }
        return veh
    }


    fun agregarVehiculo() {
        val veh = crearVeh()

        if (!listadoItems.containsKey(veh.id)){
            listadoItems[veh.id] = veh
            println("Vehiculo agregado correctamente")
        }else{
            println("Error, ya existe un vehiculo con el ID: ${veh.id}")
        }

    }


    override fun preguntarId(): Int {
        val id = gestionConsola.solicitarDato("Introduce ID -> ", {it.toInt()})
        return id
    }


    override fun eliminar() {
        val id = preguntarId()

        if (listadoItems.containsKey(id)){
            listadoItems.remove(id)
            println("Vehiculo eliminado correctamente")
        }else{
            println("Error, no existe ningun vehiculo con el ID: $id")
        }
    }

    override fun editar() {
        val id = preguntarId()
        val vehiculo = listadoItems[id]

        if (vehiculo != null){
            println("Introduce nuevos datos para el vehiculo con ID $id ")

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
            println("No existe el vehiculo con ID $id")
        }
    }



    override fun mostrar() {
        val id = preguntarId()
        if (listadoItems.containsKey(id)){
            val vehiculo = listadoItems[id]
            println("Información del vehiculo con ID $id: ")
            print(vehiculo)
        } else {
            println("No se encontró un coche con el ID $id.")
        }
    }

    override fun mostrarTodo() {
        println("Listado de todos los vehiculos: ")
        listadoItems.values.forEach { println(it) }
    }

    fun ponerEnVenta(){

        val vehiculosNoVenta = obtenerVehiculosNoVenta()
        if (vehiculosNoVenta != null){

            println("Listado de vehiculo que pueden ponerse en venta: ")
            mostrarVehNoVenta()
            val id = preguntarId()
            val precio = gestionConsola.solicitarDato("Introduce precio de venta: ", {it.toDouble()})
            val vehiculo = listadoItems[id]
            vehiculo?.ponerAventa(precio) ?: println("El vehiculo con ID $id no existe en el inventario")
        }


    }

    fun quitarDeVentas(){
        val vehiculosEnVenta = obtenerVehiculosVenta()
        if (vehiculosEnVenta != null){
            println("Listado de vehiculo que estan en venta: ")
            mostrarVehVenta()
            val id = preguntarId()
            val vehiculo = listadoItems[id]
            vehiculo?.retirarDeVenta() ?: println("El vehiculo con ID $id no existe en el inventario")
        }else{
            println("No hay vehiculos en venta")
        }

    }

    private fun obtenerVehiculosVenta(): List<Vehiculo>? {
        val vehiculosVenta = listadoItems.values.filter {it.getSeVende()}
        if (vehiculosVenta.isNotEmpty()) {
            return vehiculosVenta
        }
        return null
    }

    private fun obtenerVehiculosNoVenta(): List<Vehiculo>?{
        val vehiculosVenta = listadoItems.values.filter {!it.getSeVende()}
        if (vehiculosVenta.isNotEmpty()) {
            return vehiculosVenta
        }
        return null
    }


    private fun mostrarVehVenta(){
        val veh = obtenerVehiculosVenta()
        if (veh != null) veh.forEach { println(it) }
    }

    private fun mostrarVehNoVenta(){
        val veh = obtenerVehiculosNoVenta()
        if (veh != null) veh.forEach { println(it) }
    }
}


class InventarioPiezas(): GestorInventario<Pieza>{
    private val gestionConsola = GestionConsola()

    override val listadoItems: MutableMap<Int, Pieza> = mutableMapOf(
        1 to Pieza(1, "Bujía", "Bujía para motor gasolina genérico", 12, 10.0, TipoVehiculo.COCHE),
        2 to Pieza(2, "Filtro de aire", "Filtro de aire para motos", 20, 9.0, TipoVehiculo.MOTO),
        3 to Pieza(3, "Amortiguador", "Amortiguador para coches", 15, 25.0, TipoVehiculo.COCHE),
        4 to Pieza(4, "Pastillas de freno", "Pastillas de freno para motos", 18, 15.0, TipoVehiculo.MOTO),
        5 to Pieza(5, "Llanta", "Llanta para coches", 22, 50.0, TipoVehiculo.COCHE),
        6 to Pieza(6, "Faro", "Faro para motos", 10, 30.0, TipoVehiculo.MOTO),
        7 to Pieza(7, "Bomba de agua", "Bomba de agua para coches", 8, 40.0, TipoVehiculo.COCHE),
        8 to Pieza(8, "Correa de distribución", "Correa de distribución para coches", 6, 35.0, TipoVehiculo.COCHE),
        9 to Pieza(9, "Batería", "Batería para motos", 25, 20.0, TipoVehiculo.MOTO),
        10 to Pieza(10, "Motor", "Motor para coches", 3, 200.0, TipoVehiculo.COCHE),
        11 to Pieza(11, "Disco de freno", "Disco de freno para motos", 16, 18.0, TipoVehiculo.MOTO),
        12 to Pieza(12, "Suspensión", "Suspensión para coches", 9, 120.0, TipoVehiculo.COCHE),
        13 to Pieza(13, "Rueda", "Rueda para motos", 30, 40.0, TipoVehiculo.MOTO),
        14 to Pieza(14, "Embrague", "Embrague para coches", 5, 80.0, TipoVehiculo.COCHE),
        15 to Pieza(15, "Faros LED", "Faros LED para coches", 7, 100.0, TipoVehiculo.COCHE),
        16 to Pieza(16, "Bomba de aceite", "Bomba de aceite para motos", 12, 28.0, TipoVehiculo.MOTO),
        17 to Pieza(17, "Cilindro maestro", "Cilindro maestro para coches", 10, 55.0, TipoVehiculo.COCHE),
        18 to Pieza(18, "Filtro de gasolina", "Filtro de gasolina para motos", 20, 12.0, TipoVehiculo.MOTO),
        19 to Pieza(19, "Escape deportivo", "Escape deportivo para coches", 4, 180.0, TipoVehiculo.COCHE),
        20 to Pieza(20, "Manetas de freno", "Manetas de freno para motos", 15, 8.0, TipoVehiculo.MOTO),
        21 to Pieza(21, "Radiador", "Radiador para coches", 11, 75.0, TipoVehiculo.COCHE),
        22 to Pieza(22, "Retrovisor", "Retrovisor para motos", 8, 15.0, TipoVehiculo.MOTO),
        23 to Pieza(23, "Termostato", "Termostato para coches", 7, 30.0, TipoVehiculo.COCHE),
        24 to Pieza(24, "Kit de cadena", "Kit de cadena para motos", 13, 50.0, TipoVehiculo.MOTO),
        25 to Pieza(25, "Turbo", "Turbo para coches", 3, 400.0, TipoVehiculo.COCHE),
        26 to Pieza(26, "Líquido de frenos", "Líquido de frenos para motos", 18, 10.0, TipoVehiculo.MOTO),
        27 to Pieza(27, "Árbol de levas", "Árbol de levas para coches", 6, 85.0, TipoVehiculo.COCHE),
        28 to Pieza(28, "Escape", "Escape para motos", 22, 120.0, TipoVehiculo.MOTO),
        29 to Pieza(29, "Radiador de aceite", "Radiador de aceite para coches", 9, 65.0, TipoVehiculo.COCHE),
        30 to Pieza(30, "Kit de embrague", "Kit de embrague para motos", 11, 70.0, TipoVehiculo.MOTO)
    )

    override fun preguntarId(): Int {
        val id = gestionConsola.solicitarDato("Introduce ID a eliminar -> ", {it.toInt()})
        return id
    }

    override fun eliminar() {
        val id = preguntarId()
        if (listadoItems.containsKey(id)){
            listadoItems.remove(id)
            println("Pieza eliminada correctamente")
        }else{
            println("Error, no existe ninguna pieza con el ID $id")
        }
    }

    // TODO: revisar, posiblemente crear otra funcion que pregunte cantidad
    fun disminuirStock(cantidad: Int){
        val id = preguntarId()

        val pieza = listadoItems[id]
        if (pieza!= null){
            if (pieza.cantidadStock - cantidad >= 0){
                pieza.cantidadStock -= cantidad
                println("Se ha reducido el stock de la pieza con ID $id en $cantidad unidades. Stock actual: ${pieza.cantidadStock}")
            }else {
                println("No hay suficientes unidades de la pieza con ID $id para reducir el stock en $cantidad unidades.")
            }
        }else{
            println("No se encontró una pieza con el ID $id.")
        }
    }

    override fun editar() {
        val id = preguntarId()
        val pieza = listadoItems[id]
        if (pieza != null) {
            //println("Descripción actual: ${pieza.descripcion}")
            val nuevaDescripcion = gestionConsola.solicitarDato("Introduce nueva descripcion: ", { it })
            pieza.descripcion = nuevaDescripcion
            println("La descripción de la pieza con ID $id ha sido actualizada.")
        } else {
            println("No se encontró una pieza con el ID $id.")
        }
    }


    override fun mostrar() {
        val id = preguntarId()
        val pieza = listadoItems[id]
        if (pieza != null) {
            println("Información de la pieza con ID $id: ${println(pieza)}")
        } else {
            println("No se encontró una pieza con el ID $id.")
        }
    }

    override fun mostrarTodo() {
        println("Listado de todas las piezas:")
        listadoItems.values.forEach { println(it) }
    }


}

