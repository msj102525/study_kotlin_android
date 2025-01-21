fun main() {
    // boxing: 프리미티브 타입을 레퍼클래스로 암묵적으로 교환
    val num: Int = 128
    val n1: Int = num
    val n2: Int = num

    println("${n1}, ${n2}")
    println(n1 == n2)

    val boxn1: Int? = n1
    val boxn2: Int? = n2

    println("${boxn1}, ${boxn2}")
    println(boxn1 == boxn2)

//    val n3:Int = boxn1 // 에러
}