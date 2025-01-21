fun main() {
    // if문, if ~ else, if else if else 문
    // if식 (else는 필수)
    var score = 50
    val msg = if (score >= 80) {
        "합격입니다"
    } else if (score >= 70) {
        "조금더 노력하세요"
    } else {
        "불합격입니다"
    }

    println(msg)
    // val msg2 = (score >=80) ? "합격" : "불합격" // 3항 연산자 없음
    val msg2 = if (score >= 80) "합격" else "불합격"
    // &&, ||, !

    // when
    // break 없음
    // default 대신에 else
    // 식으로도 사용가능

    // 일본 여행:
    // 맛: 1 연하게, 2 보통, 3 진하게
    val soupType = 1

    when (soupType) {
        1 -> {
            println("연하게")
        }

        2 -> {
            println("보통")
        }

        3 -> {
            println("진하게")
        }

        else -> {
            println("없음")
        }
    }

    score = 80
    val msg3 = when (score) {
        in 80..100 -> "합격"
        in 70..79 -> "예비"
        else -> "불합격"
    }

    println(msg3)

    val a = 3
    val b = 5
    when {
        a == 1 -> println("a는 1입니다")
        b == 5 -> println("b는 5입니다")
        else -> println("error")
    }

}