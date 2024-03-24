import org.junit.jupiter.api.Test
import org.lab5.selectAndStoreWords
import kotlin.test.assertEquals
import java.io.File

class SelectAndStoreWordsTest {

    @Test
    fun testSelectAndStoreWords() {
        val inputLines = listOf(
            "This is line 1",
            "Another line here",
            "One more line to test",
            "Last line for selection"
        )
        val m = 2
        val n = 3
        val outputDirectory = "src/test/resources/output"

        selectAndStoreWords(inputLines, m, n, outputDirectory)

        val outputFile = File("$outputDirectory/selected_words.txt")
        val selectedLines = outputFile.readLines()

        val expectedSelectedLines = listOf("line here", "to test", "for selection")

        assertEquals(expectedSelectedLines, selectedLines)

        // Clean up
        outputFile.delete()
        File(outputDirectory).delete()
    }
}