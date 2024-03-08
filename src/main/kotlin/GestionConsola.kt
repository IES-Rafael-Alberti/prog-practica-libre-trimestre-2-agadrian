package org.practicatrim2

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
    fun <T> solicitarDato(
        mensaje: String,
        //mensajeError: String,
        //validator: (String) -> Boolean,
        parser: (String) -> T,
        editar: Boolean = false
    ): T {
        print(mensaje)
        while (true) {
            try {
                val input = readln()
                if (editar && input.isBlank()) return parser(input)
                return parser(input)
            } catch (e: NumberFormatException) {
                print("Error: Debes introducir valores numericos. Por favor, intenta de nuevo -> ")
            } catch (e: Exception) {
                print("Error: ${"Error iyo"}. Por favor, intenta de nuevo -> ")
            }
        }
    }
}


