import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.practicatrim2.InventarioVehiculos

class InventarioVehiculosTest {

    @Test
    fun testAgregarVehiculo() {
        val inventario = InventarioVehiculos()

        // Crear un vehículo para agregar al inventario
        val vehiculo = Coche(100, TipoVehiculo.Coche, "Ford", "Fiesta", 2020, 5000, 100, "Nuevo")

        // Agregar el vehículo al inventario
        inventario.agregarVehiculo(vehiculo)

        // Verificar que el vehículo fue agregado correctamente
        assertEquals(vehiculo, inventario.listadoItems[100])
    }
}