package org.lab3

/**
 * Создать приложение, удовлетворяющее требованиям, приведенным в задании. Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить для каждого класса методы equals(), hashCode(), toString().
 *
 * 11. Создать объект класса Сутки, используя классы Час, Минута. Методы: вывести на консоль текущее время, рассчитать время суток (утро, день, вечер, ночь).
 */
class Hour(val value: Int) {
    init {
        require(value in 0..23) { "Hour value must be between 0 and 23" }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Hour) return false
        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return value.toString()
    }
}

class Minute(private val value: Int) {
    init {
        require(value in 0..59) { "Minute value must be between 0 and 59" }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Minute) return false
        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return value.toString()
    }
}

class Day(private val hour: Hour, private val minute: Minute) {

    fun displayCurrentTime(): String {
        return "${hour.toString().padStart(2, '0')}:${minute.toString().padStart(2, '0')}"
    }

    fun calculateTimeOfDay(): String {
        return when (hour.value) {
            in 6..11 -> "Morning"
            in 12..16 -> "Afternoon"
            in 17..20 -> "Evening"
            else -> "Night"
        }
    }
}


fun main() {
    println("Hello World!")
}