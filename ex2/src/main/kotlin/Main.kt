package org.lab3

import kotlin.math.acos
import kotlin.math.sqrt
import kotlin.math.PI

/**
 * 1 Определить класс Вектор размерности n. Реализовать методы сложения, вычитания, умножения, инкремента, декремента, индексирования. Определить массив из m объектов. Каждую из пар векторов передать в методы, возвращающие их скалярное произведение и длины. Вычислить и вывести углы между векторами.
 */
class Vector(private val n: Int, private val values: DoubleArray) {

    operator fun plus(other: Vector): Vector {
        require(n == other.n) { "Vectors must have the same dimension for addition" }
        val result = DoubleArray(n) { values[it] + other.values[it] }
        return Vector(n, result)
    }

    operator fun minus(other: Vector): Vector {
        require(n == other.n) { "Vectors must have the same dimension for subtraction" }
        val result = DoubleArray(n) { values[it] - other.values[it] }
        return Vector(n, result)
    }

    operator fun times(scalar: Double): Vector {
        val result = DoubleArray(n) { values[it] * scalar }
        return Vector(n, result)
    }

    operator fun inc(): Vector {
        val result = DoubleArray(n) { values[it] + 1 }
        return Vector(n, result)
    }

    operator fun dec(): Vector {
        val result = DoubleArray(n) { values[it] - 1 }
        return Vector(n, result)
    }

    operator fun get(index: Int): Double {
        require(index in 0 until n) { "Index out of bounds" }
        return values[index]
    }

    fun scalarProduct(other: Vector): Double {
        require(n == other.n) { "Vectors must have the same dimension for scalar product" }
        var result = 0.0
        for (i in 0 until n) {
            result += values[i] * other.values[i]
        }
        return result
    }

    fun length(): Double {
        var sum = 0.0
        for (value in values) {
            sum += value * value
        }
        return sqrt(sum)
    }

    fun angleBetween(other: Vector): Double {
        require(n == other.n) { "Vectors must have the same dimension for calculating angle" }
        val dotProduct = scalarProduct(other)
        val lengthProduct = length() * other.length()
        val cosAngle = dotProduct / lengthProduct
        return acos(cosAngle) * 180 / PI
    }

    fun getValues(): DoubleArray {
        return values
    }
}

fun main() {
    println("Hello World!")
}