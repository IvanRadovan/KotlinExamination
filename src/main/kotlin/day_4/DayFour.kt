package day_4

import java.util.regex.Pattern

fun main() {

    println(countValidPassports(getDataInSequence(puzzleInput())))
    println(countValidPassportsPartTwo(getDataInSequence(puzzleInput())))
}

fun puzzleInput(): List<String> = FileReader.read("src\\resources\\Day4PuzzleInput.txt")

fun getDataInSequence(list: List<String>): List<String> {
    var startSequencer = 0
    val rows: MutableList<String> = mutableListOf()
    var i = 0

    while (i < list.size) {
        if (list[i].isEmpty()) {
            rows.add(list.slice(startSequencer..i).joinToString(separator = " ").trim())
            startSequencer = i
        }
        i++
    }
    rows.add(list.slice(startSequencer..<i).joinToString(separator = " ").trim())
    return rows.toList()
}

fun countValidPassports(list: List<String>): Int {
    var counter = 0
    for (i in list.indices) {
        val row = list[i].split(" ")
        if (row.size == 7 && row.none { it.startsWith("cid") }) {
            counter++
        } else if (row.size == 8) {
            counter++
        }
    }
    return counter
}

fun validateFields(key: String, value: String): Boolean =
    when (key) {
        "byr" -> ((value.length == 4) && (value.toInt() in 1920..2002))
        "iyr" -> ((value.length == 4) && (value.toInt() in 2010..2020))
        "eyr" -> ((value.length == 4) && (value.toInt() in 2020..2030))
        "hgt" -> when {
            value.endsWith("cm") -> value.removeSuffix("cm").toIntOrNull() in 150..193
            value.endsWith("in") -> value.removeSuffix("in").toIntOrNull() in 59..76
            else -> false
        }
        "hcl" -> Pattern.compile("#[0-9a-fA-F]{6}").matcher(value).matches()
        "ecl" -> value in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
        "pid" -> value.length == 9 && value.all { it.isDigit() }
        "cid" -> true
        else -> false
    }


fun countValidPassportsPartTwo(list: List<String>): Int {
    var counter = 0
    for (i in list.indices) {
        val fields = list[i].split(" ")
        if ((fields.size == 7 && fields.none { it.startsWith("cid") }) || fields.size == 8) {
            val checkAll = fields.all { field ->
                val (key, value) = field.split(":", limit = 2)
                validateFields(key, value)
            }
            if (checkAll)
                counter++
        }
    }
    return counter
}