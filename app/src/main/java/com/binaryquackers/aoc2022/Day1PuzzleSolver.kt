package com.binaryquackers.aoc2022

import java.nio.charset.StandardCharsets

class Day1PuzzleSolver: PuzzleSolver() {
    fun solve(fname: String): LongArray {
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
    override fun onTest() {
        var solution = solve("Day1TestInput.txt")
        message = "Max Calories\n${solution[0]}"
    }
    override fun onPart1() {
        var solution = solve("Day1Input.txt")
        message = "Max Calories\n${solution[0]}"
    }
    override fun onPart2() {
        var solution = solve("Day1Input.txt")
        message = "Max 3 Calories Total\n${solution[0]+solution[1]+solution[2]}"
    }
}