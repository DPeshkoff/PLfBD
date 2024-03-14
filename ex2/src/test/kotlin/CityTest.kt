import org.junit.jupiter.api.Test
import org.lab4.City
import kotlin.test.assertEquals

class CityTest {

    @Test
    fun testAddAvenue() {
        val city = City("Metropolis")
        val avenue1 = City.Avenue("Broadway")
        val avenue2 = City.Avenue("Park Avenue")

        city.addAvenue(avenue1)
        city.addAvenue(avenue2)

        assertEquals(listOf(avenue1, avenue2), city.avenues)
    }

    @Test
    fun testAddStreet() {
        val city = City("Metropolis")
        val street1 = City.Street("Main Street")
        val street2 = City.Street("Elm Street")

        city.addStreet(street1)
        city.addStreet(street2)

        assertEquals(listOf(street1, street2), city.streets)
    }

    @Test
    fun testAddSquare() {
        val city = City("Metropolis")
        val square1 = City.Square("Central Square")
        val square2 = City.Square("Town Square")

        city.addSquare(square1)
        city.addSquare(square2)

        assertEquals(listOf(square1, square2), city.squares)
    }
}