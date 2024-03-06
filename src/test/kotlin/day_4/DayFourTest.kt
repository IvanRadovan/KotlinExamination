package day_4

import FileReader
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.util.regex.Pattern

class DayFourTest {

    private val testPath = "src\\test\\kotlin\\day_4\\TestInput"
    private val pathInvalidData = "src\\test\\kotlin\\day_4\\InvalidInput"
    private val pathValidData = "src\\test\\kotlin\\day_4\\ValidInput"

    private val testData = FileReader.read(testPath)
    private val invalidData = FileReader.read(pathInvalidData)
    private val validData = FileReader.read(pathValidData)

    private val dataList = puzzleInput()

    @Test
    fun getDataInSequenceTest() {
        val list = getDataInSequence(testData)
        assertEquals(list.size, 4)
    }

    private fun isValidMissingCid(password: String): Boolean {
        val fields = password.split(" ")
        return fields.size == 7 && fields.none { it.startsWith("cid") }
    }

    private fun isValidAllFields(password: String): Boolean {
        val fields = password.split(" ")
        return fields.size == 8
    }

    @Test
    fun findValidFields() {
        val validPassportOne = "hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm"
        val validPassportTwo = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"
        val invalidPassport = "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in"

        assertTrue(isValidMissingCid(validPassportOne))
        assertTrue(isValidAllFields(validPassportTwo))
        assertFalse(isValidMissingCid(invalidPassport))
        assertFalse(isValidAllFields(invalidPassport))
    }

    @Test
    fun countValidPassportsTest() {
        assertEquals(countValidPassports(getDataInSequence(testData)), 2)
        assertEquals(countValidPassports(getDataInSequence(dataList)), 230)
    }

    @Test
    fun splitTest() {
        val field = "hcl:#ae17e1"
        val (key, value) = field.split(":", limit = 2)

        assertEquals(key, "hcl")
        assertEquals(value, "#ae17e1")
    }

    @Test
    fun validateHgtTest() {
        fun validHgt(value: String): Boolean = when {
            value.endsWith("cm") -> value.removeSuffix("cm").toIntOrNull() in 150..193
            value.endsWith("in") -> value.removeSuffix("in").toIntOrNull() in 59..76
            else -> false
        }

        assertTrue(validHgt("hgt:164cm".split(":")[1]))

        assertFalse(validHgt("hgt:164feet".split(":")[1]))
        assertFalse(validHgt("hgt:194cm".split(":")[1]))
        assertFalse(validHgt("hgt:55in".split(":")[1]))
    }

    @Test
    fun validateByrTest() {
        fun validByr(value: String) = ((value.length == 4) && (value.toInt() in 1920..2002))

        assertTrue(validByr("byr:2001".split(":")[1]))
        assertFalse(validByr("byr:2003".split(":")[1]))
        assertFalse(validByr("byr:10".split(":")[1]))
    }

    @Test
    fun validateIyrTest() {
        fun validIyr(value: String): Boolean = ((value.length == 4) && (value.toInt() in 2010..2020))

        assertTrue(validIyr("iyr:2015".split(":")[1]))
        assertFalse(validIyr("iyr:1999".split(":")[1]))
        assertFalse(validIyr("iyr:100".split(":")[1]))
    }

    @Test
    fun validatePidTest() {
        fun validPid(value: String): Boolean = value.length == 9 && value.all { it.isDigit() }

        assertTrue(validPid("pid:545766238".split(":")[1]))
        assertTrue(validPid("pid:000066238".split(":")[1]))
        assertFalse(validPid("pid:2351".split(":")[1]))
        assertFalse(validPid("pid:545766abc".split(":")[1]))
    }

    @Test
    fun validateEclTest() {
        fun validEcl(value: String) = value in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

        assertTrue(validEcl("ecl:hzl".split(":")[1]))
        assertFalse(validEcl("ecl:brown".split(":")[1]))
    }

    @Test
    fun validateEyrTest() {
        fun validEyr(value: String): Boolean = ((value.length == 4) && (value.toInt() in 2020..2030))

        assertTrue(validEyr("eyr:2022".split(":")[1]))
        assertFalse(validEyr("eyr:02021".split(":")[1]))
        assertFalse(validEyr("eyr:2031".split(":")[1]))
    }

    @Test
    fun validateCidTest() {
        fun validCid(value: String): Boolean = true

        assertTrue(validCid("cid:88".split(":")[1]))
    }

    @Test
    fun validateHclTest() {
        fun validHcl(value: String): Boolean = Pattern.compile("#[0-9a-fA-F]{6}").matcher(value).matches()

        assertTrue(validHcl("hcl:#ae17e1".split(":")[1]))
        assertFalse(validHcl("hcl:ae17e1".split(":")[1]))
        assertFalse(validHcl("hcl:#az17e1".split(":")[1]))
        assertFalse(validHcl("hcl:#ae17e".split(":")[1]))
    }

    @Test
    fun countValidPassportsPartTwoTest() {
        assertEquals(countValidPassportsPartTwo(getDataInSequence(invalidData)), 0)
        assertEquals(countValidPassportsPartTwo(getDataInSequence(validData)), 4)
        assertEquals(countValidPassportsPartTwo(getDataInSequence(dataList)), 156)
    }
}