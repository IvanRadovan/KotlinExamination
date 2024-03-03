package day_3

import FileReader

fun main() {

    println(countTrees())
}

fun puzzleInput(): List<String> = FileReader.read("src\\main\\kotlin\\day_3\\PuzzleInput.txt")

fun countTrees(): Int {
    val map = puzzleInput()
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