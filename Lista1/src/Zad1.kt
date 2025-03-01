fun PrintSequence (number: Int) {
    for (i in 1..number) {
        var output = ""
        if (i%3 == 0) output += "Trzy"
        if (i%5 == 0) output += "Piec"
        if (i%7 == 0) output += "Siedem"
        if (i%11 == 0) output += "Jedenascie"
        if (i%13 == 0) output += "Trzynascie"

        if (output.isEmpty()) {
            println(i.toString())
        } else {
            println(output)
        }
    }
}

fun main() {
    print("Wpisz swoją liczbę: ")
    //Pod zmienną number przypisuje odczytany input i próbuje przekonwertować go na int.
    //W wypadku niepowodzenia zwaracam wartość null
    val number = readLine()?.toIntOrNull()
    if (number != null && number > 0) {
        PrintSequence(number)
    } else {
        println("Próbowano przekazać niepoprawny argument do funkcji")
    }
}
