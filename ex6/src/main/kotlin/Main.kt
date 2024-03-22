package org.lab7

/**
 * 1.  В тексте нет слов, начинающихся одинаковыми буквами. Напечатать слова текста в таком порядке, чтобы последняя буква каждого слова совпадала с первой буквой последующего слова. Если все слова нельзя напечатать в таком порядке, найти такую цепочку, состоящую из наибольшего количества слов.
 */

fun findLongestWordChain(text: String): List<String> {
    val words = text.split("\\s+".toRegex())
    val wordMap = mutableMapOf<Char, MutableList<String>>()

    words.forEach { word ->
        val firstLetter = word.first()
        val lastLetter = word.last()
        wordMap.computeIfAbsent(firstLetter) { mutableListOf() }.add(word)
        wordMap.computeIfAbsent(lastLetter) { mutableListOf() }
    }

    fun findLongestChain(startWord: String): List<String> {
        val chain = mutableListOf(startWord)
        var currentWord = startWord.last()

        while (true) {
            val nextWords = wordMap[currentWord]
            val nextWord = nextWords?.firstOrNull { it !in chain }
            if (nextWord != null) {
                chain.add(nextWord)
                currentWord = nextWord.last()
            } else {
                break
            }
        }

        return chain
    }

    var longestChain = emptyList<String>()

    for (word in words) {
        val currentChain = findLongestChain(word)
        if (currentChain.size > longestChain.size) {
            longestChain = currentChain
        }
    }

    return longestChain
}

fun main() {
    val text = "apple elephant tiger rabbit dog goat"
    val longestWordChain = findLongestWordChain(text)

    if (longestWordChain.isNotEmpty()) {
        longestWordChain.forEach { word ->
            println(word)
        }
    } else {
        println("No chain found")
    }
}