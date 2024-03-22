import org.junit.jupiter.api.Test
import org.lab7.findWordInversions
import kotlin.test.assertEquals

class TextProcessingTest {

    @Test
    fun testFindWordInversions() {
        val text = "level radar cat tac racecar stop pots deed deep"
        val wordInversions = findWordInversions(text)

        assertEquals(2, wordInversions.size)
        assertEquals(listOf("cat" to "tac", "stop" to "pots"), wordInversions)
    }

    @Test
    fun testFindWordInversionsNoPairs() {
        val text = "hello world kotlin programming language"
        val wordInversions = findWordInversions(text)

        assertEquals(0, wordInversions.size)
    }
}