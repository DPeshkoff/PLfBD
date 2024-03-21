import org.junit.jupiter.api.Test
import org.lab9.Student
import kotlin.test.assertEquals

class StudentTest {

    @Test
    fun testCalculateGPA() {
        val students = listOf(
            Student("Ivan", 40),
            Student("Petr", 60),
            Student("Olga", 70)
        )

        val averageRating = students.stream()
            .mapToInt { it.rating }
            .average()
            .orElse(0.0)

        assertEquals(56.666666666666664, averageRating)
    }
}