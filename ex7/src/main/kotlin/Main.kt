package org.lab7

/**
 * 10.  Исключить из текста подстроку максимальной длины, начинающуюся и заканчивающуюся одним и тем же символом
 */

fun excludeSubstringWithSameCharacters(text: String): String {
    var maxSubstring = ""
    var maxLength = 0

    for (i in text.indices) {
        for (j in i + 1 until text.length) {
            if (text[i] == text[j]) {
                val substring = text.substring(i, j + 1)
                if (substring.length > maxLength) {
                    maxLength = substring.length
                    maxSubstring = substring
                }
            }
        }
    }

    return text.replace(maxSubstring, "")
}

fun main() {
    val text = "abracadabra"
    val result = excludeSubstringWithSameCharacters(text)
    println(result)
}
