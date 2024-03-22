package org.lab7

/**
 * 1. В тексте найти все пары слов, из которых одно является обращением другого.
 */

fun findWordInversions(text: String): List<Pair<String, String>> {
    val words = text.split("\\s+".toRegex())
    val wordPairs = mutableListOf<Pair<String, String>>()

    for (i in words.indices) {
        val word1 = words[i]
        for (j in i + 1 until words.size) {
            val word2 = words[j]
            if (word1.length == word2.length && word1.reversed() == word2) {
                wordPairs.add(Pair(word1, word2))
            }
        }
    }

    return wordPairs
}

fun main() {
    val text = "level radar cat tac racecar stop pots deed deep"
    val wordInversions = findWordInversions(text)

    wordInversions.forEach { pair ->
        println("${pair.first} - ${pair.second}")
    }
}