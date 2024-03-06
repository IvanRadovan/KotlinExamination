package day_3

import FileReader

fun main() {

    println(countTrees())
}

private operator fun Pair<Int,Int>.plus(that: Pair<Int,Int>): Pair<Int,Int> =
        Pair(this.first+that.first, this.second+that.second)

fun puzzleInput(): List<String> = FileReader.read("src\\resources\\Day3PuzzleInput.txt")

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