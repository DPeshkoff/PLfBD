import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.lab4.Comedy
import org.lab4.DomesticFilm
import org.lab4.Film
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class ComedyTest {

    @Test
    fun testComedyInheritance() {
        val comedy = Comedy("Russia")
        assertTrue(comedy is DomesticFilm)
        assertTrue(comedy is Film)
    }

    @Test
    fun testComedyCountry() {
        val comedy = Comedy("Russia")
        assertEquals("Russia", comedy.country)
    }

    @Test
    fun testPlayComedy() {
        val comedy = Comedy("Russia")

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        comedy.play()

        assertEquals("Playing a comedy film from Russia\n", outputStream.toString())
    }
}