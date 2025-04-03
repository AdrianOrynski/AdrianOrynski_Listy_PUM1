fun perm(lst: List<Int>): List<List<Int>> =
    if (lst.isEmpty()) listOf(emptyList())
    else lst.flatMap { num -> perm(lst-num).map { it + num } }
// Tworzę permutacje, usuwając aktualny element 'num' i dodając go na koniec każdej permutacji pozostałych elementów.

fun main () {
    val numbers = listOf(1, 2, 3)
    println(perm(numbers))

    print("Podaj liczby całkowite oddzielone średnikiem(;) : ")
    val list = readLine()?.split(";")?.mapNotNull { it.toIntOrNull() } ?: emptyList()
    println(perm(list))
}