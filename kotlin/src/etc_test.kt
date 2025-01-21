fun main() {
    val stock = Stock(1, "스마트폰", 11, 10)
    val stock2 = Stock(1, "스마트폰", 11, 10)
    // 분해선언, copy 메소드, toString
    val (code, name, area, num) = stock
    println("${code}, ${name}, ${area}, ${num}")
    println(stock === stock2)
    val stock3 = stock
    println(stock === stock3)
    val stock4 = stock.copy()
    println(stock === stock4)
    val stock5 = stock.copy(num = 50, area = 12)
    println(stock5)
    println(Timeofday.MORNING)
    println(Timeofday.MORNING.ordinal)
    println(Timeofday.MORNING.hour)

    // object 일시적인 하나의 객체만 만들고 싶을 때, 정적인 객체
    val myObj = object {
        var name: String = ""
        var addr: String = ""
        fun print() {
            println("안녕하세요")
        }
    }

    myObj.name = "문승종"
    myObj.addr = "자양동"
    myObj.print()

    println(MyFamily.cat)
    println(MyFamily.getMeow())

}

// data class
// 재고 클래스(코드, 이름, 위치, 갯수)
data class Stock(val code: Int, val name: String, val area: Int, val num: Int)

// enum class
enum class Timeofday(val hour: Int) {
    MORNING(6), AFTERNOON(12), EVENING(18), NIGHT(0)
}

// companion object
// 정적인 멤버
class MyFamily {
    companion object {
        val cat = "러시안 블루 고양이"
        fun getMeow(): String {
            return "야옹"
        }
    }
}



