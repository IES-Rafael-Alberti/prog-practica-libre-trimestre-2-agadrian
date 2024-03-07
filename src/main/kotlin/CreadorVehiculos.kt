package org.practicatrim2

class CreadorVehiculos(private val entradaDatos: EntradaDatos) {

    companion object{
        private var idUnica = 0

        fun crearIdUnica(): Int{
            idUnica++
            return idUnica
        }
    }


    fun crearCoche(): Coche{
        val marca = entradaDatos.pedirMarca()
        val modelo = entradaDatos.pedirModelo()
        val anio = entradaDatos.pedirAnio()
        val kilometros = entradaDatos.pedirKilometros()
        val caballos = entradaDatos.pedirCaballos()
        val precio = entradaDatos.pedirPrecio()

        return Coche(crearIdUnica(), marca, modelo, anio, kilometros ,caballos, precio)
    }

    fun crearMoto(): Motocicleta{
        val marca = entradaDatos.pedirMarca()
        val modelo = entradaDatos.pedirModelo()
        val anio = entradaDatos.pedirAnio()
        val kilometros = entradaDatos.pedirKilometros()
        val caballos = entradaDatos.pedirCaballos()
        val precio = entradaDatos.pedirPrecio()
        val cilindrada = entradaDatos.pedirCilindrada()

        return Motocicleta(crearIdUnica(), marca, modelo, anio, kilometros ,caballos, precio, cilindrada )
    }
}