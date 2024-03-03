package day_2

// https://todd.ginsberg.com/post/advent-of-code/2020/day2/

data class PasswordData(val range: IntRange, val character: Char, val password: String)

fun getPassword(row: String): PasswordData {
    val pattern = "^(\\d+)-(\\d+) (\\w): (\\w+)$".toRegex()
    val (start, end, char, password) = pattern.find(row)!!.destructured
    return PasswordData(start.toInt()..end.toInt(), char.first(), password)
}

fun inRangeCount(): Int = puzzleInput()
        .map{ s -> getPassword(s) }
        .count { passwordData ->
            val count = passwordData.password.count { it == passwordData.character }
            count in passwordData.range
        }

fun inPositionCount(): Int = puzzleInput()
        .map{ s -> getPassword(s) }
        .count { (it.password[it.range.first-1] == it.character) xor (it.password[it.range.last-1] == it.character)  }

fun main() {

    println(inRangeCount())
    println(inPositionCount())
}
