package day03

import readInput

fun main() {
    val diagnosticReport = readInput("day03/Day03").map { it -> it.toCharArray().map { it.digitToInt() } }

    fun List<List<Int>>.mostCommonBit() = first().indices
        .map { bitPosition -> count { it[bitPosition] == 1 } }
        .map { if (it > size - it) 1 else 0 }

    fun part01(input: List<List<Int>>): Int {
        val mostCommonCombination = input.mostCommonBit()
        val invertedCombination = mostCommonCombination.map { it.xor(1) }

        return mostCommonCombination.joinToString("").toInt(2) * invertedCombination.joinToString("").toInt(2)
    }


    fun findCount(values: List<String>, position: Int): AmountOf {
        val amountOf = AmountOf()

        values.forEach { line -> if (line[position] == '0') amountOf.zeros++ else amountOf.ones++ }
        return amountOf
    }

    fun findRating(
        inputValues: List<String>,
        position: Int,
        filter: (String, Int, AmountOf) -> Boolean
    ): String {
        val filteredValues = inputValues.filter { value -> filter(value, position, findCount(inputValues, position)) }

        return when {
            filteredValues.size == 1 -> filteredValues[0]
            filteredValues.size > 1 -> findRating(filteredValues, position + 1, filter)
            else -> throw IllegalStateException("Could not find values")
        }
    }


    fun createOxygenBit(amountOf: AmountOf): Char {
        return when {
            amountOf.ones > amountOf.zeros -> '1'
            amountOf.zeros > amountOf.ones -> '0'
            else -> '1'
        }
    }

    fun createCo2Bit(amountOf: AmountOf): Char {
        return when {
            amountOf.ones < amountOf.zeros -> '1'
            amountOf.zeros < amountOf.ones -> '0'
            else -> '0'
        }
    }

    fun part02(): Int {
        val inputValues = readInput("day03/day03")

        val oxygen = findRating(inputValues, 0) { value, position, count ->
            val valueAtPosition = value[position]
            valueAtPosition == createOxygenBit(count)
        }

        val co2 = findRating(inputValues, 0) { value, position, count ->
            val valueAtPosition = value[position]
            valueAtPosition == createCo2Bit(count)
        }

        return  oxygen.toInt(2) * co2.toInt(2)
    }


    println(part01(diagnosticReport))
    println(part02())
}


data class AmountOf(
    var zeros: Int = 0,
    var ones: Int = 0
)