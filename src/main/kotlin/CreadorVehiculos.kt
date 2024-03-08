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










/*


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


*/
