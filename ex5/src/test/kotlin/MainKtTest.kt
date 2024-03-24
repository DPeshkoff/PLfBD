import org.junit.jupiter.api.Test
import org.lab5.readMatrixFromFile
import org.lab5.rotateMatrixClockwise
import kotlin.test.assertEquals

class MatrixRotationTest {

    @Test
    fun testRotateMatrixClockwise() {
        val matrix = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9)
        )

        val rotatedMatrix = rotateMatrixClockwise(matrix)

        val expectedRotatedMatrix = listOf(
            listOf(7, 4, 1),
            listOf(8, 5, 2),
            listOf(9, 6, 3)
        )

        assertEquals(expectedRotatedMatrix, rotatedMatrix)
    }

    @Test
    fun testReadMatrixFromFile() {
        val filePath = "src/test/resources/test_matrix.txt"
        val matrix = readMatrixFromFile(filePath)

        val expectedMatrix = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9)
        )

        assertEquals(expectedMatrix, matrix)
    }
}