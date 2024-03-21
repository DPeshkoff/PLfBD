import org.junit.jupiter.api.Test
import org.lab7.findLongestNonLetterSubstring
import kotlin.test.assertEquals

class TextProcessingTest {

    @Test
    fun testFindLongestNonLetterSubstring() {
        val text = "The 12345 brown fox jumps over the lazy dog!"
        val longestSubstring = findLongestNonLetterSubstring(text)
        assertEquals(" 12345 ", longestSubstring)

        val text2 = "No non-letter substring here."
        val longestSubstring2 = findLongestNonLetterSubstring(text2)
        assertEquals(" ", longestSubstring2)
    }
}