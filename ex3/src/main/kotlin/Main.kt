package org.lab3

class Train(
    public var destination: String,
    private var trainNumber: String,
    public var departureTime: String,
    public var numGeneralSeats: Int,
    public var numCompartmentSeats: Int,
    public var numReservedSeats: Int,
    public var numLuxurySeats: Int
) {
    fun setType(type: String, value: Int) {
        when (type) {
            "general" -> numGeneralSeats = value
            "compartment" -> numCompartmentSeats = value
            "reserved" -> numReservedSeats = value
            "luxury" -> numLuxurySeats = value
            else -> throw IllegalArgumentException("Invalid seat type")
        }
    }

    fun getType(type: String): Int {
        return when (type) {
            "general" -> numGeneralSeats
            "compartment" -> numCompartmentSeats
            "reserved" -> numReservedSeats
            "luxury" -> numLuxurySeats
            else -> throw IllegalArgumentException("Invalid seat type")
        }
    }

    override fun toString(): String {
        return "Train to $destination (Train Number: $trainNumber, Departure Time: $departureTime)"
    }
}

class TrainManager(private val trains: Array<Train>) {

    fun filterTrainsByDestination(destination: String): List<Train> {
        return trains.filter { it.destination == destination }
    }

    fun filterTrainsByDestinationAndDepartureTime(destination: String, departureTime: String): List<Train> {
        return trains.filter { it.destination == destination && it.departureTime.split(':')[0].toInt() > departureTime.split(':')[0].toInt() }
    }

    fun filterTrainsByDestinationAndCommonSeats(destination: String): List<Train> {
        return trains.filter { it.destination == destination && it.numGeneralSeats > 0 && it.numCompartmentSeats > 0 && it.numReservedSeats > 0 && it.numLuxurySeats > 0 }
    }
}

fun main() {
    println("Hello World!")
}