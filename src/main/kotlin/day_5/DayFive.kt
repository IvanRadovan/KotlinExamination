package day_5


fun main() {

    // Start by considering the whole range, rows 0 through 127.

    //F means to take the lower half, keeping rows 0 through 63.
    //B means to take the upper half, keeping rows 32 through 63.
    //F means to take the lower half, keeping rows 32 through 47.
    //B means to take the upper half, keeping rows 40 through 47.
    //B keeps rows 44 through 47.
    //F keeps rows 44 through 45.
    //The final F keeps the lower of the two, row 44.

    val path = "src\\main\\kotlin\\day_5\\PuzzleInput"
    var list = FileReader.read(path)

    list.map { it.seatId() }
//    println(list.map { it.seatId() }.sortedDescending()[0])

}

fun String.seatId(): Int {
    var rowCode = this.substring(0, 7)
    var columnCode = this.substring(7)

    var row = partitioning(rowCode, 0, 127)
    var column = partitioning(columnCode, 0, 7)

    return (row * 8) + column
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
