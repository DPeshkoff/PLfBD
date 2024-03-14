package org.lab6

/**
 * 1.На базе коллекций реализовать структуру хранения чисел с поддержкой следующих операций:
 * • добавление/удаление числа;
 * • поиск числа, наиболее близкого к заданному (т.е. модуль разницы минимален).
 */

class NumberStorage {
    private val numbers = mutableListOf<Int>()

    fun addNumber(number: Int) {
        numbers.add(number)
    }

    fun removeNumber(number: Int) {
        numbers.remove(number)
    }

    fun findClosestNumber(target: Int): Int? {
        return numbers.minByOrNull { Math.abs(it - target) }
    }
}

fun main() {
    val numberStorage = NumberStorage()

    numberStorage.addNumber(5)
    numberStorage.addNumber(10)
    numberStorage.addNumber(15)

    val targetNumber = 12
    val closestNumber = numberStorage.findClosestNumber(targetNumber)

    println("Closest number to $targetNumber: $closestNumber")
}