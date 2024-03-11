package org.practicatrim2


// TODO: VER SI ES BUENA IDEA QUE LA FUNCION DEL MENU PRINCIPAL TENGA INSTACIA DE TODOS LOS INVENTARIOS INCLUSO DEL GESTOR CONSOLA PARA PEDIR DATOS




class Menu() {
    companion object{
        fun pedirOpcion(min: Int, max: Int) : Int{
            var opcion: Int

            do {
                print("Introduce opcion -> ")
                opcion = readln().toIntOrNull() ?:-1

                if (opcion == -1){
                    print("Opcion no valida. ")
                } else if (opcion !in min..max) {
                    print("Opcion fuera de rango. ")
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
//                3 -> repararVehiculo()
//                4 -> generarFactura()
                5 -> println("Saliendo del programa...")
            }

        }while (opc != 5)
    }

    /**
     * Imprime las opciones del menu principal
     */
    private fun imprimirMenuPrincipal(){
        println("\nMenu Concesionario")
        println("1.- Gestion inventario vehiculos")
        println("2.- Gestion inventario piezas")
        println("3.- Reparar vehiculo")
        println("4.- Generar factura")
        println("5.- Salir")
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
        println("\nMenu Inventario Vehiculos")
        println("1.- Agregar vehiculo")
        println("2.- Eliminar vehiculo")
        println("3.- Editar vehiculo")
        println("4.- Poner en venta")
        println("5.- Quitar de venta")
        println("6.- Mostrar informacion vehiculo")
        println("7.- Mostrar listado vehiculos")
        println("8.- Volver")
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
//                1 -> agregarPieza()
//                2 -> eliminarPieza()
//                3 -> editarPieza()
//                4 -> mostrarInformacionPieza()
//                5 -> mostrarListadoPiezas()

            }

        }while (opc != 6)
    }

    /**
     * Imprime las opciones del submenu 2. Gestion inventario piezas
     */

    private fun imprimirGestionInventarioPiezas(){
        println("\nMenu Inventario Piezas")
        println("1.- Agregar pieza")
        println("2.- Eliminar pieza")
        println("3.- Editar pieza")
        println("4.- Mostrar informacion pieza")
        println("5.- Mostrar listado piezas")
        // TODO: println("5.- Hacer pedido pieza")
        println("6.- Salir")
    }








}



