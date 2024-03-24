package org.lab2
import java.util.Date

/**
 * 1
 * Ввести n строк с консоли, найти самую короткую и самую длинную строки. Вывести найденные строки и их длину
 */
fun main() {
    val lines = mutableListOf<String>()
    println("Enter the number of lines:")
    val n = readlnOrNull()?.toInt() ?: 0

    repeat(n) {
        println("Enter a line:")
        val line = readlnOrNull() ?: ""
        lines.add(line)
    }

    val (shortestLine, longestLine) = findShortestAndLongestLines(lines)

    println("Shortest line: $shortestLine.first, Length: ${shortestLine.second ?: 0}")
    println("Longest line: $longestLine.first, Length: ${longestLine.second ?: 0}")

    val developer = "DPeshkoff"
    val receivedDateTime = Date()
    val submittedDateTime = Date()

    println("Developer: $developer")
    println("Task received: $receivedDateTime")
    println("Task submitted: $submittedDateTime")
}

fun findShortestAndLongestLines(lines: List<String>): Pair<Pair<String, Int>, Pair<String, Int>> {
    val shortestLine = lines.minByOrNull { it.length } ?: ""
    val longestLine = lines.maxByOrNull { it.length } ?: ""
    return Pair(shortestLine, shortestLine.length) to Pair(longestLine, longestLine.length)
}