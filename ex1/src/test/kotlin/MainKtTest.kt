import org.junit.jupiter.api.Test
import org.lab2.main
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.*
import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun testFirstInterval() {
        val input = "-10001\n"
        val inputStream = System.`in`
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        assertEquals("Enter a value:\nThe value -10001 belongs to the interval: Value does not belong to any specified interval.\nDeveloper: DPeshkoff\nTask received: ${Date()}\n" +
                "Task submitted: ${Date()}\n", outputStream.toString())

        System.setIn(inputStream)
    }

    @Test
    fun testSecondInterval() {
        val input = "-1000\n"
        val inputStream = System.`in`
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        assertEquals("Enter a value:\nThe value -1000 belongs to the interval: (-10k, 5]\nDeveloper: DPeshkoff\nTask received: ${Date()}\n" +
                "Task submitted: ${Date()}\n", outputStream.toString())

        System.setIn(inputStream)
    }

    @Test
    fun testThirdInterval() {
        val input = "10\n"
        val inputStream = System.`in`
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        assertEquals("Enter a value:\nThe value 10 belongs to the interval: [0, 10]\nDeveloper: DPeshkoff\nTask received: ${Date()}\n" +
                "Task submitted: ${Date()}\n", outputStream.toString())

        System.setIn(inputStream)
    }

    @Test
    fun testFourthInterval() {
        val input = "15\n"
        val inputStream = System.`in`
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        assertEquals("Enter a value:\nThe value 15 belongs to the interval: [5, 15]\nDeveloper: DPeshkoff\nTask received: ${Date()}\n" +
                "Task submitted: ${Date()}\n", outputStream.toString())

        System.setIn(inputStream)
    }

    @Test
    fun testFifthInterval() {
        val input = "10000\n"
        val inputStream = System.`in`
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        assertEquals("Enter a value:\nThe value 10000 belongs to the interval: [10, 10k]\nDeveloper: DPeshkoff\nTask received: ${Date()}\n" +
                "Task submitted: ${Date()}\n", outputStream.toString())

        System.setIn(inputStream)
    }

    @Test
    fun testSixthInterval() {
        val input = "10001\n"
        val inputStream = System.`in`
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        assertEquals("Enter a value:\nThe value 10001 belongs to the interval: Value does not belong to any specified interval.\nDeveloper: DPeshkoff\nTask received: ${Date()}\n" +
                "Task submitted: ${Date()}\n", outputStream.toString())

        System.setIn(inputStream)
    }
}
