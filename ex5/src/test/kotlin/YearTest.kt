import org.junit.jupiter.api.Test
import org.lab3.Day
import org.lab3.Month
import org.lab3.Year
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*
import kotlin.test.assertEquals

class YearTest {

    @Test
    fun testYearMethods() {
        val month = Month(3)
        val day = Day(15)
        val year = Year(month, day)

        val date = LocalDate.of(LocalDate.now().year, 3, 15).dayOfWeek.getDisplayName(TextStyle.FULL, Locale.US)

        assertEquals("Day of the week: $date", year.displayDayOfWeek())
        assertEquals(365, year.calculateDaysInTimePeriod(1, 0))
        assertEquals(12, year.calculateMonthsInTimePeriod(1, 0))
    }
}