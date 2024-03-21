package org.lab10

/**
 * 1)  Выбрать любой датасет на kaggle.com
 * 2)  Cделать 10 выборок данных по выбранной предметной области
 */

import org.apache.spark.sql.SparkSession

fun main() {
    val spark = SparkSession.builder().appName("Lab10").orCreate
    val russian_demography = spark.read().format("csv").option("header", "true").load("src/main/resources/russian_demography.csv")
    russian_demography.createOrReplaceTempView("russian_demography")

    spark.sql("SELECT * FROM russian_demography").show()
    spark.sql("SELECT AVG(birth_rate) FROM russian_demography WHERE year < 2000").show()
    spark.sql("SELECT AVG(death_rate) FROM russian_demography WHERE year < 2000").show()
    spark.sql("SELECT * FROM russian_demography WHERE birth_rate > 14").show()
    spark.sql("SELECT * FROM russian_demography WHERE birth_rate > 10").show()
    spark.sql("SELECT AVG(urbanization) FROM russian_demography WHERE year >= 2000").show()
    spark.sql("SELECT * FROM russian_demography WHERE birth_rate > 14 AND birth_rate > 10").show()
    spark.sql("SELECT AVG(urbanization) FROM russian_demography WHERE year < 2000").show()
    spark.sql("SELECT AVG(birth_rate) FROM russian_demography WHERE year >= 2000").show()
    spark.sql("SELECT AVG(death_rate) FROM russian_demography WHERE year >= 2000").show()
    spark.sql("SELECT * FROM russian_demography WHERE region = 'Kaliningrad Oblast'").show()
    spark.stop()
}