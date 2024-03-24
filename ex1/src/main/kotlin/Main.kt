package org.lab5

/**
 * Выполнить задания на основе варианта 1 лабораторной работы 3, контролируя состояние потоков ввода/вывода. При возникновении ошибок, связанных с корректностью выполнения математических операций, генерировать и обрабатывать исключительные ситуации. Предусмотреть обработку исключений, возникающих при нехватке памяти, отсутствии требуемой записи (объекта) в файле, недопустимом значении поля и т.д.
 *
 * 10 Определить класс Булева матрица (BoolMatrix) размерности (n x m). Класс должен содержать несколько конструкторов. Реализовать методы для логического сложения (дизъюнкции), умножения и инверсии матриц. Реализовать методы для подсчета числа единиц в матрице и упорядочения строк в лексикографическом порядке
 */

class BoolMatrix(private val n: Int, private val m: Int) {
    private val matrix = Array(n) { BooleanArray(m) }

    constructor(matrix: Array<BooleanArray>) : this(matrix.size, matrix[0].size) {
        for (i in 0 until n) {
            for (j in 0 until m) {
                this.matrix[i][j] = matrix[i][j]
            }
        }
    }

    fun logicalOr(other: BoolMatrix): BoolMatrix {
        require(n == other.n && m == other.m) { "Matrices must have the same dimensions for logical OR operation" }

        val result = BoolMatrix(n, m)
        for (i in 0 until n) {
            for (j in 0 until m) {
                result.matrix[i][j] = this.matrix[i][j] || other.matrix[i][j]
            }
        }
        return result
    }

    fun logicalAnd(other: BoolMatrix): BoolMatrix {
        require(n == other.n && m == other.m) { "Matrices must have the same dimensions for logical AND operation" }

        val result = BoolMatrix(n, m)
        for (i in 0 until n) {
            for (j in 0 until m) {
                result.matrix[i][j] = this.matrix[i][j] && other.matrix[i][j]
            }
        }
        return result
    }

    fun invert(): BoolMatrix {
        val result = BoolMatrix(n, m)
        for (i in 0 until n) {
            for (j in 0 until m) {
                result.matrix[i][j] = !this.matrix[i][j]
            }
        }
        return result
    }

    fun countOnes(): Int {
        var count = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (matrix[i][j]) {
                    count++
                }
            }
        }
        return count
    }

    fun sortRowsLexicographically(): BoolMatrix {
        val sortedMatrix = matrix.sortedWith(compareBy { it.joinToString(separator = "") { if (it) "1" else "0" } })
        return BoolMatrix(sortedMatrix.toTypedArray())
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (row in matrix) {
            sb.append(row.joinToString(separator = " ") { if (it) "1" else "0" })
            sb.append("\n")
        }
        return sb.toString()
    }
}

fun main() {
    val matrix1 = BoolMatrix(arrayOf(booleanArrayOf(true, false), booleanArrayOf(false, true)))
    val matrix2 = BoolMatrix(arrayOf(booleanArrayOf(false, true), booleanArrayOf(true, false)))

    println("Matrix 1:")
    println(matrix1)

    println("Matrix 2:")
    println(matrix2)

    val logicalOrResult = matrix1.logicalOr(matrix2)
    println("Logical OR Result:")
    println(logicalOrResult)

    val logicalAndResult = matrix1.logicalAnd(matrix2)
    println("Logical AND Result:")
    println(logicalAndResult)

    val invertedMatrix = matrix1.invert()
    println("Inverted Matrix:")
    println(invertedMatrix)

    println("Number of ones in Matrix 1: ${matrix1.countOnes()}")
    println("Number of ones in Matrix 2: ${matrix2.countOnes()}")

    val sortedMatrix = matrix1.sortRowsLexicographically()
    println("Matrix 1 sorted lexicographically:")
    println(sortedMatrix)
}