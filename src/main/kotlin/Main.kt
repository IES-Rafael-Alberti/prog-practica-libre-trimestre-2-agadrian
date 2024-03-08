package org.practicatrim2


/*
fun crearVehiculo(creadorVehiculos: CreadorVehiculos, inventarioVehiculos: InventarioVehiculos){
    var opcion: Int?
    do {
        print("Que vehiculo deseas crear? (1.Coche 2.Moto) Enter para cancelar. -> ")
        val opc = readln()
        if (opc.isEmpty()) {
            println("Operacion Cancelada")
            return
        }
        opcion = opc.toIntOrNull()
        if (opcion !in 1..2) print("Opcion no valida. ")
    } while (opcion !in 1..2)

    when (opcion){
        1-> {
            val coche = creadorVehiculos.crearCoche()
            println("Coche creado correctamente")
            //inventarioVehiculos.agregarVehiculo(coche)

        }
        2 -> {
            val moto = creadorVehiculos.crearMoto()
            println("Moto creada correctamente")
            //inventarioVehiculos.agregarVehiculo(moto)
        }
    }

}

*/
fun main() {

    //val entradaDatos = ConsolaEntradaDatos()
    //val inventarioVehiculos = InventarioVehiculos(entradaDatos)
    //val creadorVeh = CreadorVehiculos(entradaDatos)


    val gestorVehiculos = InventarioVehiculos()
    val creadorVehiculos = CreadorVehiculos(gestorVehiculos)

    //creadorVehiculos.crearMoto()
    //creadorVehiculos.crearCoche()
    //creadorVehiculos.crearMoto()
    gestorVehiculos.mostrarTodo()
    gestorVehiculos.ponerEnVenta(2, 5000.0)

    gestorVehiculos.ponerEnVenta(1, 5000.0)
    gestorVehiculos.mostrarTodo()





}