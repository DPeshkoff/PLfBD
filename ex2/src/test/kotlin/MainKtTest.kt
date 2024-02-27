import org.example.main
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun testSumAndProduct() {
        val args = arrayOf("2", "3", "4")
        val sum = 9
        val product = 24

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main(args)

        assertEquals("Sum: $sum\nProduct: $product\n", outputStream.toString())
    }

    @Test
    fun testNoArguments() {
        val args = emptyArray<String>()

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main(args)

        assertEquals("Please provide integers as command line arguments.\n", outputStream.toString())
    }
}