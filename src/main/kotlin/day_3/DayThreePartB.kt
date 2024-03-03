package day_3


fun main() {

    val product: Long = slope(1, 1) * slope(3, 1) * slope(5, 1) * slope(7, 1) * slope(1, 2)
    println(product)
}

fun slope(right: Int, down: Int): Long {
    val map = puzzleInput()

    val tree = '#'
    val length = map[0].length
    var treeCounter = 0L
    var j = 0

    for (i in map.indices step down) {
        if (map[i][j] == tree)
            treeCounter++

        j += right
        j %= length
    }
    return treeCounter
}

