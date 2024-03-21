package org.lab7

/**
 * 1. В каждом слове текста k-ю букву заменить заданным символом. Если k больше длины слова, корректировку не выполнять.
 */

fun replaceKthLetter(text: String, k: Int, symbol: Char): String {
    val regex = Regex("\\b(\\w{$k})(\\w)")
    return text.replace(regex) { result ->
        val word = result.groupValues[1]
        val newWord = if (word.length >= k) {
            word.substring(0, k - 1) + symbol + word.substring(k)
        } else {
            word
        }
        newWord + result.groupValues[2]
    }
}

fun main() {
    val text = "Replace the kth letter in each word with the given symbol."
    val newText = replaceKthLetter(text, 4, '*')

    println("New Text: $newText")
}