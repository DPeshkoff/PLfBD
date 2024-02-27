package org.example

/**
 * #5
 * Создать программу ввода целых чисел как аргументов командной строки, подсчета их суммы (произведения) и вывода результата на консоль
 */
fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Please provide integers as command line arguments.")
        return
    }

    val numbers = args.map { it.toInt() }
    val sum = numbers.sum()
    val product = numbers.reduce { acc, i -> acc * i }

    println("Sum: $sum")
    println("Product: $product")
}
