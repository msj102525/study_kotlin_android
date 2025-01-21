fun main() {

    val i: Int
    i = 1
//    i=2 // 재선언 안됨
    print(i)

    val j: Int = 1
    print(j)

    var k: Int
    k = 1
    k = 2
    print(k)

    var s:String = "oracle"
    s = "java"
    print(s)

//    기본적으로 val을 사용, 재대입이 필요한 경우 var 사용
//    재대입하지 않는 변수에 var를 사용하면
//    다른 사람이 어디에서 재대입할지 확인해야 하는 번거러움이 있다

}