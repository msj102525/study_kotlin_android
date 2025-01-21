fun main() {
//    var s:String = null
//    var s:String = "test"
//    s = null

//    var s: String? = "test"
//    s = null

    var s: String? = "test"
//    s = null
//    println(s.length)
//    if (s != null) {
//        println(s.length)
//    }

//    s = null
    // ?: 엘베스 연산자
    println(s?.length ?: -1) // safe-call 연산자

    // !!. 연산자 (강제적으로 non-null 연산)
    println(s!!.length)
}

