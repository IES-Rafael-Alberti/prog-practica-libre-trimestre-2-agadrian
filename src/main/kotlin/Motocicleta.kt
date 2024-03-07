package org.practicatrim2

class Motocicleta(
    id: Int,
    marca: String,
    modelo: String,
    anio: Int,
    kilometros: Int,
    caballos: Int,
    precio: Double,
    private var cilindrada: Int,

) : Vehiculo(id, marca, modelo, anio, kilometros, caballos, precio){



    fun editarCilindrada(nuevaCilindrada: Int) {
        cilindrada = nuevaCilindrada
    }
}


enum class Cilindrada(val valor: Int){
    CC300(300),
    CC600(600),
    CC1000(1000)
}