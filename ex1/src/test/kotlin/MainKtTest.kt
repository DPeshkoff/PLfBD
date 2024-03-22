import org.junit.jupiter.api.Test
import org.lab9.Student
import kotlin.test.assertEquals

class StudentTest {

    @Test
    fun testFilterStudents() {
        val students = listOf(
            Student("Ivan", 40),
            Student("Petr", 60),
            Student("Olga", 70)
        )

        val filteredStudents = students.stream()
            .filter { it.name.startsWith("P") }
            .filter { it.rating in 40..60 }
            .toList()

        val expectedStudents = listOf(Student("Petr", 60))
        assertEquals(expectedStudents, filteredStudents)
    }
}