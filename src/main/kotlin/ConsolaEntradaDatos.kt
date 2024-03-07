package org.practicatrim2


interface EntradaDatos{
    fun pedirMarca(esEdicion: Boolean = false): String
    fun pedirModelo(esEdicion: Boolean = false): String
    fun pedirAnio(esEdicion: Boolean = false): Int
    fun pedirKilometros(esEdicion: Boolean = false): Int
    fun pedirCaballos(esEdicion: Boolean = false): Int
    fun pedirPrecio(esEdicion: Boolean = false): Double
    fun pedirCilindrada(esEdicion: Boolean = false): Int
}



class ConsolaEntradaDatos : EntradaDatos{
    override fun pedirMarca(esEdicion: Boolean):String {
        var marca: String
        val msg: String = if (!esEdicion) "Introduce la marca del vehiculo -> " else "Introduce nueva marca (Enter/vacio si no quieres modificarla) -> "

        do {
            print(msg)
            marca = readln()
            if (esEdicion && marca.isEmpty()) return marca
            if (marca.isBlank()) print("Error - No puede estar vacia. ")
        } while (marca.isBlank())
        return marca
    }


    override fun pedirModelo(esEdicion: Boolean): String {
        var modelo: String
        val msg: String = if (!esEdicion) "Introduce el modelo del vehiculo -> " else "Introduce nueva modelo (Enter/vacio si no quieres modificarlo) -> "

        do {
            print(msg)
            modelo = readln()
            if (esEdicion && modelo.isEmpty()) return modelo
            if (modelo.isBlank()) print("Error - No puede estar vacio. ")
        } while (modelo.isBlank())
        return modelo
    }


    override fun pedirAnio(esEdicion: Boolean): Int {
        var anio: Int
        val msg: String = if (!esEdicion) "Introduce el año del vehiculo (1970-2024) -> " else "Introduce nuevo año (1970-2024)-(Enter/vacio si no quieres modificarlo) -> "

        do {
            print(msg)
            anio = readln().toIntOrNull() ?: -1
            if (esEdicion && anio == -1) return anio
            if (anio !in 1970..2024) print("Error - Año no valido. ")
        } while (anio !in 1970..2024)
        return anio
    }

    override fun pedirKilometros(esEdicion: Boolean): Int {
        var kms: Int
        val msg: String = if (!esEdicion) "Introduce kms del vehiculo (0- 1.000.000) -> " else "Introduce nuevos kms (0- 1.000.000)-(Enter/vacio si no quieres modificarlo) -> "

        do {
            print(msg)
            kms = readln().toIntOrNull() ?: -1
            if (esEdicion && kms == -1) return kms
            if (kms !in 0..1000000) print("Error - Kms no validos. ")
        } while (kms !in 0..1000000)
        return kms
    }


    override fun pedirCaballos(esEdicion: Boolean): Int {
        var caballos: Int
        val msg: String = if (!esEdicion) "Introduce los caballos del vehiculo (30-600) -> " else "Introduce nuevos caballos (30-600)-(Enter/vacio si no quieres modificarlo) -> "

        do {
            print(msg)
            caballos = readln().toIntOrNull() ?: -1
            if (esEdicion && caballos == -1) return caballos
            if (caballos !in 30..600) print("Error - Cvs no validos. ")
        } while (caballos !in 30..600)
        return caballos
    }


    override fun pedirPrecio(esEdicion: Boolean): Double {
        var precio: Double
        val msg: String = if (!esEdicion) "Introduce precio del vehiculo (5.000 - 400.000) -> " else "Introduce nuevo precio (5.000 - 400.000)-(Enter/vacio si no quieres modificarlo) -> "

        do {
            print(msg)
            precio = readln().toDoubleOrNull() ?: -1.0
            if (esEdicion && precio == -1.0) return precio
            if (precio < 5000.0 || precio > 400000f) println("Error - Precio no valido")
        } while (precio < 5000.0 || precio > 400000f)
        return precio
    }


    override fun pedirCilindrada(esEdicion: Boolean): Int {
        var cilindrada: Int
        val msg: String = if (!esEdicion) "Introduce la cilindrada: (300, 600, 1000) -> " else "Introduce nueva cilindrada (300, 600, 1000)-(Enter/vacio si no quieres modificarla) -> "

        do {
            print(msg)
            cilindrada = readln().toIntOrNull() ?: -1
            if (!Cilindrada.entries.any { it.valor == cilindrada }) print("Error - Cilindrada no valida. ")
        } while (!Cilindrada.entries.any { it.valor == cilindrada })
        return cilindrada
    }


}