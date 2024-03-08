package org.practicatrim2



fun main() {

    //val entradaDatos = ConsolaEntradaDatos()
    //val inventarioVehiculos = InventarioVehiculos(entradaDatos)
    //val creadorVeh = CreadorVehiculos(entradaDatos)


    val gestorVehiculos = InventarioVehiculos()
    val gestionConsola = GestionConsola()

    //creadorVehiculos.crearMoto()
    //creadorVehiculos.crearCoche()
    //creadorVehiculos.crearMoto()
    //gestorVehiculos.mostrarTodo()
    //gestorVehiculos.ponerEnVenta(2, 5000.0)

    //gestorVehiculos.editar(1)
    //gestorVehiculos.mostrarTodo()


    gestorVehiculos.mostrarTodo()


    val coche = Coche.crearCoche(gestionConsola)
    gestorVehiculos.agregar(coche)

    //Vehiculo.crearMoto(gestionConsola)


    gestorVehiculos.mostrarTodo()






}