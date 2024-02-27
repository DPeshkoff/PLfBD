import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun testCorrectPassword() {
        val input = "password\n"
        val inputStream = System.`in`
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        assertEquals("Enter the password: Password is correct!\n", outputStream.toString())

        System.setIn(inputStream)
    }

    @Test
    fun testIncorrectPassword() {
        val input = "IncorrectPassword\n"
        val inputStream = System.`in`
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        assertEquals("Enter the password: Incorrect password.\n", outputStream.toString())

        System.setIn(inputStream)
    }
}
