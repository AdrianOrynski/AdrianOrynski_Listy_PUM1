import kotlin.math.pow

fun isArmstrongNumber(n: Int): Boolean {
    val digits = n.toString().map { it.toString().toInt() } // Pobieram cyfry liczby
    val power = digits.size // Ilość cyfr w liczbie
    var sum = 0
    for (i in 0..(power-1)) {
        //funkcja power działa na typie double więc wymagana jest konwersja przed wykonaniem działania
        sum += digits[i].toDouble().pow(power).toInt()
    }
    return sum == n // Sprawdzam, czy suma jest równa oryginalnej liczbie
}

fun main() {
    print("Podaj liczbę do sprawdzenia: ")
    val liczba = readLine()?.toIntOrNull()
    if (liczba != null && liczba > 0) {
        if (isArmstrongNumber(liczba)) {
            println("$liczba jest liczbą Armstronga")
        } else {
            println("$liczba nie jest liczbą Armstronga")
        }
    } else {
        println("Próbowano przekazać niepoprawny argument do funkcji")
    }
}