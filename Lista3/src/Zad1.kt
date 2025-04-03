fun findDuplicates(lst: List<Int>): List<Int> {
    //Deklaracja dwóch mutowalnych zbiorów liczb całkowitych
    val onceRevealed = mutableSetOf<Int>()
    val duplicates = mutableSetOf<Int>()
    //Sprawdzam liczbę z listy
    for (number in lst) {
        //Jeżeli liczba znajduje się w zbiorze liczb raz ujawnionych
        if(onceRevealed.contains(number)) {
            //Dodaję tę liczbę do duplikatów
            duplicates.add(number)
        } else {
            //w przeciwnym wypadku dodaję ją do zbioru liczb raz ujawnionych
            onceRevealed.add(number)
        }
    }
    return duplicates.sorted()
}

fun main()
{
    //Usuwam "tab: " z deklaracji przykładu z listy
    val lst_p = listOf(0, 1, 1, 1, 4, 4, 4, 9, 3, 3, 3, 3, 3, 3)
    println(findDuplicates(lst_p))

    print("Podaj liczby całkowite oddzielone średnikiem(;) : ")
    val list = readLine()?.split(";")?.mapNotNull { it.toIntOrNull() } ?: emptyList()
    println(findDuplicates(list))
}