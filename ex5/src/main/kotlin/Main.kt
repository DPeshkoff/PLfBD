package org.lab5

import java.io.File

/**
 *В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия. При этом могут рассматриваться два варианта:
 * • каждая строка состоит из одного слова;
 * • каждая строка состоит из нескольких слов.
 * Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как параметры командной строки или храниться в файле.
 * 10. Входной файл хранит квадратную матрицу по принципу: строка представляет собой число. Определить размерность. Построить 2-мерный массив, содержащий матрицу. Вывести исходную матрицу и результат ее поворота на 90 градусов по часовой стрелке.
 */

fun readMatrixFromFile(filePath: String): List<List<Int>> {
    val matrix = mutableListOf<List<Int>>()

    File(filePath).forEachLine { line ->
        val row = line.split(" ").map { it.toInt() }
        matrix.add(row)
    }

    return matrix
}

fun rotateMatrixClockwise(matrix: List<List<Int>>): List<List<Int>> {
    val n = matrix.size
    val rotatedMatrix = Array(n) { IntArray(n) { 0 } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            rotatedMatrix[j][n - 1 - i] = matrix[i][j]
        }
    }

    return rotatedMatrix.map { it.toList() }
}

fun printMatrix(matrix: List<List<Int>>) {
    matrix.forEach { row ->
        println(row.joinToString(separator = " "))
    }
}

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Usage: kotlin MatrixRotationAppKt <input_file_path>")
        return
    }

    val filePath = args[0]
    val matrix = readMatrixFromFile(filePath)

    println("Original Matrix:")
    printMatrix(matrix)

    val rotatedMatrix = rotateMatrixClockwise(matrix)

    println("\nRotated Matrix (90 degrees clockwise):")
    printMatrix(rotatedMatrix)
}