package com.binaryquackers.aoc2022

import java.nio.charset.StandardCharsets

class Day5PuzzleSolver: PuzzleSolver() {
    private fun solve(fname: String, moveAll: Boolean): String {
        var reader = java.io.BufferedReader(
            activity.assets!!.open(fname).reader(StandardCharsets.UTF_8)
        )
        var crates: MutableList<MutableList<Char>> = mutableListOf()
        var state = 0
        reader.forEachLine {
            if (state == 0) {
                if (it.isNotEmpty()) {
                    var nFields = (it.length / 4) + 1;
                    for (i in crates.size until nFields)
                        crates.add(mutableListOf())
                    if (!it.contains('[')) {
                        state = 1
                        for (crate in crates)
                            crate.reverse()
                        return@forEachLine
                    }
                    for (i in 0 until nFields)
                        if (it[i * 4] == '[')
                            crates[i].add(it[i * 4 + 1])
                }
            } else if (state == 1) {
                var insnFields = it.split(' ')
                if (insnFields.size >= 6) {
                    var num = insnFields[1].toInt()
                    var prev = insnFields[3].toInt() - 1
                    var next = insnFields[5].toInt() - 1

                    if (moveAll) {
                        var prevList = crates[prev]
                        for (i in 0 until num) {
                            crates[next].add(prevList[prevList.size-num+i])
                        }
                        for (i in 0 until num) {
                            prevList.removeLast()
                        }
                    } else {
                        for (i in 0 until num) {
                            crates[next].add(crates[prev].last())
                            crates[prev].removeLast()
                        }
                    }
                }
            }
        }
        var msg = ""
        for (crate in crates) {
            msg += crate.last()
        }
        return msg
    }
    private fun onPart1(fname: String) {
        message = "Message: ${solve(fname, false)}"
    }
    private fun onPart2(fname: String) {
        message = "Message: ${solve(fname, true)}"
    }
    override fun onPart1Test() {
        onPart1("Day5TestInput.txt")
    }
    override fun onPart1Solution() {
        onPart1("Day5Input.txt")
    }
    override fun onPart2Test() {
        onPart2("Day5TestInput.txt")
    }
    override fun onPart2Solution() {
        onPart2("Day5Input.txt")
    }
}