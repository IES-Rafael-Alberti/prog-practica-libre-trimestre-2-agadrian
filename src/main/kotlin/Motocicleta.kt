package org.practicatrim2

class Motocicleta(
    id: Int,
    marca: String,
    modelo: String,
    anio: Int,
    kilometros: Int,
    precio: Double,
    caballos: Int,
    cilindrada: Int,

) : Vehiculo(id, marca, modelo, anio, kilometros, caballos, precio){

    var cilindrada = cilindrada
        private set

    fun editarCilindrada(nuevaCilindrada: Int) {
        cilindrada = nuevaCilindrada
    }
}


enum class Cilindrada(val valor: Int){
    cc300(300),
    cc600(600),
    c1000(1000)
}