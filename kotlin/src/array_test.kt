fun main() {
    val intAry = arrayOf(1, 2, 3, 4, 5)
    val strAry = arrayOf("스타벅스", "백다방", "메가커피")

    println(strAry[0])
    println(strAry.get(1))
    strAry[1] = "컴포즈"
    println(strAry[1])

//    strAry[3] = "이디야 커피"

    for (i in intAry) println("${i} ")

    intAry.forEach { print("${it}") }
    println()

    for (s in strAry) println("${s}")
    strAry.forEach { print("${it} ") }

    println()

    // 범위(Range)
//    val range: IntRange = 1..5
    val range = 1..5
    for (i in range) print("${i}")

    println()

    // 2025/1 이 몇일까지 31
    val januaryRange = 1..31
    println(32 in januaryRange)

    // step, downTo 함수
    val range2 = 1..25
    for (i in range2 step 5) print("${i} ")

    println()
    for (i in 5..1) print("${i} ")  // 역순은 .. 연산자로 얻을 수 없다

    println()
    for (i in 5 downTo 1) print("${i} ")

    println()
    for (i in 25 downTo 1) print("${i} ")

    println()

    // 문자의 범위
    val range3: CharRange = 'I'..'P'
    for (c in range3) print("${c} ")

    println()
    for (c in 'A'..'Z' step 5) print("${c} ")

    println()
    val range4 = 1..25
    // 1, 6, 11 .. 끝까지

    for (i in range4 step 5) // 인픽스(infix)
//    for (i in range4.step(5))
        print("${i} ")

    println()
    // 5, 4, 3, 2, 1
//    for (i in 5 downTo 1)
    for (i in 5.downTo(1))
        print("${i} ")

    println()
//    for (i in 1 until 5)
    for (i in 1..4)
        print("${i} ")


}