package day_3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.nio.file.Paths
import kotlin.io.path.exists

class DayThreeKtTest {

    private val fileName = "src\\main\\kotlin\\day_3\\PuzzleInput.txt"
    private val data = readFile(fileName)


    @Test
    fun fileExists() {
        assertTrue(Paths.get(fileName).exists())
    }

    @Test
    fun readFileTest() {
        val size = 323
        assertEquals(data.size, size)
    }

    private fun testSlope(right: Int, down: Int): Long {
        val testMap = readFile("src\\test\\kotlin\\day_3\\TestInput.txt")
        val length = testMap[0].length
        var treeCounter = 0L
        var j = 0
        for (i in testMap.indices step down) {
            if (testMap[i][j] == '#')
                treeCounter++
            j += right
            j %= length
        }
        return treeCounter
    }

    @Test
    fun slopTest() {
        //  Right 1, down 1.
        //  Right 3, down 1. (This is the slope you already checked.)
        //  Right 5, down 1.
        //  Right 7, down 1.
        //  Right 1, down 2.

        // 2, 7, 3, 4, and 2 = (336)
        assertEquals(testSlope(1, 1), 2)
        assertEquals(testSlope(3, 1), 7)
        assertEquals(testSlope(5, 1), 3)
        assertEquals(testSlope(7, 1), 4)
        assertEquals(testSlope(1, 2), 2)

        val product: Long = testSlope(1, 1) * testSlope(3, 1) * testSlope(5, 1) * testSlope(7, 1) * testSlope(1, 2)
        assertEquals(product, 336)
    }
}