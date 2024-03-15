package org.practicatrim2
import org.junit.Test
import org.junit.Assert.assertEquals
//import org.practicatrim2.Pieza
//import org.practicatrim2.TipoVehiculo
//import org.practicatrim2.UtilidadesTaller
import kotlin.random.Random


/**
 * Prueba unitaria para la función `calcularCostoPiezas` de la clase `UtilidadesTaller`.
 */
class UtilidadesTallerTest {

    /**
     * Prueba que verifica si la función `calcularCostoPiezas` retorna el costo correcto
     * al proporcionar un mapa de piezas utilizadas.
     */
    @Test
    fun calcularCostoPiezas_deberiaRetornarCostoCorrecto() {
        // Preparar los datos de prueba
        val utilidadesTaller = UtilidadesTaller()


        val piezasUtilizadas = mutableMapOf<Pieza, Int>()

        for (i in 1..30) {
            val cantidad = (1..5).random()
            val pieza = Pieza(
                i,
                "Pieza $i",
                "Descripcion de la pieza $i",
                cantidad,
                Random.nextDouble(5.0, 100.0),
                TipoVehiculo.entries.random()
            )
            piezasUtilizadas[pieza] = cantidad
        }

        // Las muestro para ver el contenido creado aleatorio (podria omitirse)
        piezasUtilizadas.forEach{ println(it) }

        // Ejecutar la prueba
        val costoTotal = utilidadesTaller.calcularCostoPiezas(piezasUtilizadas)

        // Verificar el resultado esperado. Margen de 0.01 para los numeros flotantes
        val costoEsperado = piezasUtilizadas.entries.sumOf { (pieza, cantidad) -> pieza.precio * cantidad }
        assertEquals(costoEsperado, costoTotal, 0.01)
    }
}