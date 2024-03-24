package org.lab2
import java.util.Date

/**
 * 10
 * Используя оператор switch, написать программу, которая выводит на экран сообщения о принадлежности некоторого значения k интервалам (-10k, 5], [0, 10], [5, 15], [10, 10k].
 */
fun main() {
    println("Enter a value:")
    val value = readlnOrNull()?.toInt() ?: 0

    val interval = when {
        value > -10000 && value <= 5 -> "(-10k, 5]"
        value in 0..10 -> "[0, 10]"
        value in 5..15 -> "[5, 15]"
        value in 10..10000 -> "[10, 10k]"
        else -> "Value does not belong to any specified interval."
    }

    println("The value $value belongs to the interval: $interval")

    val developer = "DPeshkoff"
    val receivedDateTime = Date()
    val submittedDateTime = Date()

    println("Developer: $developer")
    println("Task received: $receivedDateTime")
    println("Task submitted: $submittedDateTime")
}