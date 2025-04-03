fun srt(list: List<String>): List<Pair<String, List<String>>> =
    list.filter { it.length % 2 == 0 } // Filtruje tylko parzystą długość
        .groupBy { it[0].lowercase() } // Grupuje po pierwszej literze (ignorując wielkość liter)
        .map { (key, value) -> key to value.sorted() } // Mapuje na pary, sortując listy
        .sortedBy { it.first } // Sortuje pary według pierwszej litery


fun main() {
    println(srt(listOf("cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")))
}