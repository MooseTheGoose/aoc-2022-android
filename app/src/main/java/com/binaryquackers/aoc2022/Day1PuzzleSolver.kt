package com.binaryquackers.aoc2022

import java.nio.charset.StandardCharsets

class Day1PuzzleSolver: PuzzleSolver() {
    private fun solve(fname: String): LongArray {
        var data = java.io.BufferedReader(
            activity.assets!!.open(fname)
                .reader(StandardCharsets.UTF_8))
        var elfCalories: ArrayList<Long> = ArrayList()
        var currElfCalories: Long = 0
        data.forEachLine {
            var line = it.trim()
            if (line == "") {
                elfCalories.add(currElfCalories)
                currElfCalories = 0
            } else
                currElfCalories += line.toLong()
        }
        elfCalories.sortDescending()
        var elvesSorted = elfCalories.toLongArray()
        var topElvesSum = elvesSorted[0] + elvesSorted[1] + elvesSorted[2]
        return elvesSorted
    }
    private fun onPart1(fname: String) {
        var solution = solve(fname)
        message = "Max Calories\n${solution[0]}"
    }
    private fun onPart2(fname: String) {
        var solution = solve(fname)
        message = "Max 3 Calories Total\n${solution[0]+solution[1]+solution[2]}"
    }
    override fun onPart1Test() {
        onPart1("Day1TestInput.txt")
    }
    override fun onPart1Solution() {
        onPart1("Day1Input.txt")
    }
    override fun onPart2Test() {
        onPart1("Day1TestInput.txt")
    }
    override fun onPart2Solution() {
        onPart1("Day1Input.txt")
    }
}