package com.binaryquackers.aoc2022

import java.nio.charset.StandardCharsets

class Day2PuzzleSolver: PuzzleSolver() {
    enum class Result {
        Lose,
        Draw,
        Win;
    }
    enum class Choice {
        Rock,
        Paper,
        Scissors;

        private fun idx(): Int {
            return when(this) {
                Rock -> 0
                Paper -> 1
                Scissors -> 2
            }
        }

        fun result(opponent: Choice): Result {
            var matrix = arrayOf(
                Result.Draw, Result.Lose, Result.Win,
                Result.Win, Result.Draw, Result.Lose,
                Result.Lose, Result.Win, Result.Draw,
            )
            return matrix[this.idx() * 3 + opponent.idx()]
        }

        fun inverse(result: Result): Choice {
            var matrix = arrayOf(
                Choice.Paper, Choice.Rock, Choice.Scissors,
                Choice.Scissors, Choice.Paper, Choice.Rock,
                Choice.Rock, Choice.Scissors, Choice.Paper,
            )
            var idx = when(result) {
                Result.Lose -> 0
                Result.Draw -> 1
                Result.Win -> 2
            }
            return matrix[this.idx() * 3 + idx]
        }
    }
    fun solve(fname: String, inverse: Boolean): Int {
        var reader = java.io.BufferedReader(
        activity.assets!!.open(fname).reader(StandardCharsets.UTF_8))
        var score = 0
        reader.forEachLine {
            var fields = it.trim().split(' ')
            if (fields.size < 2)
                return@forEachLine
            var opponent = when(fields[0][0]) {
                'A' -> Choice.Rock
                'B' -> Choice.Paper
                'C' -> Choice.Scissors
                else -> return@forEachLine
            }
            var ally = if(inverse) when(fields[1][0]) {
                'X' -> opponent.inverse(Result.Win)
                'Y' -> opponent.inverse(Result.Draw)
                'Z' -> opponent.inverse(Result.Lose)
                else -> return@forEachLine
            } else when(fields[1][0]) {
                'X' -> Choice.Rock
                'Y' -> Choice.Paper
                'Z' -> Choice.Scissors
                else -> return@forEachLine
            }
            score += when(ally.result(opponent)) {
                Result.Win -> 6
                Result.Draw -> 3
                Result.Lose -> 0
            }
            score += when(ally) {
                Choice.Rock -> 1
                Choice.Paper -> 2
                Choice.Scissors -> 3
            }
        }
        return score
    }
    override fun onTest() {
        message = "Strategy Score: ${solve("Day2TestInput.txt", true)}"
    }
    override fun onPart1() {
        message = "Strategy Score: ${solve("Day2Input.txt", false)}"
    }
    override fun onPart2() {
        message = "Strategy Score: ${solve("Day2Input.txt", true)}"
    }
}