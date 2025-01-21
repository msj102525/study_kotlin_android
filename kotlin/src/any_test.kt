fun main() {
    var a: Any = "test"
    a = 100
    println(a)

    // 자식클래스형의 고유한 프로퍼티나 메서드를 사용할 경우 에러가 남
    a = "test"
    println(a.length) // kotlin 2.x 이후에 가능
    var a1: Any? = null

    // Unit 형
    // 함수에서 리턴값이 없다는 것을 나타낸다
    // 생략 가능
    printInt(1000)
}

fun printInt(i: Int): Unit {
    println("printInt ${i}")
}