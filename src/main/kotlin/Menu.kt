package org.practicatrim2


class Menu() {
    companion object{
        fun pedirOpcion(min: Int, max: Int) : Int{
            var opcion: Int

            do {
                GestionConsola.imprimirTexto("Introduce opcion -> ", false)
                opcion = readln().toIntOrNull() ?:-1

                if (opcion == -1){
                    GestionConsola.imprimirTexto("Opcion no valida. ", false)
                } else if (opcion !in min..max) {
                    GestionConsola.imprimirTexto("Opcion fuera de rango. ", false)
                }
            } while (opcion !in min..max)

            return opcion
        }
    }


    /**
     * Menu principal
     */
    fun menuPrincipal(){
        val inventarioVeh = InventarioVehiculos()
        val inventarioPiezas = InventarioPiezas()

        var opc: Int
        do {
            imprimirMenuPrincipal()
            opc = pedirOpcion(1,5)

            when (opc){
                1 -> gestionInventarioVehiculos(inventarioVeh)
                2 -> gestionInventarioPiezas(inventarioPiezas)
                3 -> menuTaller()
//                4 -> generarFactura()
                5 -> GestionConsola.imprimirTexto("Saliendo del programa...")
            }
        }while (opc != 5)
    }

    /**
     * Imprime las opciones del menu principal
     */
    private fun imprimirMenuPrincipal(){
        GestionConsola.imprimirTexto("\nMenu Concesionario")
        GestionConsola.imprimirTexto("1.- Gestion inventario vehiculos")
        GestionConsola.imprimirTexto("2.- Gestion inventario piezas")
        GestionConsola.imprimirTexto("3.- Taller")
        GestionConsola.imprimirTexto("4.- Generar factura")
        GestionConsola.imprimirTexto("5.- Salir")
    }






    /**
     * Sub menu 1. Gestion inventario vehiculos
     */
    private fun gestionInventarioVehiculos(inventarioVeh: InventarioVehiculos){

        var opc: Int
        do {
            imprimirGestionInventarioVehiculos()
            opc = pedirOpcion(1,8)

            when (opc){
                1 -> inventarioVeh.agregarVehiculo()
                2 -> inventarioVeh.eliminar()
                3 -> inventarioVeh.editar()
                4 -> inventarioVeh.ponerEnVenta()
                5 -> inventarioVeh.quitarDeVentas()
                6 -> inventarioVeh.mostrar()
                7 -> inventarioVeh.mostrarTodo()
            }
        }while (opc != 8)
    }

    /**
     * Imprime las opciones del submenu 1. Gestion inventario vehiculos
     */
    private fun imprimirGestionInventarioVehiculos(){
        GestionConsola.imprimirTexto("\nMenu Inventario Vehiculos")
        GestionConsola.imprimirTexto("1.- Agregar vehiculo")
        GestionConsola.imprimirTexto("2.- Eliminar vehiculo")
        GestionConsola.imprimirTexto("3.- Editar vehiculo")
        GestionConsola.imprimirTexto("4.- Poner en venta")
        GestionConsola.imprimirTexto("5.- Quitar de venta")
        GestionConsola.imprimirTexto("6.- Mostrar informacion vehiculo")
        GestionConsola.imprimirTexto("7.- Mostrar listado vehiculos")
        GestionConsola.imprimirTexto("8.- Volver")
    }




    /**
     * Sub menu 2. Gestion inventario piezas
     */
    private fun gestionInventarioPiezas(inventarioPiezas: InventarioPiezas){
        var opc: Int
        do {
            imprimirGestionInventarioPiezas()
            opc = pedirOpcion(1,6)

            when (opc){
                1 -> inventarioPiezas.eliminar()
                2 -> inventarioPiezas.editar()
                3 -> inventarioPiezas.realizarPedido()
                4 -> inventarioPiezas.mostrar()
                5 -> inventarioPiezas.mostrarTodo()
            }
        }while (opc != 6)
    }

    /**
     * Imprime las opciones del submenu 2. Gestion inventario piezas
     */

    private fun imprimirGestionInventarioPiezas(){
        GestionConsola.imprimirTexto("\nMenu Inventario Piezas")
        GestionConsola.imprimirTexto("1.- Eliminar pieza del stock")
        GestionConsola.imprimirTexto("2.- Editar pieza")
        GestionConsola.imprimirTexto("3.- Realizar pedido piezas")
        GestionConsola.imprimirTexto("4.- Mostrar informacion pieza")
        GestionConsola.imprimirTexto("5.- Mostrar listado piezas")
        GestionConsola.imprimirTexto("6.- Volver")
    }


    /**
     * Submenu 3. Taller
     */
    private fun menuTaller(){
        var opc: Int
        do {
            imprimirOpcionesMenuTaller()
            opc = pedirOpcion(1,4)

            when (opc){
                1 -> Taller.repararVehiculo()
                2 -> Taller.mostrarVehiculosReparados()

            }
        }while (opc != 4)
    }


    private fun imprimirOpcionesMenuTaller(){
        GestionConsola.imprimirTexto("\nMenu Taller")
        GestionConsola.imprimirTexto("1.- Reparar vehiculo")
        GestionConsola.imprimirTexto("2.- Mostrar Vehiculos Reparados")
        GestionConsola.imprimirTexto("6.- Volver")
        println("\nMenu Taller")
        println("1.- Reparar vehiculo")
        println("2.- Mostrar Vehiculos Reparados")
        println("6.- Volver")
    }







}



