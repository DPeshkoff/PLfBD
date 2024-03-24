import org.junit.jupiter.api.Test
import org.lab6.NumberStorage
import kotlin.test.assertEquals

class NumberStorageTest {

    @Test
    fun testClosestNumber() {
        val numberStorage = NumberStorage()
        numberStorage.addNumber(5)
        numberStorage.addNumber(10)
        numberStorage.addNumber(15)

        val targetNumber = 12
        val closestNumber = numberStorage.findClosestNumber(targetNumber)

        assertEquals(10, closestNumber)
    }

    @Test
    fun testRemoveNumber() {
        val numberStorage = NumberStorage()
        numberStorage.addNumber(5)
        numberStorage.addNumber(10)
        numberStorage.addNumber(15)

        numberStorage.removeNumber(10)

        val targetNumber = 12
        val closestNumber = numberStorage.findClosestNumber(targetNumber)

        assertEquals(15, closestNumber)
    }
}