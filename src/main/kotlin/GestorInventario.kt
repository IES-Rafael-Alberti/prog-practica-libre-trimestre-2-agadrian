package org.practicatrim2

/**
 * Interfaz que define las operaciones básicas para gestionar un inventario genérico.
 * @param T Tipo de elemento que se almacenará en el inventario.
 */
interface GestorInventario<T>{
    val listadoItems: MutableMap<Int, T>
    fun eliminar()
    fun editar()
    fun mostrar()
    fun mostrarTodo()
}


/**
 * Clase que representa un inventario de vehículos.
 * Implementa la interfaz [GestorInventario] parametrizada con el tipo [Vehiculo].
 */
class InventarioVehiculos: GestorInventario<Vehiculo> {

    override val listadoItems: MutableMap<Int, Vehiculo> = mutableMapOf(
        1 to Coche(1, TipoVehiculo.Coche, "Ford", "Focus", 2015, 80000, 120, "Roto"),
        2 to Coche(2, TipoVehiculo.Coche, "Toyota", "Corolla", 2018, 60000, 140, "Nuevo"),
        3 to Coche(3, TipoVehiculo.Coche, "Honda", "Civic", 2019, 55000, 130, "Nuevo"),
        4 to Coche(4, TipoVehiculo.Coche, "Chevrolet", "Cruze", 2017, 70000, 125, "Nuevo"),
        5 to Coche(5, TipoVehiculo.Coche, "BMW", "X3", 2016, 75000, 200, "Nuevo"),
        6 to Motocicleta(6, TipoVehiculo.Moto, "Yamaha", "MT-07", 2019, 15000, 75, "Roto", null, false, 600),
        7 to Motocicleta(7, TipoVehiculo.Moto, "Kawasaki", "Ninja", 2017, 20000, 120, "Roto", null, false, 1000),
        8 to Motocicleta(8, TipoVehiculo.Moto, "Suzuki", "GSX-R", 2018, 18000, 150, "Nuevo", null, false, 1000),
        9 to Motocicleta(9, TipoVehiculo.Moto, "Honda", "CBR600RR", 2016, 22000, 110, "Roto", null, false, 600),
        10 to Motocicleta(10, TipoVehiculo.Moto, "BMW", "S1000RR", 2017, 18000, 200, "Nuevo", null, false, 1000),
        11 to Coche(11, TipoVehiculo.Coche, "Audi", "A3", 2017, 65000, 135, "Nuevo"),
        12 to Coche(12, TipoVehiculo.Coche, "Mercedes-Benz", "C-Class", 2018, 70000, 150, "Nuevo"),
        13 to Coche(13, TipoVehiculo.Coche, "Volkswagen", "Golf", 2019, 58000, 125, "Nuevo"),
        14 to Coche(14, TipoVehiculo.Coche, "Hyundai", "Elantra", 2016, 55000, 130, "Roto"),
        15 to Coche(15, TipoVehiculo.Coche, "Subaru", "Impreza", 2017, 62000, 140, "Roto"),
        16 to Motocicleta(16, TipoVehiculo.Moto, "Ducati", "Panigale V4", 2019, 25000, 190, "Nuevo", null, false, 1000),
        17 to Motocicleta(17, TipoVehiculo.Moto, "Triumph", "Street Triple", 2018, 20000, 130, "Roto", null, false, 600),
        18 to Motocicleta(18, TipoVehiculo.Moto, "Aprilia", "RSV4", 2017, 22000, 170, "Nuevo", null, false, 1000),
        19 to Motocicleta(19, TipoVehiculo.Moto, "KTM", "Duke 390", 2018, 12000, 100, "Nuevo", null, false, 300),
        20 to Motocicleta(20, TipoVehiculo.Moto, "Harley-Davidson", "Sportster Iron 883", 2016, 15000, 80, "Roto", null, false, 1000),
        21 to Coche(21, TipoVehiculo.Coche, "Mazda", "3", 2016, 58000, 135, "Roto"),
        22 to Coche(22, TipoVehiculo.Coche, "Nissan", "Sentra", 2017, 56000, 130, "Roto"),
        23 to Coche(23, TipoVehiculo.Coche, "Volvo", "S60", 2018, 65000, 140, "Nuevo"),
        24 to Coche(24, TipoVehiculo.Coche, "Acura", "TLX", 2019, 70000, 150, "Nuevo"),
        25 to Coche(25, TipoVehiculo.Coche, "Lexus", "IS", 2017, 68000, 145, "Roto"),
        26 to Motocicleta(26, TipoVehiculo.Moto, "MV Agusta", "F4", 2018, 30000, 200, "Nuevo", null, false, 1000),
        27 to Motocicleta(27, TipoVehiculo.Moto, "Husqvarna", "Vitpilen 701", 2019, 18000, 130, "Nuevo", null, false, 1000),
        28 to Motocicleta(28, TipoVehiculo.Moto, "Indian", "Scout Sixty", 2017, 16000, 100, "Roto", null, false, 1000),
        29 to Motocicleta(29, TipoVehiculo.Moto, "Zero", "SR/S", 2020, 20000, 120, "Nuevo", null, false, 300),
        30 to Motocicleta(30, TipoVehiculo.Moto, "Ducati", "Monster", 2021, 25000, 140, "Nuevo", null, false, 1000)
    )



