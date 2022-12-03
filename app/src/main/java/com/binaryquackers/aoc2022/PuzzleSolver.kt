package com.binaryquackers.aoc2022

import android.app.Activity

abstract class PuzzleSolver {
    var message = ""
    lateinit var activity: Activity
    abstract fun onPart1Test()
    abstract fun onPart1Solution()
    abstract fun onPart2Test()
    abstract fun onPart2Solution()
}