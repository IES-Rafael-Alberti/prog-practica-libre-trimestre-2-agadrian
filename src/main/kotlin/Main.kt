package org.practicatrim2

import java.util.*

fun String.capitalizar(): String {
    return this.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

//TODO: "Cambiar estado a tipo EstadoVehiculo" en el constructor del vehiculo
//TODO: Al reparar, que cambie el estado a reparado
//TODO: Poder modificar el estado del vehiculo en la funcion de editar vehiculo
//TODO: CAMBIAR DOCSTRING DE LA GESTIONCONSOLA


fun main() {


    val gestorVehiculos = InventarioVehiculos()
    val gestionConsola = GestionConsola()

    val menu = Menu()
    menu.menuPrincipal()


    //gestorVehiculos.mostrarTodo()

    //val moto = Motocicleta.crearMoto(gestionConsola)
    //gestorVehiculos.agregar(moto)

    //gestorVehiculos.ponerEnVenta(10, 4500.0)
    //gestorVehiculos.mostrarTodo()
    //gestorVehiculos.quitarDeVentas(10)


    //gestorVehiculos.mostrarTodo()






}