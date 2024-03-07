package org.practicatrim2



fun crearVehiculo(creadorVehiculos: CreadorVehiculos) : Vehiculo?{
    var opcion: Int?
    do {
        print("Que vehiculo deseas crear? (1.Coche 2.Moto) Enter para cancelar. -> ")
        val opc = readln()
        if (opc.isEmpty()) return null

        opcion = opc.toIntOrNull()
        if (opcion !in 1..2) print("Opcion no valida. ")

    } while (opcion !in 1..2)

    return when (opcion){
        1-> creadorVehiculos.crearCoche()
        2 -> creadorVehiculos.crearMoto()
        else -> null
    }

}


fun main() {

    val entradaDatos = ConsolaEntradaDatos()
    val inventarioVehiculos = InventarioVehiculos(entradaDatos)
    val creadorVeh = CreadorVehiculos(entradaDatos)

    val coche1 = Coche(3, "dgfg", "dfdg", 434, 45000, 34, 34.34)
    val moto1 = Motocicleta(1, "moto", "reta", 434, 45000, 34, 12000.0, 250)

    if(crearVehiculo(creadorVeh) == null) println("Creacion cancelada.")

    println(coche1.toString())
    inventarioVehiculos.agregarVehiculo(coche1)

    inventarioVehiculos.editarVehiculo(3)
    println(coche1.toString())


}