    /**
     * Crea un nuevo vehículo según la opción seleccionada por el usuario.
     * @return Vehículo creado.
     */
    private fun crearVeh(): Vehiculo{
        val tipoVehiculo = GestionConsola.solicitarTipoVeh()
        val veh = when (tipoVehiculo){
            TipoVehiculo.Coche -> Coche.crearCoche()
            TipoVehiculo.Moto -> Motocicleta.crearMoto()
        }
        return veh
    }


    /**
     * Agrega un vehículo al inventario de vehiculos.
     */
    fun agregarVehiculo() {
        val veh = crearVeh()

        if (!listadoItems.containsKey(veh.id)){
            listadoItems[veh.id] = veh
            GestionConsola.imprimirTexto("Vehiculo agregado correctamente")
        }else{
            GestionConsola.imprimirTexto("Error, ya existe un vehiculo con el ID: ${veh.id}")
        }
    }


    /**
     * Elimina un vehiculo del inventario mediante su ID
     */
    override fun eliminar() {
        val id = GestionConsola.preguntarId()

        if (listadoItems.containsKey(id)){
            listadoItems.remove(id)
            GestionConsola.imprimirTexto("Vehiculo eliminado correctamente")
        }else{
            GestionConsola.imprimirTexto("Error, no existe ningun vehiculo con el ID: $id")
        }
    }


    /**
     * Permite editar un vehiculo mediante la introduccion de los nuevos datos por consola.
     */
    override fun editar() {
        val id = GestionConsola.preguntarId()
        val vehiculo = listadoItems[id]

        if (vehiculo != null){
            GestionConsola.imprimirTexto("Introduce nuevos datos para el vehiculo con ID $id ")

            var ok = false
            do {
                try {
                    vehiculo.apply {
                        editarMarca(
                            GestionConsola.solicitarDato(
                                "Ingresa nueva marca - (Enter para no modificarla) -> ",
                                { it },
                                true
                            )
                        )

                        editarModelo(
                            GestionConsola.solicitarDato(
                                "Ingresa nuevo modelo - (Enter para no modificarlo) -> ",
                                { it },
                                true
                            )
                        )

                        editarAnio(
                            GestionConsola.solicitarDato(
                                "Ingresa nuevo año (1970-2024) - (Enter para no modificarlo) -> ", { it.toInt() },
                                true
                            )
                        )

                        editarKms(
                            GestionConsola.solicitarDato(
                                "Ingresa nuevos kms (0 - 1.000.000) - (Enter para no modificarlos) -> ",
                                { it.toInt() },
                                true
                            )
                        )

                        editarCvs(
                            GestionConsola.solicitarDato(
                                "Ingresa nuevos Cvs ${if (vehiculo.tipoVehiculo == TipoVehiculo.Coche) "(30 - 600)" else "(30 - 220)"} - (Enter para no modificarlos) -> ",
                                { it.toInt() },
                                true
                            )
                        )



                        if (vehiculo.getSeVende()) editarPrecio(
                            GestionConsola.solicitarDato(
                                "Ingresa nuevo precio - (Enter para no modificarlo) -> ",
                                { it.toDouble() },
                                true
                            )
                        )
                    }

                    if (vehiculo is Motocicleta) vehiculo.editarCilindrada(
                        GestionConsola.solicitarDato(
                            "Ingresa nueva cilindrada - (Enter para no modificarla) (300,600,1000) -> ",
                            { it.toInt() },
                            true
                        )
                    )

                    ok = true
                } catch (e: Exception) {
                    GestionConsola.imprimirTexto("Error al modificar el vehiculo: ${e.message}. Prueba de nuevo:")
                }
            }while (!ok)
            GestionConsola.imprimirTexto("Vehiculo con ID $id editado correctamente")

        }else{
            GestionConsola.imprimirTexto("No existe el vehiculo con ID $id")
        }
    }


