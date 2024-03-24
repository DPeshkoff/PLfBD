package org.lab3

import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

/**
 * Создать приложение, удовлетворяющее требованиям, приведенным в задании. Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить для каждого класса методы equals(), hashCode(), toString().
 *
 * 10. Создать объект класса Год, используя классы Месяц, День. Методы: задать дату, вывести на консоль день недели по заданной дате, рассчитать количество дней, месяцев в заданном временном промежутке.
 */
class Month(internal val value: Int) {
    init {
        require(value in 1..12) { "Month value must be between 1 and 12" }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Month) return false
        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return value.toString()
    }
}

class Day(internal val value: Int) {
    init {
        require(value in 1..31) { "Day value must be between 1 and 31" }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Day) return false
        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return value.toString()
    }
}

class Year(private val month: Month, private val day: Day) {

    fun displayDayOfWeek(): String {
        val date = LocalDate.of(LocalDate.now().year, month.value, day.value)
        val dayOfWeek = date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.US)
        return "Day of the week: $dayOfWeek"
    }

    fun calculateDaysInTimePeriod(years: Int, months: Int): Int {
        return years * 365 + months * 30  // Rough estimation for simplicity
    }

    fun calculateMonthsInTimePeriod(years: Int, months: Int): Int {
        return years * 12 + months
    }
}

fun main() {
    println("Hello World!")
}