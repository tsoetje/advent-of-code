package day02

import readInput


fun main() {
    val input = readInput("day02/Day02")

    fun part01(input: List<String>): Int {
        var forward = 0
        var vertical = 0

        for (string in input) {
            val (direction, amountString) = string.split(" ")
            val amount = amountString.toInt()

            when (direction) {
                "up" -> vertical -= amount
                "down" -> vertical += amount
                "forward" -> forward += amount
            }

        }
        return forward * vertical
    }

    fun part02(input: List<String>): Int{
        var horizontal = 0
        var vertical = 0
        var aim = 0

        for (string in input) {
            val (direction, amountString) = string.split(" ")
            val amount = amountString.toInt()

            when (direction) {
                "up" -> aim -= amount
                "down" -> aim += amount
                "forward" -> {
                    horizontal += amount
                    vertical += (aim * amount)
                }
            }

        }
        return vertical * horizontal
    }

    println(part01(input))
    println(part02(input))
}