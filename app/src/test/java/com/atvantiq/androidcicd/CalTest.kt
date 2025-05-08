package com.atvantiq.androidcicd

import org.junit.Test
import org.junit.Assert.*

class CalTest {
    private val cal = Cal()

    @Test
    fun isAddCorrect(){
        assertEquals(4,cal.add(2,2))
    }

    @Test
    fun isSubractCorrent(){
        assertEquals(6,cal.subract(10,4))
    }

    @Test
    fun isMultCorrent(){
        assertEquals(16,cal.multi(4,4))
    }
}