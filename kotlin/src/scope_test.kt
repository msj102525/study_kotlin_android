fun main() {
    // 확장함수: apply, also, run, let, 일반함수: with
//    sushi.pieces = 2
//    sushi.price = 1000
//    val sushi = Sushi("마구로").apply {
//        pieces = 2
//        price = 1000
//    }
//    val sushi = Sushi("마구로").also {
//        it.pieces = 2
//        it.price = 1000
//    }
//    val sushi = Sushi("마구로").run {
//        pieces = 2
//        price = 1000
//        println("${name}, ${pieces}, ${price}")
//    }
//    val sushi = Sushi("마구로").let {
//        it.pieces = 2
//        it.price = 1000
//        println("${it.name}, ${it.pieces}, ${it.price}")
//    }

    // null 체크
//    var msg: String? = "abcdefg"
//    var res = msg?.let {
//        it.toUpperCase()
//    } ?: "null입니다"
//
//    println(res)

    val sushi = with(Sushi("마구로")) {
        pieces = 2
        price = 1000
        println("${name}, ${pieces}, ${price}")
        "맛있는 스시 많이 드시고 올한해도 건강하세요"
    }

    println(sushi)

//    println("${sushi.name}, ${sushi.pieces}, ${sushi.price}")
}

class Sushi(val name: String) {
    var pieces: Int = 0
    var price: Int = 0
}