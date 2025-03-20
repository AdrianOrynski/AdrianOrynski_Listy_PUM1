fun <A> setHead(lst: List<A>, item: A): List<A> {
    if (lst.isEmpty()) throw IllegalStateException("Empty list")
    return listOf(item) + lst.drop(1)
}

fun main() {
    //Przykład z listy
    println(setHead(listOf(1, 2, 3), 5))

    print("Podaj elementy listy oddzielone średnikiem: ")
    val input = readLine()

    val lista = input?.split(";")?.map { it.trim() }?.filter { it.isNotEmpty() } ?: emptyList()

    print("Podaj nowy pierwszy element: ")
    val nowyElement = readLine()

    if (nowyElement != null) {
        try {
            val wynik = setHead(lista, nowyElement)
            println(wynik)
        } catch (e: IllegalStateException) {
            println("Błąd: ${e.message}")
        }
    } else {
        println("Nie podano nowego pierwszego elementu")
    }
}