import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.lab4.Book
import org.lab4.Directory
import org.lab4.Encyclopedia
import kotlin.test.assertEquals

class BookTest {

    @Test
    fun testDirectoryInheritance() {
        val directory = Directory("A111", "John Doe", "BMSTU Directory", 2022, "BMSTU Publishings", 10)
        assertTrue(directory is Book)
    }

    @Test
    fun testEncyclopediaInheritance() {
        val encyclopedia = Encyclopedia("E456", "Jane Smith", "Science Encyclopedia", 2024, "Science Books", 5)
        assertTrue(encyclopedia is Book)
    }

    @Test
    fun testDirectoryInfo() {
        val directory = Directory("A111", "John Doe", "BMSTU Directory", 2022, "BMSTU Publishings", 10)
        assertEquals("Directory - BMSTU Directory by John Doe", directory.getInfo())
    }

    @Test
    fun testEncyclopediaInfo() {
        val encyclopedia = Encyclopedia("E456", "Jane Smith", "Science Encyclopedia", 2024, "Science Books", 5)
        assertEquals("Encyclopedia - Science Encyclopedia by Jane Smith", encyclopedia.getInfo())
    }
}