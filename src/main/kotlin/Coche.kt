package org.practicatrim2

class Coche (
    id: Int,
    marca: String,
    modelo: String,
    anio: Int,
    kilometros: Int,
    caballos: Int,
    precio: Double? = null,
    seVende: Boolean = false
) : Vehiculo(id, marca, modelo, anio, kilometros, caballos, precio, seVende){

companion object {
    fun crearCoche(gestionConsola: GestionConsola, enVenta: Boolean = false) : Coche {
        var coche : Coche?
        crearIdUnica()
        // TODO HACER EL DO WHILE PARA QUEHASTA QUE NO SE INTRODUZCA CORRECTAMENTE EL VEHICULO NO PARE DE PEDIR LOS DATOS. HACER LO MISMO EN MOTO
        do {
            try {
                coche = Coche(
                    idVehUnica,
                    gestionConsola.solicitarDato("Marca: ", { it }),
                    gestionConsola.solicitarDato("Modelo: ", { it }),
                    gestionConsola.solicitarDato("Año: ", { it.toInt() }),
                    gestionConsola.solicitarDato("Kms: ", { it.toInt() }),
                    gestionConsola.solicitarDato("Caballos: ", { it.toInt() }),
                    if (enVenta) gestionConsola.solicitarDato("Precio: ", { it.toDouble() }) else null,
                    enVenta
                )
            }
            catch () {

            }
        }



        return coche
    }
}

    //TODO CREAR EL TOSTRING O OTRA FUNCION QUE HAGA LO MISMO PERO CON OTRO FORMATO PARA AGREGAR UN GENERADOR DE INFORME O ALGO PARECIDO

}