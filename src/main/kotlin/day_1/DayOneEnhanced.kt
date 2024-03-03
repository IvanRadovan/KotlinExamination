package day_1

// https://todd.ginsberg.com/post/advent-of-code/2020/day1/

fun main() {

    val data = puzzleInput()
    println(getProductEnhanced(data))
    println(getProductPartTwoEnhanced(data))
}

fun getProductEnhanced(input: List<Int>): Long {
    return input.mapIndexedNotNull { index, number -> input
            .drop(index + 1)
            .firstOrNull { number + it == 2020 }
            ?.let { number * it }
            ?.toLong()
    }.firstOrNull() ?: -1
}

fun getProductPartTwoEnhanced(input: List<Int>): Long {
    return input.mapIndexedNotNull { index1, n1 -> input
            .drop(index1 + 1)
            .mapIndexedNotNull { index2, n2 -> input
                    .drop(index2 + 1)
                    .firstOrNull { n1 + n2 + it == 2020 }
                    ?.let { n1 * n2 * it }
                    ?.toLong()
            }.firstOrNull()
    }.firstOrNull() ?: -1
}
