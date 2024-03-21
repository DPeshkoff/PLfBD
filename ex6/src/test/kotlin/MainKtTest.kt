import org.junit.jupiter.api.Test
import org.lab7.findLongestWordChain
import kotlin.test.assertEquals

class WordChainTest {

    @Test
    fun testFindWordChain() {
        val text = "apple elephant tiger rabbit dog goat"
        val wordChain = findLongestWordChain(text)

        assertEquals(listOf("apple", "elephant", "tiger", "rabbit"), wordChain)
    }

    @Test
    fun testFindWordChainNoChain() {
        val text = "apple elephant tiger rabbit dog"
        val wordChain = findLongestWordChain(text)

        assertEquals(listOf("apple", "elephant", "tiger", "rabbit"), wordChain)
    }

    @Test
    fun testFindWordChainSingleWord() {
        val text = "kotlin"
        val wordChain = findLongestWordChain(text)

        assertEquals(listOf("kotlin"), wordChain)
    }
}