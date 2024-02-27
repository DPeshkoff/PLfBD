package org.example

/**
 * Числа Фибоначчи: f0 = f1 = 1, f (n) = f (n–1) + f (n–2).
 */
fun main() {
    println("Enter the number of integers:")
    val n = readlnOrNull()?.toInt() ?: 0

    val numbers = IntArray(n) { 0 }
    println("Enter $n integers:")
    for (i in numbers.indices) {
        numbers[i] = readlnOrNull()?.toInt() ?: 0
    }

    println("Numbers from the array that are part of the Fibonacci sequence:")
    numbers.filter { isFibonacci(it) }.forEach { println(it) }
}

fun isPerfectSquare(x: Int): Boolean {
    val s = Math.sqrt(x.toDouble()).toInt()
    return s * s == x
}

fun isFibonacci(n: Int): Boolean {
    return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4)
}
