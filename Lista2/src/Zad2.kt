val <T> List<T>.tail: List<T>
    get() = if (this.isNotEmpty()) this.drop(1) else emptyList()

val <T> List<T>.head: T?
    get() = this.firstOrNull()

fun main() {
    //Przykład
    println("Head: ${listOf(1,2,3,4).head}")
    println("Tail: ${listOf(1,2,3,4).tail}")

    print("Podaj elementy listy oddzielone średnikiem: ")
    val input = readLine()

    val lista = input?.split(";")?.map { it.trim() }?.filter { it.isNotEmpty() } ?: emptyList()

    if (lista.isNotEmpty()) {
        println("Head: ${lista.head}")
        println("Tail: ${lista.tail}")
    } else {
        println("Podano pustą listę lub niepoprawne dane")
    }
}
