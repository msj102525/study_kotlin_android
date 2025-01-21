//fun main() {
//    // 오버라이드, 추상클래스, 인터페이스
//    val coffee = Coffee()
//    coffee.comment()
//    coffee.name = "아메리카노"
//    println(coffee.getNameMsg())
//    println(coffee.getHotMsg())
//    println(coffee.getIceMsg())
//    println(coffee.myFunc())
//}
//
//abstract class Drink {
//    var name: String = "음료"
//
//    open fun comment() {
//        println("마실거리입니다.")
//    }
//
//    abstract fun getNameMsg(): String
//}
//
//class Coffee : Drink(), Hot, Ice {
//    override fun comment() {
//        println("커피입니다")
//    }
//
//    override fun conflictFunc(): String {
//        super<Ice>.conflictFunc()
//    }
//
//    override fun getHotMsg(): String {
//        return "뜨거운 ${name}입니다."
//    }
//    override fun getIceMsg(): String {
//        return "차가운 ${name}입니다."
//    }
//
//    override fun getNameMsg(): String {
//        return "음료는 ${name}입니다."
//    }
//
//    override fun myFunc() {
//        super.myFunc()
//    }
//}
//
//class Yogurt: Drink(), Ice {
//    override fun getNameMsg(): String {
//        return "요구르트"
//    }
//
//    override fun getIceMsg(): String {
//        return "차가운 ${name}입니다."
//    }
//}
//
//
//interface Hot {
//    fun getHotMsg(): String
//    fun myFunc() {
//        println("myFunc의 기본 처리")
//    }
//}
//
//interface Ice {
//    fun getIceMsg():String
//    fun conflictFunc(): String
//}