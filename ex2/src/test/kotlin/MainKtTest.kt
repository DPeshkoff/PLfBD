import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.lab6.calculateResistance
import kotlin.test.assertEquals

class ResistanceCalculationTest {

    @Test
    fun testResistanceCalculation() {
        val currentList = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
        val voltageList = listOf(2.0, 4.0, 6.0, 8.0, 10.0)

        val calculatedResistance = calculateResistance(currentList, voltageList)
        val expectedResistance = 2.0

        assertEquals(expectedResistance, calculatedResistance, 0.01)
    }

    @Test
    fun testDifferentListSizes() {
        val currentList = listOf(1.0, 2.0, 3.0)
        val voltageList = listOf(2.0, 4.0, 6.0, 8.0)

        assertThrows(IllegalArgumentException::class.java) {
            calculateResistance(currentList, voltageList)
        }
    }
}