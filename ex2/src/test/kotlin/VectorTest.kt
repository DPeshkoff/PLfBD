import org.junit.jupiter.api.Test
import org.lab3.Vector
import kotlin.test.assertEquals

class VectorTest {

    @Test
    fun testVectorOperations() {
        var vector1 = Vector(3, doubleArrayOf(1.0, 2.0, 3.0))
        var vector2 = Vector(3, doubleArrayOf(2.0, 3.0, 4.0))

        val sum = vector1 + vector2
        assertEquals(Vector(3, doubleArrayOf(3.0, 5.0, 7.0)).getValues().toList(), sum.getValues().toList())

        val difference = vector1 - vector2
        assertEquals(Vector(3, doubleArrayOf(-1.0, -1.0, -1.0)).getValues().toList(), difference.getValues().toList())

        val product = vector1 * 2.0
        assertEquals(Vector(3, doubleArrayOf(2.0, 4.0, 6.0)).getValues().toList(), product.getValues().toList())

        val incremented = ++vector1
        assertEquals(Vector(3, doubleArrayOf(2.0, 3.0, 4.0)).getValues().toList(), incremented.getValues().toList())

        val decremented = --vector2
        assertEquals(Vector(3, doubleArrayOf(1.0, 2.0, 3.0)).getValues().toList(), decremented.getValues().toList())

        assertEquals(20.0, vector1.scalarProduct(vector2), 0.01)
        assertEquals(5.38, vector1.length(), 0.01)
        assertEquals(6.98, vector1.angleBetween(vector2), 0.01)
    }
}