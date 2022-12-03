package com.binaryquackers.aoc2022

import androidx.core.text.trimmedLength
import java.nio.charset.StandardCharsets

class Day3PuzzleSolver: PuzzleSolver() {
    private fun priority(c: Char): Int {
        if (c in 'A'..'Z')
            return 27 + (c - 'A')
        else if (c in 'a'..'z')
            return 1 + (c - 'a')
        return 0
    }
    private fun solvePart1(fname: String): Int {
        var reader = java.io.BufferedReader(
        activity.assets!!.open(fname).reader(StandardCharsets.UTF_8))

        var prioritySum = 0
        reader.forEachLine {
            if (it.trimmedLength() <= 0)
                return@forEachLine
            var midpoint = it.length / 2
            var lRucksack = it.substring(0, midpoint).toSet()
            var rRucksack = it.substring(midpoint, midpoint * 2).toSet()
            var intersection = lRucksack.intersect(rRucksack)
            for (shared in intersection)
                prioritySum += priority(shared)
        }
        return prioritySum
    }
    private fun solvePart2(fname: String): Int {
        var reader = java.io.BufferedReader(
            activity.assets!!.open(fname).reader(StandardCharsets.UTF_8))

        var prioritySum = 0
        var rucksackList: ArrayList<Set<Char>> = arrayListOf()
        reader.forEachLine {
            rucksackList.add(it.toSet())
            if (rucksackList.size >= 3) {
                var intersection = rucksackList[0]
                    .intersect(rucksackList[1])
                    .intersect(rucksackList[2])
                for (shared in intersection)
                    prioritySum += priority(shared)
                rucksackList.clear()
            }
        }
        return prioritySum
    }
    private fun onPart1(fname: String) {
        message = "Priority Sum: ${solvePart1(fname)}"
    }
    private fun onPart2(fname: String) {
        message = "Priority Sum: ${solvePart2(fname)}"
    }
    override fun onPart1Test() {
        onPart1("Day3TestInput.txt")
    }
    override fun onPart1Solution() {
        onPart1("Day3Input.txt")
    }
    override fun onPart2Test() {
        onPart2("Day3TestInput.txt")
    }
    override fun onPart2Solution() {
        onPart2("Day3Input.txt")
    }
}