import org.junit.jupiter.api.Test
import org.lab4.Cinema
import org.lab4.Movie
import org.lab4.ShowTime
import kotlin.test.assertEquals

class CinemaTest {

    @Test
    fun testAddMovie() {
        val cinema = Cinema("Cineplex")
        val movie = Movie("Inception", 150)

        cinema.addMovie(movie)

        assertEquals(setOf(movie), cinema.getMovies())
    }

    @Test
    fun testAddShowTime() {
        val cinema = Cinema("Cineplex")
        val movie = Movie("Inception", 150)
        val showTime = ShowTime(movie, "15:00")

        cinema.addMovie(movie)
        cinema.addShowTime(movie, showTime)

        val showTimes = cinema.getShowTimes(movie)
        assertEquals(listOf(showTime), showTimes)
    }
}