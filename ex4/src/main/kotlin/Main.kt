package org.lab9

/**
 * Использовать ТОЛЬКО методы StreamAPI. Циклов и условий быть не должно.
 *
 * 11.  Задана коллекция:
 * (КлассPeople: имяивозраст, пол (enum))
 * Collection<People> peoples = Arrays.asList(
 * new People("Ivan", 16, Sex.MAN),
 * new People("Petr", 23, Sex.MAN),
 * new People("Maria", 42, Sex.WOMAN)
 * );
 * Найти самого старшего человека мужского пола.
 */

data class People(val name: String, val age: Int, val gender: Sex)

enum class Sex {
    MAN, WOMAN
}

fun main() {
    val peoples = listOf(
        People("Ivan", 16, Sex.MAN),
        People("Petr", 23, Sex.MAN),
        People("Maria", 42, Sex.WOMAN)
    )

    val oldestMale = peoples.stream()
        .filter { it.gender == Sex.MAN }
        .max(compareBy { it.age })
        .orElse(null)

    println("Oldest male person: $oldestMale")
}