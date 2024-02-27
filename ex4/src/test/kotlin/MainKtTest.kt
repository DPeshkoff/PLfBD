import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.lab2.sortMatrix

class MainKtTest {

    @Test
    fun testSortMatrix() {
        val matrix = arrayOf(arrayOf(9, 8, 7), arrayOf(6, 5, 4), arrayOf(3, 2, 1))
        val k = 2
        val expectedMatrix = arrayOf(arrayOf(3, 2, 1), arrayOf(6, 5, 4), arrayOf(9, 8, 7))

        val sortedMatrix = sortMatrix(matrix, k)
        assertArrayEquals(expectedMatrix, sortedMatrix)
    }

    @Test
    fun testSortMatrixWithSingleRow() {
        val matrix = arrayOf(arrayOf(2, 1, 3))
        val k = 1
        val expectedMatrix = arrayOf(arrayOf(2, 1, 3))

        val sortedMatrix = sortMatrix(matrix, k)
        assertArrayEquals(expectedMatrix, sortedMatrix)
    }

    @Test
    fun testSortMatrixWithEmptyMatrix() {
        val matrix = emptyArray<Array<Int>>()
        val k = 1
        val expectedMatrix = emptyArray<Array<Int>>()

        val sortedMatrix = sortMatrix(matrix, k)
        assertArrayEquals(expectedMatrix, sortedMatrix)
    }
}