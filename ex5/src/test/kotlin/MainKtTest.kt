import org.junit.jupiter.api.Test
import org.lab7.sortWordsByVowelProportion
import kotlin.test.assertEquals

class TextProcessingTest {

    @Test
    fun testSortWordsByVowelProportion() {
        val text = "Hello world, how are you?"
        val sortedWords = sortWordsByVowelProportion(text)

        assertEquals(listOf("world,", "how", "Hello", "are", "you?", ), sortedWords)
    }

    @Test
    fun testSortWordsByVowelProportionSingleWord() {
        val text = "Kotlin"
        val sortedWords = sortWordsByVowelProportion(text)

        assertEquals(listOf("Kotlin"), sortedWords)
    }
}