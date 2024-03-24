package org.lab4

/**
 * Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
 *
 * 10.  interfaceФильм<-classОтечественныйФильм<-classКомедия.
 */

interface Film {
    fun play()
}

abstract class DomesticFilm : Film {
    abstract val country: String
}

class Comedy(override val country: String) : DomesticFilm() {
    override fun play() {
        println("Playing a comedy film from $country")
    }
}

fun main() {
    val comedyFilm = Comedy("Russia")
    comedyFilm.play()
}