package day_4

import java.io.File

// https://todd.ginsberg.com/post/advent-of-code/2020/day4/

class DayFourEnhanced {

     val inputs: List<String> = File("src\\resources\\Day4PuzzleInput.txt")
            .bufferedReader()
            .readText()
            .trimIndent()
            .split("\n\n")

    private val keyFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    private val fieldRegexOption = listOf(
            """\bbyr:(19[2-9][0-9]|200[0-2])\b""",
            """\biyr:(201[0-9]|2020)\b""",
            """\beyr:(202[0-9]|2030)\b""",
            """\bhgt:((1([5-8][0-9]|9[0-3])cm)|((59|6[0-9]|7[0-6])in))\b""",
            """\bhcl:#[0-9a-f]{6}\b""",
            """\becl:(amb|blu|brn|gry|grn|hzl|oth)\b""",
            """\bpid:[0-9]{9}\b"""
    ).map { it.toRegex() }

    fun getRequiredFieldCount(): Int = inputs.count { e -> keyFields.all { f -> e.contains(f) } }

    fun getValidPassportCount(): Int = inputs.count { e -> fieldRegexOption.all { it.containsMatchIn(e) } }
}

fun main() {

    val puzzle = DayFourEnhanced()
    println(puzzle.getRequiredFieldCount())
    println(puzzle.getValidPassportCount())
}