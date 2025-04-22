import kotlin.random.*
import java.time.LocalDate // Dla Local Date
import java.time.Month

enum class CostType(val costType: String) {
    REFUELING("Tankowanie"),
    SERVICE("Serwis"),
    PARKING("Parking"),
    INSURANCE("Ubezpieczenie"),
    TICKET("Mandat")
}

data class Cost (
    val type: CostType,
    val date: LocalDate,
    val amount: Int
)

data class Car (
    val name: String,
    val brand: String,
    val model: String,
    val yearOfProduction: Int,
    val costs: List<Cost>
)

object DataProvider {

    private fun generalCosts(size: Int) = List(size) {
        Cost(
            CostType.values()[Random.nextInt(CostType.values().size)],
            LocalDate.of(
                2025,
                Random.nextInt(1,13),
                Random.nextInt(1,28)),
            Random.nextInt(5000)
        )
    }

    val cars = listOf(
        Car("Domowy", "Skoda", "Fabia", 2002, generalCosts(100)),
        Car("Służbowy", "BMW", "Coupe", 2015, generalCosts(50)),
        Car("Kolekcjonerski", "Fiat", "125p", 1985, generalCosts(10))
    )

}

fun groupedCostMap(costs: List<Cost>): Map<Month, List<Cost>> {
    return costs
        .groupBy { it.date.month }
        .toSortedMap()
}

fun printGroupedCosts(costs: List<Cost>) {
    costs
        .groupBy { it.date.month }
        .toSortedMap()
        .forEach { (month, monthlyCosts) ->
            println(month)
            monthlyCosts
                .sortedBy { it.date }
                .forEach { cost ->
                    val day = cost.date.dayOfMonth.toString().padStart(2, '0')
                    println("$day ${cost.type.name} ${cost.amount} zł")
                }
        }
}

fun getCarCosts(carName: String): List<Pair<CostType, Int>> {
    val car = DataProvider.cars.find { it.name == carName } ?: return emptyList()
    return CostType.values()
        .map { type ->
            val total = car.costs.filter { it.type == type }.sumOf { it.amount }
            type to total
        }
        .sortedByDescending { it.second }
}

fun printCarCosts(costs: List<Pair<CostType, Int>>) {
    costs.forEach { (type, amount) ->
        println("${type.name} ${amount} zł")
    }
}

fun getFullCosts(cars: List<Car>): Map<CostType, Int> {
    return cars
        .flatMap { it.costs }
        .groupBy { it.type }
        .mapValues { it.value.sumOf { cost -> cost.amount } }
}

fun printFullCost(costs: Map<CostType, Int>) {
    CostType.values().forEach { type ->
        val sum = costs[type] ?: 0
        println("${type.name} $sum")
    }
}

fun main() {
    //Przechowuje wynik dla pierwszych pięciu kosztów auta domowego.
    val ExampleCosts = DataProvider.cars[0].costs.take(5)

    println("Zadanie Pierwsze")
    println(groupedCostMap(ExampleCosts))

    println("Zadanie Drugie")
    printGroupedCosts(ExampleCosts)

    println("Zadanie Trzecie")
    val carCosts = getCarCosts("Domowy")
    printCarCosts(carCosts)

    println("Zadanie Czwarte")
    val totalCosts = getFullCosts(DataProvider.cars)
    printFullCost(totalCosts)
}