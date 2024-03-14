import org.junit.jupiter.api.Test
import org.lab5.BoolMatrix
import kotlin.test.assertEquals

class BoolMatrixTest {

    @Test
    fun testLogicalOr() {
        val matrix1 = BoolMatrix(arrayOf(booleanArrayOf(true, false), booleanArrayOf(false, true)))
        val matrix2 = BoolMatrix(arrayOf(booleanArrayOf(false, true), booleanArrayOf(true, false)))

        val expectedMatrix = BoolMatrix(arrayOf(booleanArrayOf(true, true), booleanArrayOf(true, true)))
        assertEquals(expectedMatrix.toString(), matrix1.logicalOr(matrix2).toString())
    }

    @Test
    fun testLogicalAnd() {
        val matrix1 = BoolMatrix(arrayOf(booleanArrayOf(true, false), booleanArrayOf(false, true)))
        val matrix2 = BoolMatrix(arrayOf(booleanArrayOf(false, true), booleanArrayOf(true, false)))

        val expectedMatrix = BoolMatrix(arrayOf(booleanArrayOf(false, false), booleanArrayOf(false, false)))
        assertEquals(expectedMatrix.toString(), matrix1.logicalAnd(matrix2).toString())
    }

    @Test
    fun testInvert() {
        val matrix = BoolMatrix(arrayOf(booleanArrayOf(true, false), booleanArrayOf(false, true)))

        val expectedMatrix = BoolMatrix(arrayOf(booleanArrayOf(false, true), booleanArrayOf(true, false)))
        assertEquals(expectedMatrix.toString(), matrix.invert().toString())
    }

    @Test
    fun testCountOnes() {
        val matrix = BoolMatrix(arrayOf(booleanArrayOf(true, false, true), booleanArrayOf(true, true, false)))

        assertEquals(4, matrix.countOnes())
    }

    @Test
    fun testSortRowsLexicographically() {
        val matrix = BoolMatrix(arrayOf(booleanArrayOf(true, false), booleanArrayOf(false, true), booleanArrayOf(true, true)))

        val expectedMatrix = BoolMatrix(arrayOf(booleanArrayOf(false, true), booleanArrayOf(true, false), booleanArrayOf(true, true)))
        assertEquals(expectedMatrix.toString(), matrix.sortRowsLexicographically().toString())
    }
}