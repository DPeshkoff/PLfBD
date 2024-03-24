package org.lab5

import java.io.File

/**
 * При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File
 * 1. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
 */

fun replacePublicWithPrivate(inputFilePath: String, outputDirectoryPath: String) {
    val inputFile = File(inputFilePath)
    val outputDirectory = File(outputDirectoryPath)
    outputDirectory.mkdirs()

    val outputFilePath = File(outputDirectory, "modified_java_program.java")
    outputFilePath.createNewFile()

    inputFile.forEachLine { line ->
        val modifiedLine = line.replace("public ", "private ")
        outputFilePath.appendText("$modifiedLine\n")
    }

    println("Java program modified successfully. Modified program saved in $outputFilePath")
}

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Usage: kotlin ModifyJavaProgramAppKt <input_file_path> <output_directory_path>")
        return
    }

    val inputFilePath = args[0]
    val outputDirectoryPath = args[1]

    replacePublicWithPrivate(inputFilePath, outputDirectoryPath)
}