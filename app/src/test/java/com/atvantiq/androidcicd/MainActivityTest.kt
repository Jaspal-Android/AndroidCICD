package com.atvantiq.androidcicd

import org.junit.Assert.*
import org.junit.Test

class MainActivityTest {

    private val mainActivity = MainActivity()

    @Test
    fun testMultiplyNumbers() {
        val result = mainActivity.multiplyNumbers(3, 4)
        assertEquals(12, result)
    }

    @Test
    fun testDivideNumbers() {
        val result = mainActivity.divideNumbers(10, 2)
        assertEquals(5, result)
    }

    @Test(expected = ArithmeticException::class)
    fun testDivideNumbersByZero() {
        mainActivity.divideNumbers(10, 0)
    }

    @Test
    fun testSubtractNumbers() {
        val result = mainActivity.subtractNumbers(10, 5)
        assertEquals(5, result)
    }

    @Test
    fun testAddTwoNumbers() {
        val result = mainActivity.addTwoNumbers(3, 7)
        assertEquals(10, result)
    }
}