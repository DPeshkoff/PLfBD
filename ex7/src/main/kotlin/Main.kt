package org.lab3


/**
 * Построить модель программной системы.
 *
 * 10. Система Железнодорожная касса. Пассажир делает Заявку на станцию назначения, время и дату поездки. Система регистрирует Заявку и осуществляет поиск подходящего Поезда. Пассажир делает выбор Поезда и получает Счет на оплату. Администратор вводит номера Поездов, промежуточные и конечные станции, цены
 */

data class Application(
    val passengerName: String,
    val destinationStation: String,
    val travelTime: String,
    val travelDate: String
)

data class Train(
    val trainNumber: Int,
    val intermediateStations: List<String>,
    val finalStation: String,
    val prices: Map<String, Double>
)

data class Invoice(
    val passengerName: String,
    val trainNumber: Int,
    val totalAmount: Double
)

class TicketOfficeSystem {
    private val applications = mutableListOf<Application>()
    private val trains = mutableListOf<Train>()
    private val invoices = mutableListOf<Invoice>()

    fun registerApplication(application: Application) {
        applications.add(application)
    }

    fun searchTrain(destinationStation: String, travelTime: String, travelDate: String): Train? {
        return trains.find { it.intermediateStations.contains(destinationStation) }
    }

    fun makeChoice(train: Train, passengerName: String): Invoice {
        val totalAmount = train.prices.values.sum()
        val invoice = Invoice(passengerName, train.trainNumber, totalAmount)
        invoices.add(invoice)
        return invoice
    }

    fun enterTrainDetails(trainNumber: Int, intermediateStations: List<String>, finalStation: String, prices: Map<String, Double>) {
        val train = Train(trainNumber, intermediateStations, finalStation, prices)
        trains.add(train)
    }
}

fun main() {
    val ticketOffice = TicketOfficeSystem()

    val application = Application("Alice", "Station B", "10:00", "2022-12-31")
    ticketOffice.registerApplication(application)

    val trainDetails = mapOf("Station A" to 50.0, "Station B" to 100.0, "Station C" to 150.0)
    ticketOffice.enterTrainDetails(1, listOf("Station A", "Station B", "Station C"), "Station D", trainDetails)

    val selectedTrain = ticketOffice.searchTrain("Station D", "12:00", "2022-12-31")
    if (selectedTrain != null) {
        val invoice = ticketOffice.makeChoice(selectedTrain, "Alice")
        println("Invoice generated: $invoice")
    } else {
        println("No suitable train found.")
    }
}