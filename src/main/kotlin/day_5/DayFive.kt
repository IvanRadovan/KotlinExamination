package day_5


fun main() {


    val s = "FBFBBFFRLR"
    val firstBit = s.substring(0,7)
    val secondBit = s.substring(7)


    var row = binarySearch(firstBit, 0, 127)
    var column = binarySearch(secondBit, 0, 7)

    println(row)
    println(column)

//    val id = (row * 8 + column)
//    println(id)

}

fun binarySearch(seat: String, start: Int, end: Int): Int {

    // Start by considering the whole range, rows 0 through 127.

    //F means to take the lower half, keeping rows 0 through 63.
    //B means to take the upper half, keeping rows 32 through 63.
    //F means to take the lower half, keeping rows 32 through 47.
    //B means to take the upper half, keeping rows 40 through 47.
    //B keeps rows 44 through 47.
    //F keeps rows 44 through 45.
    //The final F keeps the lower of the two, row 44.

    var mutableStart = start
    var mutableEnd = end
    var list: List<Int> = (start..end).toMutableList()

    for (char in seat) {
        val mid = start + (end - start) / 2
        if (char == 'F') {
            mutableEnd = mid
            list = list.dropWhile { it > mutableEnd }
        } else if (char == 'B') {
            list = list.dropWhile { it < mutableStart }
            mutableStart = mid + 1
        }
    }

    println(list)
    return -1;
}