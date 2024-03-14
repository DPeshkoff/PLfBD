package org.lab6

import kotlin.math.pow

/**
 * 2.  Списки (стеки, очереди) I(1..n) и U(1..n) содержат результаты nизмерений тока и напряжения на неизвестном сопротивлении R. Найти приближенное число R методом наименьших квадратов.
 */

fun calculateResistance(currentList: List<Double>, voltageList: List<Double>): Double {
    require(currentList.size == voltageList.size) { "Current and Voltage lists must be of the same size" }
    val n = currentList.size

    val sumI = currentList.sum()
    val sumV = voltageList.sum()
    val sumIV = currentList.zip(voltageList).sumByDouble { (i, v) -> i * v }
    val sumI2 = currentList.sumByDouble { it.pow(2) }

    val a = (n * sumIV - sumI * sumV) / (n * sumI2 - sumI.pow(2))

    return a
}

fun main() {
    val currentList = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
    val voltageList = listOf(2.0, 4.0, 6.0, 8.0, 10.0)

    val resistance = calculateResistance(currentList, voltageList)

    println("Approximate resistance R: $resistance")
}