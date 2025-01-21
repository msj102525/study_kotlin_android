fun main() {
    val intList = listOf(1, 2, 3, 4, 5)
    for (i in intList) {
        print("${i} ")
    }

    println()

    var i = 0
    while (i++ < 5) {
        print("${i} ")
    }

    println()

    i = 0
    do {
        print("${i} ")
    } while (i++ < 5)
}