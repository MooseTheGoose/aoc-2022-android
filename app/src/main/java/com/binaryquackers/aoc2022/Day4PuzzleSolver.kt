package com.binaryquackers.aoc2022

import java.nio.charset.StandardCharsets

class Day4PuzzleSolver: PuzzleSolver() {
    private fun rangeToPair(range: String): Pair<Int, Int>? {
        var iRanges = range.split('-')
        if (iRanges.size < 2)
            return null
        return Pair(iRanges[0].toInt(), iRanges[1].toInt())
    }
    private fun Pair<Int,Int>.contains(other: Pair<Int, Int>): Boolean {
        return this.first <= other.first && other.second <= this.second
    }
    private fun Pair<Int,Int>.containsPoint(other: Int): Boolean {
        return other >= this.first && other <= this.second
    }
    private fun Pair<Int,Int>.intersects(other: Pair<Int,Int>): Boolean {
        return containsPoint(other.first) || containsPoint(other.second)
                || other.contains(this)
    }
    private fun solve(fname: String, full: Boolean): Int {
        var reader = java.io.BufferedReader(
            activity.assets!!.open(fname).reader(StandardCharsets.UTF_8)
        )
        var count = 0
        reader.forEachLine {
            var pair = it.split(',')
            if (pair.size < 2)
                return@forEachLine
            var range1 = rangeToPair(pair[0])
            var range2 = rangeToPair(pair[1])
            if (range1 == null || range2 == null)
                return@forEachLine
            if (full && range1.contains(range2) || range2.contains(range1))
                count++
            else if (!full && range1.intersects(range2))
                count++
        }
        return count
    }
    private fun onPart1(fname: String) {
        message = "Number of superset/subset pairs: ${solve(fname,true)}"
    }
    private fun onPart2(fname: String) {
        message = "Number of intersecting pairs: ${solve(fname,false)}"
    }
    override fun onPart1Test() {
        onPart1("Day4TestInput.txt")
    }
    override fun onPart1Solution() {
        onPart1("Day4Input.txt")
    }
    override fun onPart2Test() {
        onPart2("Day4TestInput.txt")
    }
    override fun onPart2Solution() {
        onPart2("Day4Input.txt")
    }
}