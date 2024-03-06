package day_1

import FileReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Paths
import kotlin.io.path.exists

class DayOneTest {

    private val path = "src\\resources\\Day1PuzzleInput.txt"
    private val list = FileReader.read(path).map { it.toInt() }
    private val sum = 2020

    @Test
    fun fileExists() {
        assertTrue(Paths.get(path).exists())
    }

    @Test
    fun readFileTest() {
        val size = 200
        val inputs = File(path).bufferedReader()
            .readLines()
            .map { it.toInt() }

        assertEquals(inputs.size, size)
    }

    @Test
    fun getProductTest() {
        val foundMatch = 1
        val products = mutableListOf<List<Int>>()

        for (i in list.indices) {
            for (j in i + 1..<list.size) {
                if (list[i] + list[j] == sum) {
                    products.add(listOf(list[i], list[j]))
                }
            }
        }

        val firstValue = products[0][0]
        val secondValue = products[0][1]

        assertEquals(products.size, foundMatch)
        assertEquals((firstValue + secondValue), 2020)
        assertEquals((firstValue * secondValue), 997899)
    }

    @Test
    fun getProductPartTwoTest() {
        val foundMatch = 1
        val products = mutableListOf<List<Int>>()

        for (i in list.indices) {
            for (j in i + 1..<list.size) {
                for (k in j + 1..<list.size) {
                    if (list[i] + list[j] + list[k] == sum) {
                        products.add(listOf(list[i], list[j], list[k]))
                    }
                }
            }
        }

        val firstValue = products[0][0]
        val secondValue = products[0][1]
        val thirdValue = products[0][2]

        assertEquals(products.size, foundMatch)
        assertEquals((firstValue + secondValue + thirdValue), 2020)
        assertEquals((firstValue * secondValue * thirdValue), 131248694)
    }

    @Test
    fun getProductEnhancedTest() {
        assertEquals(getProductEnhanced(list), 997899)
    }

    @Test
    fun getProductPartTwoEnhancedTest() {
        assertEquals(getProductPartTwoEnhanced(list), 131248694)
    }
}