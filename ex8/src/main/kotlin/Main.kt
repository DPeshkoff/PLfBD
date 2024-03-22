package org.lab7

/**
 * 1.  Все слова английского текста рассортировать по возрастанию количества заданной буквы в слове. Слова с одинаковым количеством расположить в алфавитном порядке.
 */

fun sortWordsByLetterCount(text: String, letter: Char): List<String> {
    val words = text.split("\\s+".toRegex())

    return words.sortedWith(compareBy(
        { word -> word.count { it == letter } },
        { word -> word }
    ))
}

fun main() {
    val text = "apple elephant tiger rabbit dog goat"
    val letter = 'e'
    val sortedWords = sortWordsByLetterCount(text, letter)

    sortedWords.forEach { word ->
        println(word)
    }
}