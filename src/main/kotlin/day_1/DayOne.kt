package day_1

import java.io.File

fun main() {

    val fileName = "src\\main\\kotlin\\day_1\\PuzzleInput.txt";
    val data = readFile(fileName);

    getPuzzleAnswer(data, 2020)
    getPuzzleAnswerPartTwo(data, 2020)

}

 fun readFile(fileName: String): List<Int> =
    File(fileName).bufferedReader()
        .readLines()
        .map { it.toInt() }

 fun getPuzzleAnswer(list: List<Int>, sum: Int) {
    for (i in list.indices) {
        for (j in i + 1..<list.size) {
            if (list[i] + list[j] == sum) {
                println("Puzzle Answer: ${list[i] * list[j]}")
            }
        }
    }
}


 fun getPuzzleAnswerPartTwo(list: List<Int>, sum: Int) {
    for (i in list.indices) {
        for (j in i + 1..< list.size) {
            for (k in j + 1..<list.size) {
                if (list[i] + list[j] + list[k] == sum) {
                    println("Puzzle Answer Part Two: ${list[i] * list[j] * list[k]}")
                }
            }
        }
    }
}