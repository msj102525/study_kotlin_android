fun main() {
    val (cup, change) = getCoffee(10000)

    println("${cup}잔 거스름돈 ${change}원")
}

fun getCoffee(money: Int): Pair<Int, Int> {
    val cup = money / 300
    val change = money % 300
    return Pair(cup, change)
}