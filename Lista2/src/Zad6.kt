fun check(N: Int, list: List<Int>): Int {
    // Iteruję przez listę, zaczynając od indeksu N (pierwsza liczba po preambule)
    for (i in N until list.size) {
        val preambula = list.subList(i - N, i) // Pobieram aktualną preambułę
        val target = list[i] // Liczba, którą sprawdzam

        // Tworzę zbiór liczb preambuły, aby łatwo wyszukiwać sumy
        val sums = mutableSetOf<Int>()
        var found = false

        // Tworzę wszystkie możliwe sumy dwóch różnych liczb w preambule
        for (j in preambula.indices)  { //indices -> lista indeksów (size -1)
            for (k in j + 1 until preambula.size) { //do rozmiaru bez size od indeksu jeden większy niż początkowy aby nie dodawać liczby do samej siebie
                sums.add(preambula[j] + preambula[k])
            }
        }

        // Sprawdzam, czy liczba znajduje się w zbiorze sum
        if (target in sums) {
            continue
        } else {
            return target // Jeśli liczba nie pasuje, zwracam ją
        }
    }
    return -1 // Jeśli wszystkie liczby pasują, zwracam -1
}

fun main() {
    //Przykład z listy
    println(check(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)))

    print("Podaj preambułę i liczby oddzielone średnikiem (np. 2;1;2;3;4;5;6): ")
    val input = readLine()?.split(";")?.mapNotNull { it.toIntOrNull() }

    if (input == null || input.size < 2) {
        println("Niepoprawne dane wejściowe")
        return
    }

    val N = input.first() // Pierwsza liczba to długość preambuły
    val numbers = input.drop(1) // Reszta to lista liczb

    if (N >= numbers.size) {
        println("Długość preambuły jest zbyt duża w stosunku do listy")
        return
    }

    println(check(N, numbers))
}
