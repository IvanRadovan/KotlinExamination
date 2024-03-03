package day_1

import FileReader

fun main() {

    val data = puzzleInput()
    println(getProduct(data))
    println(getProductPartTwo(data))

}

fun puzzleInput(): List<Int> = FileReader.read("src\\main\\kotlin\\day_1\\PuzzleInput.txt").map { it.toInt() }

fun getProduct(list: List<Int>): Int {
    for (i in list.indices) {
        for (j in i + 1..<list.size) {
            if (list[i] + list[j] == 2020) {
                return (list[i] * list[j])
            }
        }
    }
    return -1
}

fun getProductPartTwo(list: List<Int>): Long {
    for (i in list.indices) {
        for (j in i + 1..<list.size) {
            for (k in j + 1..<list.size) {
                if (list[i] + list[j] + list[k] == 2020) {
                    return (list[i] * list[j] * list[k]).toLong()
                }
            }
        }
    }
    return -1
}