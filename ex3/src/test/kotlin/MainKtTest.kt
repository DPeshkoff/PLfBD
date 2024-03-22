import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberTest {

    @Test
    fun testSumOfNumbersGreaterThanTen() {
        val numbers = listOf(5, 15, 3, 20, 10, 8)

        val sumOfNumbersGreaterThanTen = numbers.stream()
            .filter { it > 10 }
            .reduce { acc, num -> acc + num }
            .orElse(0)

        assertEquals(35, sumOfNumbersGreaterThanTen)
    }
}