    /**
     * Muestra por pantalla el vehiculo seleccionado del inventario mediante su ID
     */
    override fun mostrar() {
        val id = GestionConsola.preguntarId()
        if (listadoItems.containsKey(id)){
            val vehiculo = listadoItems[id]

            GestionConsola.imprimirTexto("Informacion del vehiculo con ID ${id}:\n${GestionConsola.tituloVehiculos}\n${"=".repeat(GestionConsola.tituloVehiculos.length)}\n$vehiculo")
        } else {
            GestionConsola.imprimirTexto("No se encontró un coche con el ID $id.")
        }
    }


    /**
     * Muestra todos los vehiculos del inventario
     */
    override fun mostrarTodo() {
        GestionConsola.imprimirTexto("Listado de todos los vehiculos:\n${GestionConsola.tituloVehiculos}\n${"=".repeat(GestionConsola.tituloVehiculos.length)}")

        listadoItems.values.forEach { GestionConsola.imprimirTexto(it.toString()) }
    }


    /**
     * Pone en venta un vehiculo mediante su ID con el precio deseado
     */
    fun ponerEnVenta(){

        val vehiculosNoVenta = obtenerVehiculosNoVenta()
        if (vehiculosNoVenta != null){
            GestionConsola.imprimirTexto("Listado de vehiculos que pueden ponerse en venta:\n${GestionConsola.tituloVehiculos}\n${"=".repeat(GestionConsola.tituloVehiculos.length)}")
            mostrarVehNoVenta()

            val id = GestionConsola.preguntarId()
            val precio = GestionConsola.solicitarDato("Introduce precio de venta: ", {it.toDouble()})
            val vehiculo = listadoItems[id]
            vehiculo?.ponerAventa(precio) ?: GestionConsola.imprimirTexto("El vehiculo con ID $id no existe en el inventario")
        }
    }


    /**
     * Quita de ventas un vehiculo mediante su ID
     */
    fun quitarDeVentas(){
        val vehiculosEnVenta = obtenerVehiculosVenta()
        if (vehiculosEnVenta != null){
            GestionConsola.imprimirTexto("Listado de vehiculos que estan en venta:\n${GestionConsola.tituloVehiculos}\n${"=".repeat(GestionConsola.tituloVehiculos.length)}")
            mostrarVehVenta()
            val id = GestionConsola.preguntarId()
            val vehiculo = listadoItems[id]
            vehiculo?.retirarDeVenta() ?: GestionConsola.imprimirTexto("El vehiculo con ID $id no existe en el inventario")
        }else{
            GestionConsola.imprimirTexto("No hay vehiculos en venta")
        }
    }


    /**
     * Retorna una lista de vehículos que están en venta.
     * @return Lista de vehículos en venta, o null si no hay ninguno disponible.
     */
    private fun obtenerVehiculosVenta(): List<Vehiculo>? {
        val vehiculosVenta = listadoItems.values.filter {it.getSeVende()}
        if (vehiculosVenta.isNotEmpty()) {
            return vehiculosVenta
        }
        return null
    }


    /**
     * Retorna una lista de vehículos que no están en venta.
     * @return Lista de vehículos no en venta, o null si no hay ninguno disponible.
     */
    private fun obtenerVehiculosNoVenta(): List<Vehiculo>?{
        val vehiculosVenta = listadoItems.values.filter {!it.getSeVende()}
        if (vehiculosVenta.isNotEmpty()) {
            return vehiculosVenta
        }
        return null
    }


    /**
     * Muestra por consola la información de los vehículos que están en venta.
     */
    private fun mostrarVehVenta(){
        val veh = obtenerVehiculosVenta()
        if (veh != null) veh.forEach { GestionConsola.imprimirTexto(it.toString()) }
    }


    /**
     * Muestra por consola la información de los vehículos que no están en venta.
     */
    private fun mostrarVehNoVenta(){
        val veh = obtenerVehiculosNoVenta()
        if (veh != null) veh.forEach { GestionConsola.imprimirTexto(it.toString()) }
    }
}


/**
 * Clase que representa un inventario de piezas.
 * Implementa la interfaz [GestorInventario] parametrizada con el tipo [Pieza].
 */
class InventarioPiezas(): GestorInventario<Pieza>{


