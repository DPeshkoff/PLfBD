package org.lab9

/**
 * Использовать ТОЛЬКО методы StreamAPI. Циклов и условий быть не должно.
 *
 * 10.  Задана коллекция чисел. С помощью метода reduce вернуть сумму чисел, которые > 10
 */

fun main() {
    val numbers = listOf(5, 15, 3, 20, 10, 8)

    val sumOfNumbersGreaterThanTen = numbers.stream()
        .filter { it > 10 }
        .reduce { acc, num -> acc + num }
        .orElse(0)

    println("Sum of numbers greater than 10: $sumOfNumbersGreaterThanTen")
}