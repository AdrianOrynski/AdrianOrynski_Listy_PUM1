fun suma(a: List<Int>): Int = a.filter { it > 0 }.sum()

fun main () {
    //Przykład z listy
    println(suma(listOf( 1, -4, 12, 0, -3, 29, -150)))

    print("Podaj liczby całkowite oddzielone średnikiem(;) : ")
    val list = readLine()?.split(";")?.mapNotNull { it.toIntOrNull() } ?: emptyList()
    println(suma(list))
}