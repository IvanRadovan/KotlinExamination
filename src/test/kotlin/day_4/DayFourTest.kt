package day_4

import FileReader
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DayFourTest{

    private val testPath = "src\\test\\kotlin\\day_4\\TestInput"
    private val testData = FileReader.read(testPath)

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



}