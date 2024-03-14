package org.lab4

/**
 * 10 Создать класс Cinema (кино) с внутренним классом, с помощью объектов которого можно хранить информацию об адресах кинотеатров, фильмах и времени сеансов.
 */

data class Movie(val title: String, val duration: Int)

data class ShowTime(val movie: Movie, val time: String)

data class Cinema(val name: String) {
    val moviesAndShowTimes = mutableMapOf<Movie, MutableList<ShowTime>>()

    fun addMovie(movie: Movie) {
        moviesAndShowTimes[movie] = mutableListOf()
    }

    fun addShowTime(movie: Movie, showTime: ShowTime) {
        moviesAndShowTimes[movie]?.add(showTime)
    }

    fun getMovies(): Set<Movie> {
        return moviesAndShowTimes.keys
    }

    fun getShowTimes(movie: Movie): List<ShowTime>? {
        return moviesAndShowTimes[movie]
    }
}

fun main() {
    val cinema = Cinema("Cineplex")

    val movie1 = Movie("Inception", 150)
    val movie2 = Movie("The Dark Knight", 152)

    cinema.addMovie(movie1)
    cinema.addMovie(movie2)

    val showTime1 = ShowTime(movie1, "15:00")
    val showTime2 = ShowTime(movie1, "18:00")
    val showTime3 = ShowTime(movie2, "17:30")

    cinema.addShowTime(movie1, showTime1)
    cinema.addShowTime(movie1, showTime2)
    cinema.addShowTime(movie2, showTime3)

    println("Movies at ${cinema.name}:")
    cinema.getMovies().forEach { movie ->
        println("- ${movie.title}")
        val showTimes = cinema.getShowTimes(movie)
        showTimes?.forEach { showTime ->
            println("  - Showtime: ${showTime.time}")
        }
    }
}