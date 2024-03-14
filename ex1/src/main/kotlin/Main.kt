package org.lab6

/**
 * 1.  Определить множество на основе множества целых чисел. Создать методы для определения пересечения и объединения множеств.
 */

class IntSet(private val set: Set<Int>) {

    fun intersection(otherSet: Set<Int>): Set<Int> {
        return set.intersect(otherSet)
    }

    fun union(otherSet: Set<Int>): Set<Int> {
        return set.union(otherSet)
    }
}

fun main() {
    val set1 = IntSet(setOf(1, 2, 3, 4, 5))
    val set2 = setOf(3, 4, 5, 6, 7)

    val intersectionResult = set1.intersection(set2)
    val unionResult = set1.union(set2)

    println("Intersection: $intersectionResult")
    println("Union: $unionResult")
}