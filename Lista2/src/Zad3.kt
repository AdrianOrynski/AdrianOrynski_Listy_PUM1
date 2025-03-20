fun <A> isSorted(lst: List<A>, order: (A, A) -> Boolean): Boolean {
    // Jeśli lista ma mniej niż 2 elementy, to uznaję ją za posortowaną
    if (lst.size < 2) return true

    // Tworzę pary sąsiadujących elementów i sprawdzam, czy wszystkie spełniają podaną funkcję porównawczą
    return lst.zip(lst.drop(1)).all { (a, b) -> order(a, b) }
}

fun main() {
    //Przykłady z listy
    println(isSorted(listOf(1,2,3,4), {i:Int, j: Int -> i < j}))
    println(isSorted(listOf(1,1,1,1), {i:Int, j: Int -> i == j}))
    println(isSorted(listOf("ahyyhh", "bkjn", "cnn", "duu"), {i:String, j: String -> i.first() < j.first()}))

    print("Podaj elementy listy oddzielone średnikiem: ")
    val input = readLine()

    // Dzielę input na elementy, usuwam spacje i ignoruję puste wartości
    val lista = input?.split(";")?.map { it.trim() }?.filter { it.isNotEmpty() } ?: emptyList()

    // Jeśli lista jest pusta, informuję o tym i kończę program
    if (lista.isEmpty()) {
        println("Podano pustą listę, uznaję ją za posortowaną: true")
        return
    }

    print("Wybierz tryb sortowania (1 - rosnąco liczby, 2 - wszystkie równe, 3 - pierwsza litera rosnąco): ")
    when (readLine()?.trim()) {
        // Przekształcam elementy listy na liczby i sprawdzam, czy są posortowane rosnąco
        "1" -> println(isSorted(lista.mapNotNull { it.toIntOrNull() }, { i, j -> i < j }))

        // Sprawdzam, czy wszystkie elementy listy są równe
        "2" -> println(isSorted(lista, { i, j -> i == j }))

        // Sprawdzam, czy lista jest posortowana według pierwszej litery każdego elementu
        "3" -> println(isSorted(lista, { i, j -> i.first() < j.first() }))

        // Jeśli użytkownik podał niepoprawny tryb, informuję go o błędzie
        else -> println("Niepoprawny wybór trybu sortowania")
    }
}
