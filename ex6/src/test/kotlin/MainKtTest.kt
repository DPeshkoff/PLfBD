import org.junit.jupiter.api.Test
import org.lab5.findAndRemoveSubstring
import kotlin.test.assertEquals

class SubstringRemovalTest {

    @Test
    fun testFindAndRemoveSubstring() {
        val input = listOf("hello world", "kotlin is awesome", "substring removal test")
        val substring = "l"

        val output = findAndRemoveSubstring(input, substring)

        val expectedOutput = listOf("heo word", "kotin is awesome", "substring remova test")

        assertEquals(expectedOutput, output)
    }
}