import org.junit.jupiter.api.Test
import org.lab3.Application
import org.lab3.TicketOfficeSystem
import kotlin.test.assertEquals

class TicketOfficeSystemTest {

    @Test
    fun testMakeChoice() {
        val ticketOffice = TicketOfficeSystem()

        val trainDetails = mapOf("Station A" to 50.0, "Station B" to 100.0, "Station C" to 150.0)
        ticketOffice.enterTrainDetails(1, listOf("Station A", "Station B", "Station C"), "Station D", trainDetails)

        val selectedTrain = ticketOffice.searchTrain("Station B", "12:00", "2022-12-31")
        val invoice = ticketOffice.makeChoice(selectedTrain!!, "Bob")

        assertEquals("Bob", invoice.passengerName)
        assertEquals(1, invoice.trainNumber)
        assertEquals(300.0, invoice.totalAmount)
    }

    @Test
    fun testTicketOfficeSystem() {
        val ticketOffice = TicketOfficeSystem()

        val application = Application("Alice", "Station B", "10:00", "2022-12-31")
        ticketOffice.registerApplication(application)

        val trainDetails = mapOf("Station A" to 50.0, "Station B" to 100.0, "Station C" to 150.0)
        ticketOffice.enterTrainDetails(1, listOf("Station A", "Station B", "Station C"), "Station D", trainDetails)

        val selectedTrain = ticketOffice.searchTrain("Station A", "12:00", "2022-12-31")
        assertEquals(1, selectedTrain?.trainNumber)

        val invoice = ticketOffice.makeChoice(selectedTrain!!, "Alice")
        assertEquals("Alice", invoice.passengerName)
        assertEquals(1, invoice.trainNumber)
        assertEquals(300.0, invoice.totalAmount)
    }
}