package day_2

import java.io.File
import java.util.regex.Pattern


fun main() {

    println(validPasswordCount())
    println(validPasswordCountPartTwo())


}


fun validPasswordCount(): Int {
    val lines = readFile()
    var result = 0
    for (line in lines) {
        val pattern = Pattern.compile("^(\\d+)-(\\d+) (\\w): (\\w+)$")
        val matcher = pattern.matcher(line)
        if (matcher.find()) {
            val start = matcher.group(1).toInt()
            val end = matcher.group(2).toInt()
            val character = matcher.group(3)[0]
            val password = matcher.group(4)

            val charCounter = password.toCharArray().count { it == character }
            if (charCounter in start..end) {
                result++
            }
        }
    }
    return result
}

fun validPasswordCountPartTwo(): Int {
    val lines = readFile()
    var result = 0
    for (line in lines) {
        val pattern = Pattern.compile("^(\\d+)-(\\d+) (\\w): (\\w+)$")
        val matcher = pattern.matcher(line)
        if (matcher.find()) {
            val start = matcher.group(1).toInt()
            val end = matcher.group(2).toInt()
            val character = matcher.group(3)[0]
            val password = matcher.group(4)

            if ((password[start - 1] == character) xor (password[end - 1] == character)) {
                result++
            }
        }
    }
    return result
}

fun readFile(): List<String> = File("src\\main\\kotlin\\day_2\\PuzzleInput.txt")
    .bufferedReader()
    .readLines()
