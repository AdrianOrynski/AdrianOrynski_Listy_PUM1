fun countElements(lists: List<List<String>>): Map<String, Int> = lists.flatten().groupingBy { it }.eachCount()

fun main () {
    //Przykład z listy
    println(countElements(listOf(listOf("a", "b", "c"), listOf("c", "d", "f"), listOf("d", "f", "g"))))

    print("Podaj listy słów, oddzielając je średnikiem i spacją (np. 'a b c; c d f; d f g'): ")

    val lists = readLine()
        ?.split(";")  // Dzielimy na listy po średniku
        ?.map { it.trim().split(" ") } // Każdą podlistę dzielimy po spacjach
        ?: emptyList()

    val result = countElements(lists)
    println(result)
}