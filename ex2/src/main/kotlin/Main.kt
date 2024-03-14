package org.lab5

import kotlin.math.acos
import kotlin.math.sqrt
import kotlin.math.pow

/**
 * Выполнить задания на основе варианта 1 лабораторной работы 3, контролируя состояние потоков ввода/вывода. При возникновении ошибок, связанных с корректностью выполнения математических операций, генерировать и обрабатывать исключительные ситуации. Предусмотреть обработку исключений, возникающих при нехватке памяти, отсутствии требуемой записи (объекта) в файле, недопустимом значении поля и т.д.
 *
 * 1 Определить класс Вектор размерности n. Реализовать методы сложения, вычитания, умножения, инкремента, декремента, индексирования. Определить массив из m объектов. Каждую из пар векторов передать в методы, возвращающие их скалярное произведение и длины. Вычислить и вывести углы между векторами.
 */

class Vector(private val dimension: Int) {
    internal val values = DoubleArray(dimension)

    operator fun plus(other: Vector): Vector {
        if (dimension != other.dimension) {
            throw IllegalArgumentException("Vectors must have the same dimension for addition")
        }
        val result = Vector(dimension)
        for (i in 0 until dimension) {
            result.values[i] = this.values[i] + other.values[i]
        }
        return result
    }

    operator fun minus(other: Vector): Vector {
        if (dimension != other.dimension) {
            throw IllegalArgumentException("Vectors must have the same dimension for subtraction")
        }
        val result = Vector(dimension)
        for (i in 0 until dimension) {
            result.values[i] = this.values[i] - other.values[i]
        }
        return result
    }

    operator fun times(scalar: Double): Vector {
        val result = Vector(dimension)
        for (i in 0 until dimension) {
            result.values[i] = this.values[i] * scalar
        }
        return result
    }

    operator fun inc(): Vector {
        for (i in 0 until dimension) {
            this.values[i]++
        }
        return this
    }

    operator fun dec(): Vector {
        for (i in 0 until dimension) {
            this.values[i]--
        }
        return this
    }

    operator fun get(index: Int): Double {
        if (index < 0 || index >= dimension) {
            throw IndexOutOfBoundsException("Index $index is out of bounds for vector of dimension $dimension")
        }
        return values[index]
    }

    fun scalarProduct(other: Vector): Double {
        if (dimension != other.dimension) {
            throw IllegalArgumentException("Vectors must have the same dimension for scalar product")
        }
        var result = 0.0
        for (i in 0 until dimension) {
            result += this.values[i] * other.values[i]
        }
        return result
    }

    fun length(): Double {
        var sum = 0.0
        for (value in values) {
            sum += value.pow(2)
        }
        return sqrt(sum)
    }

    fun angleBetween(other: Vector): Double {
        val dotProduct = this.scalarProduct(other)
        val cosAngle = dotProduct / (this.length() * other.length())
        return acos(cosAngle)
    }
}

fun main() {
    val vector1 = Vector(3)
    vector1.values[0] = 1.0
    vector1.values[1] = 2.0
    vector1.values[2] = 3.0

    val vector2 = Vector(3)
    vector2.values[0] = 2.0
    vector2.values[1] = 3.0
    vector2.values[2] = 4.0

    val sum = vector1 + vector2
    val difference = vector1 - vector2
    val product = vector1 * 2.0
    val scalarProduct = vector1.scalarProduct(vector2)
    val length1 = vector1.length()
    val length2 = vector2.length()
    val angle = vector1.angleBetween(vector2)

    println("Sum: $sum")
    println("Difference: $difference")
    println("Product: $product")
    println("Scalar Product: $scalarProduct")
    println("Length of Vector 1: $length1")
    println("Length of Vector 2: $length2")
    println("Angle between vectors: $angle radians")
}