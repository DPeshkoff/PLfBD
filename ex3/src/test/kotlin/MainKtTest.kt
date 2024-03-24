import org.example.findMaxElements
import org.example.removeRowsAndColumns
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun testFindMaxElements() {
        val matrix = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9))
        assertEquals(setOf(8), findMaxElements(matrix))
    }

    @Test
    fun testRemoveRowsAndColumns() {
        val matrix = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9))
        val maxElements = setOf(8)

        val expectedMatrix = arrayOf(arrayOf(1, 2), arrayOf(4, 5))
        val resultMatrix = removeRowsAndColumns(matrix, maxElements)
        assertEquals(expectedMatrix[0][0], resultMatrix[0][0])
        assertEquals(expectedMatrix[0][1], resultMatrix[0][1])
        assertEquals(expectedMatrix[1][0], resultMatrix[1][0])
        assertEquals(expectedMatrix[1][1], resultMatrix[1][1])
    }
}