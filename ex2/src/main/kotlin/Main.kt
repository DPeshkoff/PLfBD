package org.lab9

/**
 * Использовать ТОЛЬКО методы StreamAPI. Циклов и условий быть не должно.
 *
 * 1 Задана коллекция:
 * (Класс Student: имя и рейтинг)
 * Collection<Student> students = Arrays.asList(
 * new Student("Ivan", 40),
 * new Student("Petr", 60),
 * new Student("Olga", 70)
 * );
 * Вернуть средний балл.
 */

data class Student(val name: String, val rating: Int)

fun main() {
    val students = listOf(
        Student("Ivan", 40),
        Student("Petr", 60),
        Student("Olga", 70)
    )

    val averageRating = students.stream()
        .mapToInt { it.rating }
        .average()
        .orElse(0.0)

    println("Average Rating: $averageRating")
}