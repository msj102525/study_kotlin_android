fun main() {
    hello("안녕")
    hello()
    divide(1000)
    divide(a = 1000, b = 12)
    divide(b = 12, a = 1000)
    divide(1000, b = 24)
    divide(a = 1000, 24)

    myMsg("안녕하세요", "반갑습니다", "감사합니다")

    println(add(x = 10, y = 20))
    println(myFunc('a'))

    // 함수 객체
    val myFuncObj = ::myFunc
    println(myFuncObj('강'))

    // 고차함수(함수를 인수로 받거나 반환값으로 리턴하는 함수)
    println(highFunc('어', ::myFunc))
    println(highFunc('어', ::myFunc2))

    // 람다식(익명함수)

    val lamdaObj = { c: Char -> "${c}${c}${c}" }
    println(lamdaObj('ㅋ'))

    highFunc('ㅁ', { c: Char -> "${c}/${c}/${c}" })

    // 생략 기법
    // 1. 최후의 인수가 람다식인 경우, ()의 밖으로 뽑을 수 있다
    highFunc('F') { c: Char -> "${c}/${c}/${c}" }
    // 2. 1번의 경우, ()자체도 생략가능한 경우가 있다.
    highFunc { c: Char -> "${c}/${c}/${c}" }
    // 3. 예약 변수 it을 사용하는 경우
    highFunc { it -> "${it}/${it}/${it}" }
    highFunc { "${it}/${it}/${it}" }
    highFunc('엄') { "${it}/${it}/${it}" }

}

fun hello(s: String = "안녕") {
    println(s)
}

fun divide(a: Int, b: Int = 24) {
    println(a / b)
}

fun myMsg(vararg msgs: String) {
    msgs.forEach { println(it) }
}

fun add(x: Int, y: Int): Int = x + y

fun myFunc(c: Char): String = "${c} ${c} ${c}"
fun myFunc2(c: Char): String = "${c}-${c}-${c}"

fun highFunc(c: Char = 'c', pf: (Char) -> String) {
    println(pf(c))
}

