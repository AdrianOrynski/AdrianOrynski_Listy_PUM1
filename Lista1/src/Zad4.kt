fun klasyfikujLiczbe(n: Int): String {
    var suma = 0
    for (i in 1..(n-1)) {
        if (n % i == 0) {
            suma += i
        }
    }
    return when {
        suma == n -> "$n jest liczbą doskonałą"
        suma > n -> "$n jest liczbą obfitą"
        else -> "$n jest liczbą niedomiarową"
    }
}

fun main() {
    print("Podaj liczbę do sprawdzenia: ")
    val liczba = readLine()?.toIntOrNull()
    if (liczba != null && liczba > 0) {
        println(klasyfikujLiczbe(liczba))
    } else {
        println("Próbowano przekazać niepoprawny argument do funkcji")
    }
}