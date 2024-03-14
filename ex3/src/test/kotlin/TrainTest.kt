import org.junit.jupiter.api.Test
import org.lab3.Train
import org.lab3.TrainManager
import kotlin.test.assertEquals

class TrainTest {

    @Test
    fun testTrainMethods() {
        val train1 = Train("City1", "123", "08:00", 50, 20, 30, 10)
        val train2 = Train("City2", "456", "10:00", 40, 15, 25, 5)
        val train3 = Train("City1", "789", "09:00", 60, 25, 35, 15)

        assertEquals(50, train1.getType("general"))
        train1.setType("general", 55)
        assertEquals(55, train1.getType("general"))
        assertEquals("Train to City1 (Train Number: 123, Departure Time: 08:00)", train1.toString())

        val trainManager = TrainManager(arrayOf(train1, train2, train3))

        val trainsToCity1 = trainManager.filterTrainsByDestination("City1")
        assertEquals(2, trainsToCity1.size)

        val trainsToCity1After830 = trainManager.filterTrainsByDestinationAndDepartureTime("City1", "09:00")
        assertEquals(0, trainsToCity1After830.size)

        val trainsToCity1WithCommonSeats = trainManager.filterTrainsByDestinationAndCommonSeats("City1")
        assertEquals(2, trainsToCity1WithCommonSeats.size)
    }
}