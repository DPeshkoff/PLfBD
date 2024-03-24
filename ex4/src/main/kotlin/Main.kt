package org.lab2

import kotlin.random.Random

/**
 * Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
 * Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
 */
fun main() {
    println("Enter the dimension of the matrix:")
    val n = readlnOrNull()?.toInt() ?: 0

    val matrix = Array(n) { Array(n) { Random.nextInt(-n, n + 1) } }

    println("Original Matrix:")
    printMatrix(matrix)

    val k = chooseK(matrix)
    val sortedMatrix = sortMatrix(matrix, k)

    println("Matrix after sorting rows based on $k-th column:")
    printMatrix(sortedMatrix)
}

fun chooseK(matrix: Array<Array<Int>>): Int {
    println("Choose the column number to sort the rows (1 to ${matrix.size}):")
    return readlnOrNull()?.toInt()?.coerceIn(1, matrix.size) ?: 1
}

fun sortMatrix(matrix: Array<Array<Int>>, k: Int): Array<Array<Int>> {
    return matrix.sortedBy { it[k - 1] }.toTypedArray()
}

fun printMatrix(matrix: Array<Array<Int>>) {
    matrix.forEach { row -> println(row.joinToString("\t")) }
}