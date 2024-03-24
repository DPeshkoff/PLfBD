package org.example

import kotlin.random.Random

/**
 * Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
 *
 * 10. Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие
 */
fun main() {
    println("Enter the dimension of the matrix:")
    val n = readlnOrNull()?.toInt() ?: 0

    val matrix = Array(n) { Array(n) { Random.nextInt(-n, n + 1) } }

    println("Original Matrix:")
    printMatrix(matrix)

    val maxElements = findMaxElements(matrix)
    val newMatrix = removeRowsAndColumns(matrix, maxElements)

    println("Matrix after removing rows and columns with maximum element(s):")
    printMatrix(newMatrix)
}

fun findMaxElements(matrix: Array<Array<Int>>): Set<Int> {
    val maxElement = matrix.flatten().maxOrNull() ?: 0
    return matrix.flatten().withIndex().filter { it.value == maxElement }.map { it.index }.toSet()
}

fun removeRowsAndColumns(matrix: Array<Array<Int>>, maxElements: Set<Int>): Array<Array<Int>> {
    val rowsToRemove = maxElements.map { it / matrix.size }.toSet()
    val columnsToRemove = maxElements.map { it % matrix.size }.toSet()

    return matrix.filterIndexed { index, _ -> index !in rowsToRemove }
        .map { row -> row.filterIndexed { index, _ -> index !in columnsToRemove }.toTypedArray() }
        .toTypedArray()
}

fun printMatrix(matrix: Array<Array<Int>>) {
    matrix.forEach { row -> println(row.joinToString("\t")) }
}