import org.junit.jupiter.api.Test
import org.lab7.sortWordsByLetterCount
import kotlin.test.assertEquals

class WordSortTest {

    @Test
    fun testSortWordsByLetterCount() {
        val text = "apple elephant tiger rabbit dog goat"
        val letter = 'e'
        val sortedWords = sortWordsByLetterCount(text, letter)
        assertEquals(listOf("dog", "goat", "rabbit", "apple", "tiger", "elephant"), sortedWords)
    }

    @Test
    fun testSortWordsByLetterCountNoLetterInWords() {
        val text = "kotlin is awesome"
        val letter = 'z'
        val sortedWords = sortWordsByLetterCount(text, letter)
        assertEquals(listOf("awesome", "is", "kotlin"), sortedWords)
    }
}