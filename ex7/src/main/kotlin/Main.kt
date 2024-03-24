package org.lab5

import java.io.File

/**
 * При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File
 * 10.Ввести из текстового файла, связанного с входным потоком, последовательность строк. Выбрать и сохранить m последних слов в каждой из последних n строк
 */

fun selectAndStoreWords(inputLines: List<String>, m: Int, n: Int, outputPath: String) {
    val selectedLines = inputLines.takeLast(n).map { line ->
        val words = line.split(" ")
        val selectedWords = words.takeLast(m)
        selectedWords.joinToString(" ")
    }

    val outputDirectory = File(outputPath)
    outputDirectory.mkdirs()

    val outputFile = File(outputDirectory, "selected_words.txt")
    outputFile.writeText(selectedLines.joinToString("\n"))
}

fun main(args: Array<String>) {
    if (args.size != 4) {
        println("Usage: kotlin SelectAndStoreWordsAppKt <input_file_path> <m> <n> <output_directory_path>")
        return
    }

    val inputFilePath = args[0]
    val m = args[1].toInt()
    val n = args[2].toInt()
    val outputDirectoryPath = args[3]

    val inputLines = File(inputFilePath).readLines()
    selectAndStoreWords(inputLines, m, n, outputDirectoryPath)

    println("Selected words from the last $n lines stored in $outputDirectoryPath/selected_words.txt")
}