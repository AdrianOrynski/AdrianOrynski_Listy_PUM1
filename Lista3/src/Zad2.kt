fun addToBoolean(): Map<Int, Boolean> {
    val divisibleByTwo = mutableMapOf<Int, Boolean>()
    for (i in 1..20) {
        divisibleByTwo[i] = i % 2 == 0
    }
    return divisibleByTwo
}

fun main() {
    println(addToBoolean())
}