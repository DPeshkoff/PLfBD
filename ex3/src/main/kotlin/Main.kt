package org.lab6

/**
 * 10. На прямой гоночной трассе стоит N автомобилей, для каждого из которых известны начальное положение и скорость. Определить, сколько произойдет обгонов.
 */

data class Car(val position: Int, val speed: Int)

fun countOvertakings(cars: List<Car>): Int {
    var overtakings = 0
    val n = cars.size

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (cars[i].position < cars[j].position && cars[i].speed > cars[j].speed) {
                overtakings++
            }
        }
    }

    return overtakings
}

fun main() {
    val cars = listOf(
        Car(1, 3),
        Car(3, 2),
        Car(5, 1),
        Car(7, 4)
    )

    val overtakings = countOvertakings(cars)
    println("Number of overtakings: $overtakings")
}