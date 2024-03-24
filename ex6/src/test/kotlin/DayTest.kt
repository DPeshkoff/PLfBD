import org.junit.jupiter.api.Test
import org.lab3.Day
import org.lab3.Hour
import org.lab3.Minute
import kotlin.test.assertEquals

class DayTest {

    @Test
    fun testDayMethods() {
        val hour = Hour(9)
        val minute = Minute(30)
        val day = Day(hour, minute)

        assertEquals("09:30", day.displayCurrentTime())
        assertEquals("Morning", day.calculateTimeOfDay())
    }
}