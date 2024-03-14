package org.lab4

/**
 * 1.  Создать класс City (город) с внутренним классом, с помощью объектов которого можно хранить информацию о проспектах, улицах, площадях.
 */
class City(val cityName: String) {
    internal data class Avenue(val name: String)
    internal data class Street(val name: String)
    internal data class Square(val name: String)

    internal val avenues = mutableListOf<Avenue>()
    internal val streets = mutableListOf<Street>()
    internal val squares = mutableListOf<Square>()

    internal fun addAvenue(avenue: Avenue) {
        avenues.add(avenue)
    }

    internal fun addStreet(street: Street) {
        streets.add(street)
    }

    internal fun addSquare(square: Square) {
        squares.add(square)
    }
}

fun main() {
    val city = City("Metropolis")

    val avenue1 = City.Avenue("Broadway")
    val avenue2 = City.Avenue("Park Avenue")
    city.addAvenue(avenue1)
    city.addAvenue(avenue2)

    val street1 = City.Street("Main Street")
    val street2 = City.Street("Elm Street")
    city.addStreet(street1)
    city.addStreet(street2)

    val square1 = City.Square("Central Square")
    val square2 = City.Square("Town Square")
    city.addSquare(square1)
    city.addSquare(square2)

    println("City: ${city.cityName}")
    println("Avenues: ${city.avenues.map { it.name }}")
    println("Streets: ${city.streets.map { it.name }}")
    println("Squares: ${city.squares.map { it.name }}")
}