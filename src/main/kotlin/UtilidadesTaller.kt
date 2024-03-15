package org.practicatrim2
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
import java.time.Month


/**
 * Interfaz para gestionar las facturas relacionadas con reparaciones de vehículos y piezas utilizadas.
 */
interface GestorFacturas{
    fun generarFactura(vehiculo: Vehiculo, piezasUtilizadas: Map<Pieza, Int>, costoTotal: Double): Factura
    fun mostrarFacturas()
    fun calcularCostoPiezas(piezasUsadas: Map<Pieza, Int>): Double
    val listaFacturas: MutableList<Factura>
}


/**
 * Interfaz para realizar análisis de ventas basados en las facturas generadas.
 */
interface AnalisisVentas: GestorFacturas {
    fun obtenerPreciosEnMes(facturas: List<Factura>, mes: Month): DoubleArray
    fun calcularEstadisticas(precios: DoubleArray): DescriptiveStatistics
    fun imprimirAnalisisReparaciones()
}


/**
 * Clase que proporciona utilidades relacionadas con el análisis de ventas en un taller.
 */
class UtilidadesTaller:AnalisisVentas {
    override val listaFacturas = mutableListOf<Factura>()


    /**
     * Genera una factura para una reparación específica.
     * @param vehiculo El vehículo reparado.
     * @param piezasUtilizadas Un mapa que contiene las piezas utilizadas en la reparación y la cantidad de cada una.
     * @param costoTotal El costo total de la reparación.
     * @return La factura generada para la reparación.
     */
    override fun generarFactura(vehiculo: Vehiculo, piezasUtilizadas: Map<Pieza, Int>, costoTotal: Double): Factura {
        return Factura(Factura.generarID(), vehiculo, piezasUtilizadas, costoTotal)
    }


    /**
     * Muestra todas las facturas generadas hasta el momento. Si no existen muestra un mesaje de aviso.
     */
    override fun mostrarFacturas() {
        if (listaFacturas.isNotEmpty()){
            GestionConsola.imprimirTexto("Listado de todas las facturas:\n${GestionConsola.tituloFacturas}\n${"=".repeat(GestionConsola.tituloFacturas.length)}")

            listaFacturas.forEach{ GestionConsola.imprimirTexto(it.toString())}
        }else {
            GestionConsola.imprimirTexto("No hay facturas disponibles")
        }
    }


    /**
     * Calcula el costo total de las piezas utilizadas en una reparación basándose en las piezas y las cantidades utilizadas.
     * @param piezasUsadas Un mapa que contiene las piezas utilizadas en la reparación y la cantidad de cada una.
     * @return El costo total de las piezas utilizadas en la reparación.
     */
    override fun calcularCostoPiezas(piezasUsadas: Map<Pieza, Int>): Double{
        var costo = 0.0
        for ((pieza, cantidad) in piezasUsadas) {
            costo += pieza.precio * cantidad
        }
        return costo
    }


    /**
     * Obtiene los precios totales de las facturas generadas en un mes específico.
     * @param facturas La lista de facturas generadas.
     * @param mes El mes para el cual se desea obtener los precios.
     * @return Un arreglo de precios totales de las facturas generadas en el mes especificado.
     */
    override fun obtenerPreciosEnMes(facturas: List<Factura>, mes: Month): DoubleArray {
        return facturas.filter { it.fechaHora.month == mes }.map { it.costoTotal }.toDoubleArray()
    }


    /**
     * Calcula estadísticas descriptivas sobre los precios de las facturas.
     * @param precios Los precios de las facturas sobre los cuales se calcularán las estadísticas.
     * @return Estadísticas descriptivas sobre los precios de las facturas.
     */
    override fun calcularEstadisticas(precios: DoubleArray): DescriptiveStatistics {
        return DescriptiveStatistics(precios)
    }


    /**
     * Imprime un análisis de las ventas realizadas, mostrando estadísticas sobre los precios de las facturas.
     */
    override fun imprimirAnalisisReparaciones() {
        val meses = listaFacturas.map { it.fechaHora.month }.distinct()
        if (meses.isNotEmpty()){
            meses.forEach{
                mes -> val precioMes = obtenerPreciosEnMes(listaFacturas, mes)
                val estadisiticas = calcularEstadisticas(precioMes)
                mostrarAnalisisVentas(mes, precioMes, estadisiticas)
            }
        }else{
            GestionConsola.imprimirTexto("No hay facturas disponibles")
        }
    }


    /**
     * Método privado para mostrar el análisis de ventas para un mes específico.
     * @param mes El mes para el cual se realiza el análisis.
     * @param precios Los precios totales de las facturas generadas en el mes.
     * @param stats Las estadísticas descriptivas calculadas sobre los precios.
     */
    private fun mostrarAnalisisVentas(mes: Month, precios: DoubleArray, stats: DescriptiveStatistics){
        GestionConsola.imprimirTexto("\nAnálisis de ventas para el mes ${mes.value.toString().capitalizar()}:")
        GestionConsola.imprimirTexto("Total de ventas: ${precios.sum()}€")
        GestionConsola.imprimirTexto("Media de precios: ${stats.mean}")
        GestionConsola.imprimirTexto("Desviación estándar de precios: ${String.format("%.2f",stats.standardDeviation)}")
        GestionConsola.imprimirTexto("Precio mínimo: ${stats.min}€")
        GestionConsola.imprimirTexto("Precio máximo: ${stats.max}€")
        GestionConsola.imprimirTexto("")
    }
}