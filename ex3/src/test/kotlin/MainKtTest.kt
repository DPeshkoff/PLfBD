import org.junit.jupiter.api.Test
import org.lab6.Car
import org.lab6.countOvertakings
import kotlin.test.assertEquals

class OvertakingCountTest {

    @Test
    fun testOvertakingCount() {
        val cars = listOf(
            Car(1, 3),
            Car(3, 2),
            Car(5, 1),
            Car(7, 4)
        )

        val overtakings = countOvertakings(cars)
        val expectedOvertakings = 3

        assertEquals(expectedOvertakings, overtakings)
    }
}