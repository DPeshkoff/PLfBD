import org.junit.jupiter.api.Test
import org.lab3.Course
import org.lab3.CourseRegistrationSystem
import org.lab3.Student
import kotlin.test.assertEquals

class CourseRegistrationSystemTest {

    @Test
    fun testEnrollStudentInCourse() {
        val courseRegistrationSystem = CourseRegistrationSystem()
        val student = Student("Alice")
        val course = Course("Mathematics")

        courseRegistrationSystem.registerStudent(student)
        courseRegistrationSystem.registerCourse(course)

        courseRegistrationSystem.enrollStudentInCourse(student, course)
    }

    @Test
    fun testAssignGrade() {
        val courseRegistrationSystem = CourseRegistrationSystem()
        val student = Student("Bob")
        val course = Course("Science")

        courseRegistrationSystem.registerStudent(student)
        courseRegistrationSystem.registerCourse(course)

        courseRegistrationSystem.assignGrade(student, course, "B")

        val grades = courseRegistrationSystem.archive.getGrades()
        val grade = grades.find { it.student == student && it.course == course }
        assertEquals("B", grade?.grade)
    }
}