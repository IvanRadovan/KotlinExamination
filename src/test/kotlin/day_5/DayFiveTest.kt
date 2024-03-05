package day_5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DayFiveTest {



    //F means to take the lower half, keeping rows 0 through 63.
    //B means to take the upper half, keeping rows 32 through 63.
    //F means to take the lower half, keeping rows 32 through 47.
    //B means to take the upper half, keeping rows 40 through 47.
    //B keeps rows 44 through 47.
    //F keeps rows 44 through 45.
    //The final F keeps the lower of the two, row 44.


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
}