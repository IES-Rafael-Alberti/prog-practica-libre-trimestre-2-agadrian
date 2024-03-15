package org.practicatrim2
import java.util.*

/**
 * Extensión de función para capitalizar la primera letra de una cadena.
 * @return La cadena con la primera letra capitalizada.
 */
fun String.capitalizar(): String {
    return this.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}


/**
 * Función principal que inicia el programa.
 */
fun main() {
    val menu = Menu()
    menu.menuPrincipal()

}