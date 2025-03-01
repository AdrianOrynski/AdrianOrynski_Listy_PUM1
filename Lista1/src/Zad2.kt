fun isPalindrome(word: String): Boolean {
    return word == word.reversed()
}

fun main() {
    print("Wpisz swoje słowo: ")
    val word = readLine()

    if (word.isNullOrEmpty()) { // Sprawdzam czy `word` nie jest null i czy nie jest pusty
        println("To jest niepoprawny argument")
    } else {
        //word.trim() słowo bez białych znaków
        if (isPalindrome(word.trim())) {
            println("$word to jest palindrom")
        } else {
            println("$word nie jest palindromem")
        }
    }
}
