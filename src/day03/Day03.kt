package day03

import readInput

fun main() {
    val diagnosticReport = readInput("day03/Day03").map { it -> it.toCharArray().map { it.digitToInt() } }

    fun List<List<Int>>.mostCommon() = first().indices
        .map { bitPosition -> count { it[bitPosition] == 1 } }
        .map { if (it > size - it) 1 else 0 }

    fun part01(input: List<List<Int>>): Int {
        val mostCommon = input.mostCommon()
        val leastCommon = mostCommon.map { it.xor(1) }

        return mostCommon.joinToString("").toInt(2) * leastCommon.joinToString("").toInt(2)
    }

    fun part02() {

    }
    println(part01(diagnosticReport))
}