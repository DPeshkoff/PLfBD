package org.lab9

/**
 * Использовать ТОЛЬКО методы StreamAPI. Циклов и условий быть не должно.
 *
 * 10 Задана коллекция:
 * (Класс Student: имя и рейтинг)
 * Collection<Student> students = Arrays.asList(
 * new Student("Ivan", 40),
 * new Student("Petr", 60),
 * new Student("Olga", 70)
 * );
 * Вернуть список студентов имя которых начинается на Pи рейтинг находится в интервале 40-60.
 */

data class Student(val name: String, val rating: Int)

fun main() {
    val students = listOf(
        Student("Ivan", 40),
        Student("Petr", 60),
        Student("Olga", 70)
    )

    val filteredStudents = students.stream()
        .filter { it.name.startsWith("P") }
        .filter { it.rating in 40..60 }
        .toList()

    println(filteredStudents)
}