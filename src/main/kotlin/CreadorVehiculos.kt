package org.practicatrim2


/*
interface CreadorVehiculo<T: Vehiculo> {
    fun crearvehiculo(): T
}


class CreadorVehiculoBase{
    fun solicitarDatosComunes(){
        val marca = solicitarDato(
            "Introduce la marca de la moto -> ",
            "No puede estar vacia",
            {it.isNotBlank()},
            {it}
        )

        val modelo = solicitarDato(
            "Introduce el modelo de la moto -> ",
            "No puede estar vacio",
            {it.isNotBlank()},
            {it}
        )

        val anio = solicitarDato(
            "Introduce el año de la moto (1970-2024) -> ",
            "El año debe estar en el rango (1970 - 2024)",
            {it.toInt() in 1970..2024},
            { it.toInt() }
        )

        val kilometros = solicitarDato(
            "Introduce los kilómetros de la moto (0 - 100.000) -> ",
            "Los kms deben estar en el rango (0 - 100.000)",
            { it.toInt() in 0..100000 },
            {it.toInt()}
        )

        val caballos = solicitarDato(
            "Introduce los caballos de la moto (30-215) -> ",
            "Deben ser entre 30-215",
            {it.toInt() in 30..215},
            { it.toInt() }
        )

        val precio = if (seVende) solicitarDato(
            "Introduce el precio de la moto (5.000 - 400.000) -> ",
            "El precio debe estar en el rango (5.000 - 400.000)",
            { it.toDouble() in 5000.0..400000.00 },
            {it.toDouble()}
        ) else null
    }
}


*/




    //fun crearVehiculo(tipoVehiculo: TipoVehiculo, seVende: Boolean = false): Vehiculo?{}


    //TODO REVISAR
    fun solicitarTipoVehiculo(): TipoVehiculo {
        println("¿Qué tipo de vehículo deseas crear? \n- 1. Coche\n- 2. Motocicleta")
        var opcion: Int?
        do {
            opcion = solicitarDato(
                "Selecciona una opción: ",
                "Opcion incorrecta, elije una de las disponibles",
                {it.toInt() in 1..2},
                { it.toInt()}
            )
        } while (opcion !in 1..2)
        return if (opcion == 1) TipoVehiculo.COCHE else TipoVehiculo.MOTO
    }









class CreadorVehiculos(private val gestorInventario: InventarioVehiculos) {

    companion object{
        private var idVehUnica = 10

        fun crearIdUnica(): Int{
            idVehUnica++
            return idVehUnica
        }
    }


// TODO QUIZAS CREAR FUNCIONES QUE SOLICITEN CADA PROPIEDAD

    fun crearCoche(seVende: Boolean = false){
        val marca = solicitarDato(
            "Introduce la marca del coche -> ",
            "No puede estar vacia",
            {it.isNotBlank()},
            {it}
        )

        val modelo = solicitarDato(
            "Introduce el modelo del coche -> ",
            "No puede estar vacio",
            {it.isNotBlank()},
            {it}
        )

        val anio = solicitarDato(
            "Introduce el año del coche (1970-2024) -> ",
            "El año debe estar en el rango (1970 - 2024)",
            {it.toInt() in 1970..2024},
            { it.toInt() }
        )

        val kilometros = solicitarDato(
            "Introduce los kilómetros del coche (0 - 100.000) -> ",
            "Los kms deben estar en el rango (0 - 100.000)",
            { it.toInt() in 0..100000 },
            {it.toInt()}
        )

        val caballos = solicitarDato(
            "Introduce los caballos del coche (30-215) -> ",
            "Deben ser entre 30-215",
            {it.toInt() in 30..215},
            { it.toInt() }
        )

        val precio = if (seVende) solicitarDato(
            "Introduce el precio del coche (5.000 - 400.000) -> ",
            "El precio debe estar en el rango (5.000 - 400.000)",
            { it.toDouble() in 5000.0..400000.00 },
            {it.toDouble()}
        ) else null


        val coche = Coche(crearIdUnica(), marca, modelo, anio, kilometros, caballos, precio, seVende = seVende)

        gestorInventario.agregar(coche)
    }


    fun crearMoto(seVende: Boolean = false){
        val marca = solicitarDato(
            "Introduce la marca de la moto -> ",
            "No puede estar vacia",
            {it.isNotBlank()},
            {it}
        )

        val modelo = solicitarDato(
            "Introduce el modelo de la moto -> ",
            "No puede estar vacio",
            {it.isNotBlank()},
            {it}
        )

        val anio = solicitarDato(
            "Introduce el año de la moto (1970-2024) -> ",
            "El año debe estar en el rango (1970 - 2024)",
            {it.toInt() in 1970..2024},
            { it.toInt() }
        )

        val kilometros = solicitarDato(
            "Introduce los kilómetros de la moto (0 - 100.000) -> ",
            "Los kms deben estar en el rango (0 - 100.000)",
            { it.toInt() in 0..100000 },
            {it.toInt()}
        )

        val caballos = solicitarDato(
            "Introduce los caballos de la moto (30-215) -> ",
            "Deben ser entre 30-215",
            {it.toInt() in 30..215},
            { it.toInt() }
        )

        val precio = if (seVende) solicitarDato(
            "Introduce el precio de la moto (5.000 - 400.000) -> ",
            "El precio debe estar en el rango (5.000 - 400.000)",
            { it.toDouble() in 5000.0..400000.00 },
            {it.toDouble()}
        ) else null

        val cilindrada = solicitarDato(
            "Introduce cilindrada de la moto (300, 600, 1000) -> ",
            "La clilindrada solo puede ser (300, 600, 1000)",
            { input -> input.toIntOrNull() in Cilindrada.entries.map { it.valor } },
            {it.toInt()})


        val moto = Motocicleta(crearIdUnica(), marca, modelo, anio, kilometros, caballos, precio, seVende = seVende, cilindrada)

        gestorInventario.agregar(moto)

    }
}

/**
 * Solicita al usuario un dato con un mensaje dado y realiza la validación del mismo.
 *
 * @param mensaje Mensaje que se muestra al usuario para solicitar el dato.
 * @param mensajeError Mensaje de error que se muestra al usuario en caso de que la entrada sea inválida.
 * @param validator Función de validación que verifica si la entrada del usuario es válida.
 * @param parser Función que convierte la entrada del usuario en el tipo de dato deseado.
 * @return El dato ingresado por el usuario, convertido al tipo especificado.
 * @throws IllegalArgumentException si la entrada es inválida o está vacía.
 */
fun <T> solicitarDato(
    mensaje: String,
    mensajeError: String,
    validator: (String) -> Boolean,
    parser: (String) -> T
): T {
    print(mensaje)
    while (true) {
        try {
            val input = readlnOrNull() ?: throw IllegalArgumentException("Entrada vacía")
            if (validator(input)) {
                return parser(input)
            } else {
                throw IllegalArgumentException(mensajeError)
            }
        } catch (e: NumberFormatException) {
            print("Error: Debes introducir valores numericos. Por favor, intenta de nuevo -> ")
        } catch (e: Exception) {
            print("Error: ${mensajeError}. Por favor, intenta de nuevo -> ")
        }
    }
}