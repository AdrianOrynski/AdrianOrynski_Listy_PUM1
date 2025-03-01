fun generatePascalTriangle(height: Int): List<List<Int>> {
    // Tworzę pustą listę do przechowywania kolejnych wierszy trójkąta Pascala
    val triangle = mutableListOf<List<Int>>()

    for (i in 0..(height-1)) {
        // Tworzę wiersz, w którym pierwsza i ostatnia liczba to 1, a reszta to suma dwóch powyższych wartości
        val row = List(i + 1) { j -> if (j == 0 || j == i) 1 else triangle[i - 1][j - 1] + triangle[i - 1][j] }
        triangle.add(row) // Dodaję nowy wiersz do trójkąta
    }

    return triangle // Zwracam całą strukturę trójkąta Pascala
}

fun printPascal(height: Int) {
    // Generuję trójkąt Pascala o zadanej wysokości
    val triangle = generatePascalTriangle(height)
    val maxWidth = triangle.last().joinToString(" ").length // Maksymalna szerokość ostatniego wiersza do centrowania

    triangle.forEach { row ->
        val rowStr = row.joinToString(" ") // Konwertuję wiersz na ciąg znaków
        println(" ".repeat((maxWidth - rowStr.length) / 2) + rowStr) // Drukuję wiersz z odpowiednim wyrównaniem
    }
}

fun main() {
    print("Podaj wysokość trójkąta Pascala: ")
    val height = readLine()?.toIntOrNull()
    if (height != null && height > 0) {
        printPascal(height)
    } else {
        println("Próbowano przekazać niepoprawny argument do funkcji")
    }
}
