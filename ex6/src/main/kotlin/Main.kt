package org.lab5

import java.io.File

/**
 * В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия. При этом могут рассматриваться два варианта:
 * • каждая строка состоит из одного слова;
 * • каждая строка состоит из нескольких слов.
 * Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как параметры командной строки или храниться в файле.
 * 1. В каждой строке найти и удалить заданную подстроку.
 */

fun findAndRemoveSubstring(input: List<String>, substring: String): List<String> {
    return input.map { line ->
        line.replace(substring, "")
    }
}

fun main(args: Array<String>) {
    if (args.size != 3) {
        println("Usage: kotlin SubstringRemovalAppKt <input_file_path> <output_file_path> <substring>")
        return
    }

    val inputFilePath = args[0]
    val outputFilePath = args[1]
    val substring = args[2]

    val inputLines = File(inputFilePath).readLines()
    val outputLines = findAndRemoveSubstring(inputLines, substring)

    File(outputFilePath).writeText(outputLines.joinToString("\n"))
}