    override val listadoItems: MutableMap<Int, Pieza> = mutableMapOf(
        1 to Pieza(1, "Bujía", "Bujía para motor de coche", 3, 10.0, TipoVehiculo.Coche),
        2 to Pieza(2, "Filtro de aire", "Filtro de aire para motos", 3, 9.0, TipoVehiculo.Moto),
        3 to Pieza(3, "Amortiguador", "Amortiguador para coches", 3, 25.0, TipoVehiculo.Coche),
        4 to Pieza(4, "Pastillas de freno", "Pastillas de freno para motos", 3, 15.0, TipoVehiculo.Moto),
        5 to Pieza(5, "Llanta", "Llanta para coches", 6, 50.0, TipoVehiculo.Coche),
        6 to Pieza(6, "Faro", "Faro para motos", 6, 30.0, TipoVehiculo.Moto),
        7 to Pieza(7, "Bomba de agua", "Bomba de agua para coches", 8, 40.0, TipoVehiculo.Coche),
        8 to Pieza(8, "Correa de distribución", "Correa de distribución para coches", 6, 35.0, TipoVehiculo.Coche),
        9 to Pieza(9, "Batería", "Batería para motos", 5, 20.0, TipoVehiculo.Moto),
        10 to Pieza(10, "Motor", "Motor para coches", 3, 200.0, TipoVehiculo.Coche),
        11 to Pieza(11, "Disco de freno", "Disco de freno para motos", 6, 18.0, TipoVehiculo.Moto),
        12 to Pieza(12, "Suspensión", "Suspensión para coches", 6, 120.0, TipoVehiculo.Coche),
        13 to Pieza(13, "Rueda", "Rueda para motos", 8, 40.0, TipoVehiculo.Moto),
        14 to Pieza(14, "Embrague", "Embrague para coches", 5, 80.0, TipoVehiculo.Coche),
        15 to Pieza(15, "Faros LED", "Faros LED para coches", 7, 100.0, TipoVehiculo.Coche),
        16 to Pieza(16, "Bomba de aceite", "Bomba de aceite para motos", 6, 28.0, TipoVehiculo.Moto),
        17 to Pieza(17, "Cilindro maestro", "Cilindro maestro para coches", 6, 55.0, TipoVehiculo.Coche),
        18 to Pieza(18, "Filtro de gasolina", "Filtro de gasolina para motos", 6, 12.0, TipoVehiculo.Moto),
        19 to Pieza(19, "Escape deportivo", "Escape deportivo para coches", 4, 180.0, TipoVehiculo.Coche),
        20 to Pieza(20, "Manetas de freno", "Manetas de freno para motos", 5, 8.0, TipoVehiculo.Moto),
        21 to Pieza(21, "Radiador", "Radiador para coches", 6, 75.0, TipoVehiculo.Coche),
        22 to Pieza(22, "Retrovisor", "Retrovisor para motos", 6, 15.0, TipoVehiculo.Moto),
        23 to Pieza(23, "Termostato", "Termostato para coches", 6, 30.0, TipoVehiculo.Coche),
        24 to Pieza(24, "Kit de cadena", "Kit de cadena para motos", 6, 50.0, TipoVehiculo.Moto),
        25 to Pieza(25, "Turbo", "Turbo para coches", 3, 400.0, TipoVehiculo.Coche),
        26 to Pieza(26, "Líquido de frenos", "Líquido de frenos para motos", 6, 10.0, TipoVehiculo.Moto),
        27 to Pieza(27, "Árbol de levas", "Árbol de levas para coches", 6, 85.0, TipoVehiculo.Coche),
        28 to Pieza(28, "Escape", "Escape para motos", 6, 120.0, TipoVehiculo.Moto),
        29 to Pieza(29, "Radiador de aceite", "Radiador de aceite para coches", 6, 65.0, TipoVehiculo.Coche),
        30 to Pieza(30, "Kit de embrague", "Kit de embrague para motos", 6, 70.0, TipoVehiculo.Moto)
    )


    /**
     * Elimina una pieza del inventario basándose en su ID.
     * Si la pieza con el ID especificado existe en el inventario, se elimina.
     * Muestra un mensaje informativo de la accion ocurrida
     */
    override fun eliminar() {
        val id = GestionConsola.preguntarId()
        if (listadoItems.containsKey(id)){
            listadoItems.remove(id)
            GestionConsola.imprimirTexto("Pieza eliminada correctamente")
        }else{
            GestionConsola.imprimirTexto("Error, no existe ninguna pieza con el ID $id")
        }
    }


