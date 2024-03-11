package org.practicatrim2

import java.util.*


fun String.capitalizar(): String {
    return this.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

//TODO: "Cambiar estado a tipo EstadoVehiculo" en el constructor del vehiculo
//TODO: Poder modificar el estado del vehiculo en la funcion de editar vehiculo


fun main() {

    val menu = Menu()
    menu.menuPrincipal()



}