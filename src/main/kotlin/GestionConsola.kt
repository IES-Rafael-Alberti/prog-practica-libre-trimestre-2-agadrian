package org.practicatrim2

import java.util.*

class GestionConsola {


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

    inline fun <reified T> obtenerValorPredeterminado(): T {
        return when (T::class) {
            Int::class -> -1 as T
            String::class -> "" as T
            Double::class -> -1.0 as T
            else -> throw IllegalArgumentException("No se puede asignar un valor predeterminado para este tipo")
        }
    }


}


