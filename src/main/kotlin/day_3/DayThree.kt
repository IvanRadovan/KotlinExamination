package day_3

import java.io.File

fun main() {

    println(countTrees())

}

fun countTrees(): Int {
    val fileName = "src\\main\\kotlin\\day_3\\PuzzleInput.txt"
    val map = readFile(fileName)

    val tree = '#'
    val length = map[0].length
    var treeCounter = 0
    var j = 0

    for (i in map.indices) {
        if (map[i][j] == tree)
            treeCounter++

        j += 3
        j %= length
    }
    return treeCounter
}


fun readFile(fileName: String): List<String> = File(fileName).bufferedReader().readLines()