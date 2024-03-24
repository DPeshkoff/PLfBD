package org.lab3

/**
 * 1. Система Факультатив. Преподаватель объявляет запись на Курс. Студент записывается на Курс, обучается и по окончании Преподаватель выставляет Оценку, которая сохраняется в Архиве. Студентов, Преподавателей и Курсов при обучении может быть несколько.
 */

data class Course(val courseName: String)

data class Student(val studentName: String)

data class Teacher(val teacherName: String)

data class Grade(val student: Student, val course: Course, val grade: String)

class Archive {
    private val grades = mutableListOf<Grade>()

    fun addGrade(grade: Grade) {
        grades.add(grade)
    }

    fun getGrades(): List<Grade> {
        return grades
    }
}

class CourseRegistrationSystem {
    private val students = mutableListOf<Student>()
    private val teachers = mutableListOf<Teacher>()
    private val courses = mutableListOf<Course>()
    internal val archive = Archive()

    fun registerStudent(student: Student) {
        students.add(student)
    }

    fun registerTeacher(teacher: Teacher) {
        teachers.add(teacher)
    }

    fun registerCourse(course: Course) {
        courses.add(course)
    }

    fun enrollStudentInCourse(student: Student, course: Course) {
        if (students.contains(student) && courses.contains(course)) {
            println("${student.studentName} enrolled in ${course.courseName}")
        } else {
            println("Error: Student or course not found")
        }
    }

    fun assignGrade(student: Student, course: Course, grade: String) {
        val gradeObj = Grade(student, course, grade)
        archive.addGrade(gradeObj)
    }
}

fun main() {
    val courseRegistrationSystem = CourseRegistrationSystem()

    val student1 = Student("Alice")
    val student2 = Student("Bob")
    courseRegistrationSystem.registerStudent(student1)
    courseRegistrationSystem.registerStudent(student2)

    val teacher1 = Teacher("Carol")
    courseRegistrationSystem.registerTeacher(teacher1)

    val course1 = Course("Mathematics")
    val course2 = Course("Science")
    courseRegistrationSystem.registerCourse(course1)
    courseRegistrationSystem.registerCourse(course2)

    courseRegistrationSystem.enrollStudentInCourse(student1, course1)
    courseRegistrationSystem.enrollStudentInCourse(student2, course2)

    courseRegistrationSystem.assignGrade(student1, course1, "A")
    courseRegistrationSystem.assignGrade(student2, course2, "B")

    val grades = courseRegistrationSystem.archive.getGrades()
    println("Grades in the archive:")
    grades.forEach { println("${it.student.studentName} - ${it.course.courseName}: ${it.grade}") }
}
