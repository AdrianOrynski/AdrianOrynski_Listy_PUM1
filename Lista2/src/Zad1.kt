fun main() {
    val r: (String, Int) -> String = { s, i -> s.repeat(i) }

    //Przykład z listy
    println(r("a", 3))

    print("Podaj napis do powtórzenia: ")
    val napis = readLine()

    print("Podaj liczbę powtórzeń: ")
    val liczba = readLine()?.toIntOrNull()

    if (napis != null && liczba != null && liczba > 0) {
        println(r(napis, liczba))
    } else {
        println("Próbowano przekazać niepoprawny argument do funkcji")
    }
}
