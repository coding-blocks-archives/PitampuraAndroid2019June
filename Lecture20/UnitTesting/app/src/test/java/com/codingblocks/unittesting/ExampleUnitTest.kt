package com.codingblocks.unittesting

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun fare_is_correct() {
        assertEquals(85f,FareUtils.calcFare(5f,15f))
    }

    @Test
    fun fare_is_high() {
        assertNotEquals(85f,FareUtils.calcFare(20f,135f))
    }
}