    /**
     * Reduce el stock de una pieza en el inventario.
     * @param id El ID de la pieza cuyo stock se va a reducir.
     * @param cantidad La cantidad de unidades que se van a reducir del stock.
     * Muestra un mensaje informativo de la accion ocurrida
     */
    fun disminuirStock(id: Int, cantidad: Int){
        val pieza = listadoItems[id]
        if (pieza!= null){
            if (pieza.cantidadStock - cantidad >= 0){
                pieza.cantidadStock -= cantidad
                GestionConsola.imprimirTexto("Se ha reducido el stock de la pieza con ID $id en $cantidad unidades. Stock actual: ${pieza.cantidadStock}")
            }else {
                GestionConsola.imprimirTexto("No hay suficientes unidades de la pieza con ID $id para reducir el stock en $cantidad unidades.")
            }
        }else{
            GestionConsola.imprimirTexto("No se encontró una pieza con el ID $id.")
        }
    }


    /**
     * Edita la descripción de una pieza en el inventario.
     * Se solicita al usuario que ingrese una nueva descripción para la pieza con el ID especificado.
     */
    override fun editar() {
        val id = GestionConsola.preguntarId()
        val pieza = listadoItems[id]
        if (pieza != null) {
            GestionConsola.imprimirTexto("Pieza elegida con id $id:\n${GestionConsola.tituloPiezas}\n${"=".repeat(GestionConsola.tituloPiezas.length)}\n $pieza")
            val nuevaDescripcion = GestionConsola.solicitarDato("Introduce nueva descripcion: ", { it })
            pieza.descripcion = nuevaDescripcion
            GestionConsola.imprimirTexto("La descripción de la pieza con ID $id ha sido actualizada.")
        } else {
            GestionConsola.imprimirTexto("No se encontró una pieza con el ID $id.")
        }
    }


    /**
     * Realiza un pedido de piezas al inventario.
     * Si se especifica un ID de pieza, se realiza el pedido de esa pieza.
     * Si no se especifica un ID, se solicita al usuario que ingrese el ID de la pieza.
     * Si se especifica una cantidad, se utiliza esa cantidad para el pedido.
     * Si no se especifica una cantidad, se solicita al usuario que ingrese la cantidad.
     * @param id El ID de la pieza para la cual se realiza el pedido (opcional).
     * @param cant La cantidad de piezas para el pedido (opcional).
     */
    fun realizarPedido(id: Int? = null, cant: Int? = null){
        val piezaId = id ?: run {
            GestionConsola.imprimirTexto("De que pieza quieres hacer el pedido. ", false)
            GestionConsola.preguntarId()
        }

        if (piezaId in listadoItems.keys){
            val cantidad = cant ?: GestionConsola.solicitarDato("Introduce cantidad de piezas del pedido -> ", {it.toInt()})
            listadoItems[piezaId]?.let { pieza ->
                pieza.cantidadStock += cantidad
                GestionConsola.imprimirTexto("Pedido exitoso. Pieza pedida: ${pieza.nombre} - ID: $piezaId - Cantidad previa: ${pieza.cantidadStock - cantidad} - Cantidad pedida: $cantidad - Cantidad final: ${pieza.cantidadStock}")
            }
        }else{
            GestionConsola.imprimirTexto("No existe la pieza con ID $piezaId")
        }
    }


    /**
     * Muestra la información de una pieza en el inventario basándose en su ID.
     * Se solicita al usuario que ingrese el ID de la pieza.
     */
    override fun mostrar() {
        val id = GestionConsola.preguntarId()
        val pieza = listadoItems[id]
        if (pieza != null) {
            GestionConsola.imprimirTexto("Informacion de la pieza con ID $id:\n${GestionConsola.tituloPiezas}\n${"=".repeat(GestionConsola.tituloPiezas.length)}\n $pieza")
        } else {
            GestionConsola.imprimirTexto("No se encontró una pieza con el ID $id.")
        }
    }


    /**
     * Muestra la información de todas las piezas en el inventario.
     * Se muestra el nombre de la pieza, su descripción, cantidad en stock y precio.
     */
    override fun mostrarTodo() {
        GestionConsola.imprimirTexto("Listado de todas las piezas:\n${GestionConsola.tituloPiezas}\n${"=".repeat(GestionConsola.tituloPiezas.length)}")
        listadoItems.values.forEach { GestionConsola.imprimirTexto(it.toString()) }
    }
}

