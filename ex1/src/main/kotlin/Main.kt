package org.lab7

/**
 * 10.  Удалить из текста его часть, заключенную между двумя символами, которые вводятся (например, между скобками ‘(’ и ‘)’ или между звездочками ‘*’ и т.п.).
 */

fun removeTextBetweenCharacters(text: String, startChar: Char, endChar: Char): String {
    val regex = Regex("\\$startChar.*?\\$endChar")
    return text.replace(regex, "")
}

fun main() {
    val text = "This is (some) text with *words* to remove."
    val cleanedText = removeTextBetweenCharacters(text, '(', ')')

    println("Cleaned Text: $cleanedText")
}