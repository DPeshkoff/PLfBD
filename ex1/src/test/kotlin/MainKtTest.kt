import org.junit.jupiter.api.Test
import org.lab6.IntSet
import kotlin.test.assertEquals

class IntSetTest {

    @Test
    fun testIntersection() {
        val set1 = IntSet(setOf(1, 2, 3, 4, 5))
        val set2 = setOf(3, 4, 5, 6, 7)

        val intersectionResult = set1.intersection(set2)
        val expectedIntersection = setOf(3, 4, 5)

        assertEquals(expectedIntersection, intersectionResult)
    }

    @Test
    fun testUnion() {
        val set1 = IntSet(setOf(1, 2, 3, 4, 5))
        val set2 = setOf(3, 4, 5, 6, 7)

        val unionResult = set1.union(set2)
        val expectedUnion = setOf(1, 2, 3, 4, 5, 6, 7)

        assertEquals(expectedUnion, unionResult)
    }
}