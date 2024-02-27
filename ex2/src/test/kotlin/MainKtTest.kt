import org.junit.jupiter.api.Test
import org.lab2.findShortestAndLongestLines
import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun testFindShortestAndLongestLines() {
        val lines = listOf("Hello", "This is a test", "Short line", "Another long line")

        val shortestLineControl = "Hello"
        val longestLineControl = "Another long line"

        val (shortestLine, longestLine) = findShortestAndLongestLines(lines)

        assertEquals(Pair(shortestLineControl, shortestLineControl.length), shortestLine)
        assertEquals(Pair(longestLineControl, longestLineControl.length), longestLine)
    }
}
