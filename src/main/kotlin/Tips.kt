fun main() {


    val ints = listOf(1, 2, -3)
    println( ints.any { it > 0 } )


    val h2 = GenericHolder(1)
    val i: Int = h2.getTheValue() // ger 1
    val h3 = GenericHolder("Chartreuse")
    val s: String = h3.getTheValue() // ger “Chartreuse”
}

// Generic class
class GenericHolder<T> (val value: T) {
    fun getTheValue(): T = value
}


// Generic extension method with a functional interface parameter, that check a certain condition in a generic List
fun <T> List<T>.any (predicate: (T) -> Boolean): Boolean
{
    for (element in this) {
        if (predicate(element))
            return true
    }
    return false
}
