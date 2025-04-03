data class StudentScore(val name: String, val subject: String, val score: Int)

fun analyzeResults(students: List<StudentScore>): Triple<Map<String, List<StudentScore>>, List<StudentScore>, List<String>> {
    // Mapa przedmiotów z listami studentów, którzy zdali (score >= 50)
    val passedBySubject = students
        .filter { it.score >= 50 } // Filtruje studentów, którzy zdali
        .groupBy { it.subject } // Grupuje po przedmiocie

    // Lista studentów, którzy nie zdali (score < 50)
    val failed = students.filter { it.score < 50 }

    // Lista przedmiotów, w których wszyscy studenci zdali
    val subjectsAllPassed = students
        .groupBy { it.subject } // Grupowanie po przedmiocie
        .filter { entry -> entry.value.all { it.score >= 50 } } // Sprawdzam, czy wszyscy zdali
        .keys // Zwracam tylko nazwy przedmiotów
        .toList()

    return Triple(passedBySubject, failed, subjectsAllPassed)
}

fun main() {
    val students = listOf(
        StudentScore("Alice", "Math", 78),
        StudentScore("Bob", "Math", 45),
        StudentScore("Charlie", "Physics", 92),
        StudentScore("Dave", "Physics", 55),
        StudentScore("Eve", "Physics", 40),
        StudentScore("Frank", "CS", 60),
        StudentScore("Grace", "CS", 80),
    )

    val (passedBySubject, failed, subjectsAllPassed) = analyzeResults(students)

    println("Zdani studenci według przedmiotów: $passedBySubject")
    println("Niezdani studenci: $failed")
    println("Przedmioty, w których wszyscy zdali: $subjectsAllPassed")
}