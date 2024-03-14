package org.lab4

/**
 * Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
 *
 * 1.  Абстрактный класс Книга (Шифр, Автор, Название, Год, Издательство). Подклассы Справочник и Энциклопедия.
 */

abstract class Book(
    val code: String,
    val author: String,
    val title: String,
    val year: Int,
    val publisher: String
) {
    abstract fun getInfo(): String
}

class Directory(
    code: String,
    author: String,
    title: String,
    year: Int,
    publisher: String,
    val sections: Int
) : Book(code, author, title, year, publisher) {
    override fun getInfo(): String {
        return "Directory - $title by $author"
    }
}

class Encyclopedia(
    code: String,
    author: String,
    title: String,
    year: Int,
    publisher: String,
    val volumes: Int
) : Book(code, author, title, year, publisher) {
    override fun getInfo(): String {
        return "Encyclopedia - $title by $author"
    }
}

fun main() {
    val directory = Directory("A111", "John Doe", "BMSTU Directory", 2022, "BMSTU Publishings", 10)
    val encyclopedia = Encyclopedia("E456", "Jane Smith", "Science Encyclopedia", 2024, "Science Books", 5)

    println(directory.getInfo())
    println(encyclopedia.getInfo())
}