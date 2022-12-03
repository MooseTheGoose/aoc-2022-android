package com.binaryquackers.aoc2022

import android.app.Activity

abstract class PuzzleSolver {
    var message = ""
    lateinit var activity: Activity
    abstract fun onTest()
    abstract fun onPart1()
    abstract fun onPart2()
}