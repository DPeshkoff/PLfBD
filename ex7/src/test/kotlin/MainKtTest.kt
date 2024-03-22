import org.junit.jupiter.api.Test
import org.lab7.excludeSubstringWithSameCharacters
import kotlin.test.assertEquals

class SubstringTest {

    @Test
    fun testExcludeSubstringWithSameCharacters() {
        val text = "abracadabraz"
        val result = excludeSubstringWithSameCharacters(text)
        assertEquals("z", result)
    }

    @Test
    fun testExcludeSubstringWithSameCharactersEmptyText() {
        val text = ""
        val result = excludeSubstringWithSameCharacters(text)
        assertEquals("", result)
    }

    @Test
    fun testExcludeSubstringWithSameCharactersNoSubstring() {
        val text = "kotlin"
        val result = excludeSubstringWithSameCharacters(text)
        assertEquals("kotlin", result)
    }
}