fun main() {
    var i: Int = 1
    var f: Float = 3.14F

//    i = f
    i = f.toInt() // 명시적인 변환
    println(i)

    f = i.toFloat()
    println(f)
    // 코틀린에서는 암묵적인 형변화 허용하지 않음
    // toByte(), toShort(), toInt(), toLong()
    // toFloat(), toDouble(), toChar()

    // 문자열 내에서 ${변수}형식으로 대입 가능
    val x: Int = 2
    val y: Int = 3
    val msg: String = "$x * $y = ${x * y}"
    println(msg)
    println("${x}입니다")
    // 이스케이프 시퀀스 \', \", \ㅜ, \\, \$, \t, \b, \r
    // raw 문자열
    val msg2 = """
        1행\t내용1
        2행\t내용2
    """.trimIndent()
    println(msg2)
    // 유니코드 출력
    println("\u2600 그리고 \u2601")

}