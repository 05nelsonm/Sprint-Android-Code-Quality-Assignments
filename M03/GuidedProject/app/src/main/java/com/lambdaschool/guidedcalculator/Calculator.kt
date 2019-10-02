package com.lambdaschool.guidedcalculator

class Calculator(private val math: Math) {
    fun add(a: Int, b: Int): Int {
        return math.addIntegers(a, b)
    }

/*    fun multiplyIntegers(a: Int, b: Int): Int {
        return a * b
    }*/
}