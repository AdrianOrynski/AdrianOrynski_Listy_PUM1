fun <A> tailToHead(lst: List<A>): List<A> {
    if (lst.isEmpty()) throw IllegalStateException("Empty list")
    return listOf(lst.last()) + lst.dropLast(1)
}

fun main() {
    //Przykład z listy
    println(tailToHead(listOf(1,2,3)))

    print("Podaj elementy listy oddzielone średnikiem: ")
    val input = readLine()

    val lista = input?.split(";")?.map { it.trim() }?.filter { it.isNotEmpty() } ?: emptyList()

    try {
        val wynik = tailToHead(lista)
        println(wynik)
    } catch (e: IllegalStateException) {
        println("Błąd: ${e.message}")
    }
}
