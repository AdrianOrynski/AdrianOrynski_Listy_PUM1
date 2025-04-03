data class Point(val x: Int, val y: Int) {
    operator fun plus(p: Point) = Point(x + p.x, y + p.y)
    operator fun plus(int: Int) = Point(x+int, y+int)
    operator fun minus(p: Point) = Point(x - p.x, y - p.y)
    operator fun times(p: Point) = Point(x * p.x, y * p.y)
    operator fun inc() = Point(x + 1, y + 1)
    operator fun dec() = Point(x - 1, y - 1)
    operator fun not() = Point(-x, -y)
}

fun main(){
    //Zmieniam val w p1 na var aby wartość jego mogła być edytowalna
    val p1 = Point(1,1)
    val p2 = Point(2,2)
    println(p1+p2)
    println(p1 + 1) //zamieniam += na +
    println(p1-p2)
    println(p1*p2)
    println(p1.inc()) //zamieniam ++ na inc()
    println(p1.dec()) //zamieniam -- na dec()
    println(!p1)
}