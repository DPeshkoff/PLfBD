package org.lab3

/**
 * 10 Определить класс Булева матрица (BoolMatrix) размерности (n x m). Класс должен содержать несколько конструкторов. Реализовать методы для логического сложения (дизъюнкции), умножения и инверсии матриц. Реализовать методы для подсчета числа единиц в матрице и упорядочения строк в лексикографическом порядке
 */
class BoolMatrix(private val n: Int, private val m: Int, private val matrix: Array<BooleanArray>) {

    constructor(n: Int, m: Int) : this(n, m, Array(n) { BooleanArray(m) })

    fun disjunction(other: BoolMatrix): BoolMatrix {
        require(n == other.n && m == other.m) { "Matrices must have the same dimensions for disjunction operation" }
        val result = Array(n) { BooleanArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                result[i][j] = matrix[i][j] || other.matrix[i][j]
            }
        }
        return BoolMatrix(n, m, result)
    }

    fun multiplication(other: BoolMatrix): BoolMatrix {
        require(m == other.n) { "Number of columns in the first matrix must be equal to the number of rows in the second matrix for multiplication" }
        val result = Array(n) { BooleanArray(other.m) }
        for (i in 0 until n) {
            for (j in 0 until other.m) {
                for (k in 0 until m) {
                    result[i][j] = result[i][j] || (matrix[i][k] && other.matrix[k][j])
                }
            }
        }
        return BoolMatrix(n, other.m, result)
    }

    fun inversion(): BoolMatrix {
        val result = Array(n) { BooleanArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                result[i][j] = !matrix[i][j]
            }
        }
        return BoolMatrix(n, m, result)
    }

    fun countTrue(): Int {
        return matrix.sumOf { row -> row.count { it } }
    }

    fun returnMatrix(): Array<BooleanArray> {
        return matrix
    }

    fun sortRowsLexicographically(): BoolMatrix {
        val result = matrix.sortedBy { it.joinToString("") }.toTypedArray()
        return BoolMatrix(n, m, result)
    }
}

fun main() {
    println("Hello World!")
}