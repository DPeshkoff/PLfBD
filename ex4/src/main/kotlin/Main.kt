package org.lab3

/**
 * Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
 * 1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа. Создать массив объектов. Вывести: a) список студентов заданного факультета; b) списки студентов для каждого факультета и курса; c) список студентов, родившихся после заданного года; d) список учебной группы.
 */
class Student(
    val id: Int,
    val lastName: String,
    val firstName: String,
    val patronymic: String,
    val dateOfBirth: String,
    val address: String,
    val phone: String,
    val faculty: String,
    val course: Int,
    val group: String,
    var tip: Double
) {

    fun setT(tipAmount: Double) {
        tip = tipAmount
    }

    fun getT(): Double {
        return tip
    }

    override fun toString(): String {
        return "Student(id=$id, lastName='$lastName', firstName='$firstName', faculty='$faculty', course=$course, group='$group', tip=$tip)"
    }

    companion object {
        fun createMassiveObjects(): List<Student> {
            val students = mutableListOf<Student>()
            for (i in 1..100) {
                students.add(
                    Student(
                        i, "Doe", "John", "Smith",
                        "01/01/2000", "123 Main St",
                        "123-456-7890", "Engineering", 1, "A",
                        i * 10.0
                    )
                )
            }
            return students
        }

        fun studentsByFaculty(students: List<Student>, faculty: String): List<Student> {
            return students.filter { it.faculty == faculty }
        }

        fun studentSupervisors(students: List<Student>) {
            val supervisorsByFaculty = students.groupBy { it.faculty }
            for ((faculty, students) in supervisorsByFaculty) {
                println("Supervisors for $faculty:")
                students.forEach { println("Student: ${it.firstName} ${it.lastName}") }
            }
        }
    }
}

fun main() {
    val students = Student.createMassiveObjects()

    // Selecting students of a given faculty
    val engineeringStudents = Student.studentsByFaculty(students, "Engineering")
    println("Students of Engineering faculty:")
    engineeringStudents.forEach { println(it.toString()) }

    // Printing student supervisors for each department and course
    Student.studentSupervisors(students)

    // Outputting all students to the console
    println("All Students:")
    students.forEach { println(it.toString()) }
}