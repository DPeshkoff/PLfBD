package org.lab7

/**
 * 10. В тексте найти первую подстроку максимальной длины, не содержащую букв.
 */

fun findLongestNonLetterSubstring(text: String): String {
    val regex = Regex("[^a-zA-Z]+")
    val matches = regex.findAll(text)
    var longestSubstring = ""

    matches.forEach { match ->
        if (match.value.length > longestSubstring.length) {
            longestSubstring = match.value
        }
    }

    return longestSubstring
}

fun main() {
    val text = "The 12345 brown fox jumps over the lazy dog!"
    val longestSubstring = findLongestNonLetterSubstring(text)

    println("Longest non-letter substring: $longestSubstring")
}