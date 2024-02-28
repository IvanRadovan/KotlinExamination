package day_2

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.regex.Pattern


fun main() {

    println(validPasswordCount())


}

fun validPasswordCount(): Int {
    val lines = Files.readAllLines(Paths.get("src\\main\\kotlin\\day_2\\PuzzleInput.txt"))
    var result = 0
    for (line in lines) {
        val pattern = Pattern.compile("^(\\d+)-(\\d+) (\\w): (\\w+)$")
        val matcher = pattern.matcher(line)
        if (matcher.find()) {
            val start = matcher.group(1).toInt()
            val end = matcher.group(2).toInt()
            val character = matcher.group(3)[0]
            val password = matcher.group(4)

            var charCounter = 0

            for (c in password.toCharArray()) {
                if (c == character) {
                    charCounter++
                }
            }

            if (charCounter in start..end) {
                result++
            }
        }
    }
    return result
}
