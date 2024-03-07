package org.practicatrim2


interface EntradaDatos{
    fun pedirMarca(esEdicion: Boolean = false): String
    fun pedirModelo(esEdicion: Boolean = false): String
    fun pedirAnio(esEdicion: Boolean = false): Int
    fun pedirCaballos(esEdicion: Boolean = false): Int
    fun pedirPrecio(esEdicion: Boolean = false): Double
    fun pedirCilindrada(esEdicion: Boolean = false): Int
}

// TODO: Que si es para editar, al presionar enter en el campo deseado se mantenga el valor y no se modifique nada

// TODO !!!!!!!! HACER EL MISMO IF QUE EN MARCA PARA COMPROBAR QUE INTRODUCE VACIO SI ES EDICION Y DEVOLVERLO. AÑADIR TAMBIEN EL MENSAJE DE QUE PRESIONE ENTER SI NO DESEA CAMBIAR NADA
class ConsolaEntradaDatos : EntradaDatos{
    override fun pedirMarca(esEdicion: Boolean):String {
        var marca: String
        do {
            print("Introduce la marca del vehiculo -> ")
            marca = readln()
            if (esEdicion && marca.isEmpty()) return marca
        } while (marca.isNotBlank())
        return marca
    }

    override fun pedirModelo(esEdicion: Boolean): String {
        var modelo: String
        do {
            print("Introduce el modelo del vehiculo -> ")
            modelo = readln()
        } while (modelo.isNotBlank())
        return modelo
    }

    override fun pedirAnio(esEdicion: Boolean): Int {
        var anio: Int
        do {
            print("Introduce el año del vehiculo (1970-2024) -> ")
            anio = readln().toIntOrNull() ?: 0
            if (anio !in 1970..2024) println("Error - Año no valido. ")
        } while (anio !in 1970..2024)
        return anio
    }

    override fun pedirCaballos(esEdicion: Boolean): Int {
        var caballos: Int
        do {
            println("Introduce los caballos del vehiculo (entre 80 y 600) -> ")
            caballos = readln().toIntOrNull() ?: 0
            if (caballos !in 80..600) println("Error - Cvs no validos. ")
        } while (caballos !in 80..600)
        return caballos
    }

    override fun pedirPrecio(esEdicion: Boolean): Double {
        var precio: Double
        do {
            println("Introduce el precio del vehiculo (5000 - 400000) -> ")
            precio = readln().toDoubleOrNull() ?: 0.0
            if (precio <= 5000.0 || precio > 400000f) println("Error - Precio no valido")
        } while (precio <= 5000.0 || precio > 400000f)
        return precio
    }

    override fun pedirCilindrada(esEdicion: Boolean): Int {
        var cilindrada: Int
        do {
            println("Introduce la cilindrada del vehiculo (300, 600, 1000) -> ")
            cilindrada = readln().toIntOrNull() ?: 0
        } while (!Cilindrada.entries.any { it.valor == cilindrada })
        return cilindrada
    }


}