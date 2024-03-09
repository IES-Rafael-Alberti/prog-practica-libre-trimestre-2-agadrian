package org.practicatrim2

import java.util.*

fun String.capitalizar(): String {
    return this.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

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


    val moto = Motocicleta.crearMoto(gestionConsola, true)
    gestorVehiculos.agregar(moto)

    gestorVehiculos.editar(45)


    //Vehiculo.crearMoto(gestionConsola)


    gestorVehiculos.mostrarTodo()






}