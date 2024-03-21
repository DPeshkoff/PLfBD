package org.lab7

/**
 * 10.  Рассортировать слова русского текста по возрастанию доли гласных букв (отношение количества гласных к общему количеству букв в слове)
 */

fun sortWordsByVowelProportion(text: String): List<String> {
    fun calculateVowelProportion(word: String): Double {
        val vowels = word.count { it.lowercaseChar() in "аеуияоыэaeiou" }
        val totalLetters = word.count { it.isLetter() }
        return if (totalLetters > 0) {
            vowels.toDouble() / totalLetters
        } else {
            0.0
        }
    }

    val words = text.split("\\s+".toRegex())
    val sortedWords = words.sortedBy { calculateVowelProportion(it) }
    return sortedWords
}

fun main() {
    val text = "Hello world, how are you?"
    val sortedWords = sortWordsByVowelProportion(text)

    sortedWords.forEach { word ->
        println(word)
    }
}