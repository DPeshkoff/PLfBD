package org.lab3

/**
 * 10
 * Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
 * Числа в порядке убывания частоты встречаемости чисел.
 */
fun main() {
    println("Enter integers separated by spaces:")
    val input = readLine()
    val numbers = input?.split(" ")?.map { it.toInt() } ?: emptyList()

    val frequencyMap = numbers.groupBy { it }
        .mapValues { it.value.size }
        .toList()
        .sortedByDescending { it.second }

    println("Numbers in descending order of frequency of occurrence:")
    frequencyMap.forEach { println("${it.first} - ${it.second} times") }
}
