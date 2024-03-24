import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.lab5.Vector
import kotlin.test.assertEquals


class VectorTest {

    @Test
    fun testVectorOperations() {
        var vector1 = Vector(3)
        vector1.values[0] = 1.0
        vector1.values[1] = 2.0
        vector1.values[2] = 3.0

        var vector2 = Vector(3)
        vector2.values[0] = 2.0
        vector2.values[1] = 3.0
        vector2.values[2] = 4.0

        val sum = vector1 + vector2
        assertArrayEquals(doubleArrayOf(3.0, 5.0, 7.0), sum.values)

        val difference = vector1 - vector2
        assertArrayEquals(doubleArrayOf(-1.0, -1.0, -1.0), difference.values)

        val product = vector1 * 2.0
        assertArrayEquals(doubleArrayOf(2.0, 4.0, 6.0), product.values)

        val incremented = ++vector1
        assertArrayEquals(doubleArrayOf(2.0, 3.0, 4.0), incremented.values)

        val decremented = --vector2
        assertArrayEquals(doubleArrayOf(1.0, 2.0, 3.0), decremented.values)

        assertEquals(20.0, vector1.scalarProduct(vector2), 0.01)
        assertEquals(5.38, vector1.length(), 0.01)
        assertEquals(0.12, vector1.angleBetween(vector2), 0.01)
    }

    @Test
    fun testVectorDimensionMismatch() {
        val vector1 = Vector(3)
        val vector2 = Vector(2)

        assertThrows(IllegalArgumentException::class.java) {
            val sum = vector1 + vector2
        }
    }

    @Test
    fun testVectorIndexOutOfBounds() {
        val vector = Vector(3)
        assertThrows(IndexOutOfBoundsException::class.java) {
            val value = vector[3]
        }
    }
}