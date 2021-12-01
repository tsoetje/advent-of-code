package day01

import readInput

fun main() {
    fun part1(seaFloorDepth: List<Int>): Int {

        var depthIncreased = 0
        seaFloorDepth.forEachIndexed { index, depth ->
            if (index == 0) return@forEachIndexed

            val previousDepth = seaFloorDepth[index - 1]
            if (depth > previousDepth) {
                depthIncreased++
            }
        }

        return depthIncreased
    }

    fun part2(seaFloorDepth: List<Int>): Int =
        part1(seaFloorDepth.windowed(3, 1, false) { it.sum() })


    val input = readInput("day01/Day01")
    val seaFloorDepth = input.map { it.toInt() }

    println(part1(seaFloorDepth))
    println(part2(seaFloorDepth))
}
