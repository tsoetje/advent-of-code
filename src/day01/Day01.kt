package day01

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val seaFloorDepth = input.map { it.toInt() }

        var depthIncreased = 0
        seaFloorDepth.forEachIndexed { index, depth ->
            if(index == 0) return@forEachIndexed

            val previousDepth = seaFloorDepth[index - 1]
            if (depth > previousDepth) {
                depthIncreased++
            }
        }

        return depthIncreased
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("day01/Day01")
    println(part1(input))
    println(part2(input))
}
