import org.junit.jupiter.api.Test
import org.lab3.main
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals


class MainKtTest {

    @Test
    fun testFrequencyOrder() {
        val input = "1 2 2 3 3 3 4 4 4 4"
        val inputStream = System.`in`
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        val expectedOutput = "Enter integers separated by spaces:\nNumbers in descending order of frequency of occurrence:\n4 - 4 times\n3 - 3 times\n2 - 2 times\n1 - 1 times\n"
        assertEquals(expectedOutput, outputStream.toString())

        System.setIn(inputStream)
    }
}