import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.lab3.BoolMatrix
import kotlin.test.assertEquals

class BoolMatrixTest {

    @Test
    fun testDisjunction() {
        val matrix1 = BoolMatrix(2, 2, arrayOf(booleanArrayOf(true, false), booleanArrayOf(false, true)))
        val matrix2 = BoolMatrix(2, 2, arrayOf(booleanArrayOf(false, true), booleanArrayOf(true, false)))
        val expectedMatrix = BoolMatrix(2, 2, arrayOf(booleanArrayOf(true, true), booleanArrayOf(true, true)))

        val result = matrix1.disjunction(matrix2)
        assertArrayEquals(expectedMatrix.returnMatrix(), result.returnMatrix())
    }

    @Test
    fun testMultiplication() {
        val matrix1 = BoolMatrix(2, 2, arrayOf(booleanArrayOf(true, false), booleanArrayOf(false, true)))
        val matrix2 = BoolMatrix(2, 2, arrayOf(booleanArrayOf(true, false), booleanArrayOf(false, true)))
        val expectedMatrix = BoolMatrix(2, 2, arrayOf(booleanArrayOf(true, false), booleanArrayOf(false, true)))

        val result = matrix1.multiplication(matrix2)
        assertArrayEquals(expectedMatrix.returnMatrix(), result.returnMatrix())
    }

    @Test
    fun testInversion() {
        val matrix = BoolMatrix(2, 2, arrayOf(booleanArrayOf(true, false), booleanArrayOf(false, true)))
        val expectedMatrix = BoolMatrix(2, 2, arrayOf(booleanArrayOf(false, true), booleanArrayOf(true, false)))

        val result = matrix.inversion()
        assertArrayEquals(expectedMatrix.returnMatrix(), result.returnMatrix())
    }

    @Test
    fun testCountTrue() {
        val matrix = BoolMatrix(2, 3, arrayOf(booleanArrayOf(true, false, true), booleanArrayOf(false, true, true)))
        val count = matrix.countTrue()
        assertEquals(4, count)
    }

    @Test
    fun testSortRowsLexicographically() {
        val matrix = BoolMatrix(3, 2, arrayOf(booleanArrayOf(true, false), booleanArrayOf(false, true), booleanArrayOf(true, true)))
        val expectedMatrix = BoolMatrix(3, 2, arrayOf(booleanArrayOf(false, true), booleanArrayOf(true, false), booleanArrayOf(true, true)))

        val result = matrix.sortRowsLexicographically()
        assertArrayEquals(expectedMatrix.returnMatrix(), result.returnMatrix())
    }
}