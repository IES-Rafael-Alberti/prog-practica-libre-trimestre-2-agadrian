package org.practicatrim2

// TODO: AÑADIR FUNCION QUE IMPRIMA LO PASADO POR PARAMETRO

object GestionConsola {


    fun imprimirTexto(texto: String, lineaNueva:Boolean = true){
        if (lineaNueva) println(texto) else print(texto)
    }


    /**
     * Solicita una ID
     */
    fun preguntarId(): Int {
        return solicitarDato("Introduce ID -> ", {it.toInt()})
    }



    /**
     * Solicita un dato al usuario y lo convierte al tipo especificado utilizando un parser personalizado.
     * El parser toma una cadena de entrada y la convierte al tipo deseado.
     * Si se especifica el parámetro "editar" como verdadero y el usuario introduce una cadena vacía,
     * se devuelve un valor predeterminado para el tipo especificado, llamando a la funcion obtenerValorPredeterminado.
     * Esto implica que permita introducir valores vacios, para a la hora de editar un valor, poder comprobar que si esta vacio, el valor sea el mismo por ejemplo.
     *
     * Usa reified junto al parametro generico en la funcion inline, para poder conservar el tipo generico en tiempo de ejecucion, ya que si no, en kotlin los parametro de tipo generico se borran normalmente en tiempo de ejecucion. Esto permite realizar operacion que requieren del tipo del generico en tiempo de ejecucion.
     * Esto es beneficioso por ejemplo en este caso, que se usa con una lamda como parametro.
     *
     * @param mensaje El mensaje que se muestra al usuario para solicitar el dato.
     * @param parser La función que convierte la entrada de usuario (String) al tipo deseado (T).
     * @param editar Indica si se debe permitir al usuario editar el valor. Por defecto es falso.
     * @return El dato solicitado por el usuario, convertido al tipo deseado (T).
     */
    inline fun <reified T> solicitarDato(
        mensaje: String,
        parser: (String) -> T,
        editar: Boolean = false
    ): T {
        print(mensaje)
        while (true) {
            try {
                val input = readln()
                if (editar && input.isBlank()){
                    return obtenerValorPredeterminado()
                }
                return parser(input)
            } catch (e: NumberFormatException) {
                print("Error: Debes introducir valores numericos. Por favor, intenta de nuevo -> ")
            } catch (e: Exception) {
                print("Error desconocido - Por favor, intenta de nuevo -> ")
            }
        }
    }

    /**
     * Obtiene un valor predeterminado para el tipo especificado.
     * Los tipos compatibles son Int, String y Double.
     * Para otros tipos, se lanzará una IllegalArgumentException.
     *
     * Como en la anterior funcion, se usa reified para poder conservar el tipo generico en tiempo de ejecucion ,y verificar en este caso el valor que se le dara por defecto dependiendo del tipo que sea.
     * @return El valor predeterminado para el tipo especificado (T).
     * @throws IllegalArgumentException Si el tipo especificado no es compatible.
     */
    inline fun <reified T> obtenerValorPredeterminado(): T {
        return when (T::class) {
            Int::class -> -1 as T
            String::class -> "" as T
            Double::class -> -1.0 as T
            else -> throw IllegalArgumentException("No se puede asignar un valor predeterminado para este tipo")
        }
    }

    /**
     * Resumiendo, en este caso debo de hacer uso de reified en conjunto con inline para que me permita  acceder al tipo que es el generico en cada momento (y que no se borre en tiempo de ejecucion, como pasaria normalmente)
     */

}


