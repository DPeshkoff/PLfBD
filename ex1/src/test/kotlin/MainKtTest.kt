import org.junit.jupiter.api.Test
import org.lab7.removeTextBetweenCharacters
import kotlin.test.assertEquals

class TextProcessingTest {

    @Test
    fun testRemoveTextBetweenCharacters() {
        val text = "This is (some) text with *words* to remove."
        val cleanedText1 = removeTextBetweenCharacters(text, '(', ')')
        assertEquals("This is  text with *words* to remove.", cleanedText1)

        val cleanedText2 = removeTextBetweenCharacters(text, '*', '*')
        assertEquals("This is (some) text with  to remove.", cleanedText2)
    }
}