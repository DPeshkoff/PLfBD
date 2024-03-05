import org.junit.jupiter.api.Test
import org.lab3.Student
import kotlin.test.assertEquals

class StudentTest {

    @Test
    fun testStudentMethods() {
        val student = Student(
            id = 1,
            lastName = "Doe",
            firstName = "John",
            patronymic = "Smith",
            dateOfBirth = "01/01/2000",
            address = "123 Main St",
            phone = "123-456-7890",
            faculty = "Engineering",
            course = 1,
            group = "A",
            tip = 50.0
        )

        assertEquals(1, student.id)
        assertEquals("John", student.firstName)
        assertEquals("Smith", student.patronymic)
        assertEquals(50.0, student.getT())

        student.setT(100.0)
        assertEquals(100.0, student.getT())
    }
}