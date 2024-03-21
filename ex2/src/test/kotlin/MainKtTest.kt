import org.junit.jupiter.api.Test
import org.lab7.replaceKthLetter
import kotlin.test.assertEquals

class TextProcessingTest {

    @Test
    fun testReplaceKthLetter() {
        val text = "Replace the kth letter in each word with the given symbol."
        val newText = replaceKthLetter(text, 5, '*')
        assertEquals("Repl*ce the kth lett*r in each word with the given symb*l.", newText)

        val newText2 = replaceKthLetter(text, 10, '#')
        assertEquals("Replace the kth letter in each word with the given symbol.", newText2)
    }
}