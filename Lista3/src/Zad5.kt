fun evenPositiveSquare(list: List<Int>): List<Int> =
    list.map { if (it < 0) 0 else it }  // Zamieniam liczby ujemne na 0
        .mapIndexed { index, value -> if (index % 2 == 1 && value > 0) value * value else null }
        .filterNotNull()  // Usuwamy wartości null

fun main () {
    //Przykład z listy
    println(evenPositiveSquare(listOf(1, 2, 3, 5, -6, -1, -1, 2, 3)))

    print("Podaj liczby całkowite oddzielone średnikiem(;) : ")
    val list = readLine()?.split(";")?.mapNotNull { it.toIntOrNull() } ?: emptyList()
    println(evenPositiveSquare(list))
}