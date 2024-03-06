package day_2

import FileReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.nio.file.Paths
import java.util.regex.Pattern
import kotlin.io.path.exists

class DayTwoTest {

    private val path = "src\\resources\\Day2PuzzleInput.txt"
    private val data = FileReader.read(path)
    private val inputTest = "6-14 f: fffdxmfffjfffmffff"
    private val startTest = 6
    private val endTest = 14
    private val charTest = 'f'
    private val passwordTest = "fffdxmfffjfffmffff"

    @Test
    fun fileExists() {
        assertTrue(Paths.get(path).exists())
    }

    @Test
    fun readFileTest() {
        val size = 1000
        assertEquals(data.size, size)
    }


    @Test
    fun validateRegex() {
        val pattern = Pattern.compile("^(\\d+)-(\\d+) (\\w): (\\w+)$")
        val matcher = pattern.matcher(inputTest)
        var start: Int? = null
        var end: Int? = null
        var character: Char? = null
        var password: String? = null

        if (matcher.find()) {
            start = matcher.group(1).toInt()
            end = matcher.group(2).toInt()
            character = matcher.group(3)[0]
            password = matcher.group(4)
        }

        assertEquals(start, startTest)
        assertEquals(end, endTest)
        assertEquals(character, charTest)
        assertEquals(password, passwordTest)
    }


    @Test
    fun validPasswordCount() {
        val charCounter = passwordTest.toCharArray().count { it == charTest }

        assertEquals(charCounter, 13)
        assertTrue(charCounter in startTest..endTest)
    }

    @Test
    fun validPasswordCountPartTwo() {
        // 1-3 a: abcde
        val validPassword = "abcde"
        assertTrue((validPassword[1 - 1] == 'a') xor (validPassword[3 - 1] == 'a'))
    }

    @Test
    fun inRangeCountTest(){
        assertEquals(inRangeCount(), 500)
    }

    @Test
    fun inPositionCountTest(){
        assertEquals(inPositionCount(), 313)
    }

}