package day_5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DayFiveTest {

    @Test
    fun substringTest() {
        val code = "FBFBBFFRLR"
        var rowCode = code.substring(0, 7)
        var columnCode = code.substring(7)

        assertEquals(rowCode, "FBFBBFF")
        assertEquals(columnCode, "RLR")
    }

    @Test
    fun partitioningTest() {
        val rowCode = "FBFBBFF"
        val columnCode = "RLR"

        assertEquals(partitioning(rowCode, 0, 127), 44)
        assertEquals(partitioning(columnCode, 0, 7), 5)
    }

    @Test
    fun getIdTest() {
        assertEquals(357, "FBFBBFFRLR".seatId())
    }

    @Test
    fun missingSeatTest() {
        val list = listOf(1, 2, 3, 4, 5, 7, 8, 9)
        val missingNumber = missingSeat(list)

        assertEquals(6, missingNumber)
    }
}