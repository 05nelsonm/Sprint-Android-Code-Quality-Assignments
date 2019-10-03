package com.lambdaschool.guidedcalculator

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MathUnitTest {

    private val math = mock(Math::class.java)
    private val calculator = Calculator(math)

    @Test
    fun calculatorAddition() {
        // Setup
        val num1 = 10
        val num2 = 17
        val expected = 27

        `when`(math.addIntegers(num1, num2)).thenReturn(expected)

        // Execute
        val sum = calculator.add(num1, num2)

        // Check
        assertEquals(expected, sum)
    }

    @Test
    fun viewModelSummation() {
        // Setup
        val num1 = 0
        val num2 = 7
        val expected = 7

        val viewModel = CalculatorViewModel()
        /*viewModel.calculator = calculator
        `when`(math.addIntegers(num1, num2)).thenReturn(expected)*/
        val calculator = mock(Calculator::class.java)
        `when`(calculator.add(num1, num2)).thenReturn(expected)
        viewModel.calculator = calculator


        // Execute
        val sum = viewModel.summation(num1, num2)

        // Check
        assertEquals(expected, sum)
    }

    @Test
    fun testAddIntegers() {
        // Setup
        val num1 = 1
        val num2 = 5
        val expected = 6
        val math = Math()

        // Execute the code under test
        val sum = math.addIntegers(num1, num2)

        // Make assertions on the result
        assertEquals(expected, sum)
    }

    @Test
    fun testSubtraceIntegers() {
        // Setup
        val num1 = 5
        val num2 = 1
        val expected = 4
        val math = Math()

        // Execute the code under test
        val sum = math.subtractIntegers(num1, num2)

        // Make assertions on the result
        assertEquals(expected, sum)
    }

    @Test
    fun testMultiplyIntegers() {
        // Setup
        val num1 = 2
        val num2 = 5
        val expected = 10
        val math = Math()

        // Execute the code under test
        val product = math.multiplyIntegers(num1, num2)

        // Make assertions on the result
        assertEquals(expected, product)
    }

    @Test
    fun testMultiplyIntegersB() {
        // Setup
        val num1 = 21
        val num2 = 100
        val expected = 2100
        val math = Math()

        // Execute the code under test
        val product = math.multiplyIntegers(num1, num2)

        // Make assertions on the result
        assertEquals(expected, product)
    }

    @Test
    fun testDivideIntegers() {
        // Setup
        val num1 = 10
        val num2 = 2
        val expected = 5
        val math = Math()

        // Execute the code under test
        val division = math.divideIntegers(num1, num2)

        // Make assertions on the result
        assertEquals(expected, division)
    }

}