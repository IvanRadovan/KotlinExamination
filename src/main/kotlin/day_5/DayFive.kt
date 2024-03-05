package day_5


fun main() {

    val path = "src\\main\\kotlin\\day_5\\PuzzleInput"
    val list = FileReader.read(path).map { it.seatId() }.sorted()

    val highestId = list[list.size - 1]
    val missingSeat = missingSeat(list)
    println(highestId)
    println(missingSeat)

}

fun partitioning(seatCode: String, start: Int, end: Int): Int {
    var startCopy = start
    var endCopy = end
    for (char in seatCode) {
        val mid = startCopy + (endCopy - startCopy) / 2
        if ((char == 'F').or(char == 'L')) {
            endCopy = mid
        } else if ((char == 'B').or(char == 'R')) {
            startCopy = mid + 1
        }
    }
    return startCopy
}

fun String.seatId(): Int {
    val rowCode = this.substring(0, 7)
    val columnCode = this.substring(7)

    val row = partitioning(rowCode, 0, 127)
    val column = partitioning(columnCode, 0, 7)

    return (row * 8) + column
}

fun missingSeat(list: List<Int>): Int {
    var i = 0;
    while (i < list.size) {
        if (list[i] + 1 != list[i + 1]) {
            break
        }
        i++
    }
    return list[i] + 1
}
