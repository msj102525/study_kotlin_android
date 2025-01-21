fun main() {
    val ramen = Food(type = 1001, name = "진라면")
    val side = Food()
//    ramen.type = 1001
//    ramen.name = "신라면"
    ramen.disp()
    side.disp()
}

// Food : 클래스이름, type, name: 프로퍼티
class Food(private var type: Int = 0, private var name: String = "삼각김밥") {
    // 디폴트 접근 제한자: public
    // internal, public, private, protected
    // 프라이머리 생성자, 세컨더리 생성자
    //  private var type: Int
    //  private var name: String

    // 프라이머리 생성자 초기화할때 사용
    //  init {
    //      this.type = type
    //        this.name = name
    //  }

    //    var price: Int = 0

    constructor(type: Int) : this(type, name = "식품") {
        println("세컨더리 생성자 type: $type, name: $name")
    }

    constructor() : this(type = 2, name = "식품") {
        println("세컨더리")
    }

    init {
        println("프라이머리 생성자 type: $type, name: $name")
    }

    fun disp() {
        println("type: ${type}, name: ${name}")
    }


}

// 세컨더리 생성자만 있는 경우
// 프라이머리 생성자로 코드가 지저분하게 보일 경우나, 다른 언어로 된 코드를 컨버팅할 경우
open class Food2 {
    var type: Int = 0
    var name: String = "식품"

    constructor(type: Int, name: String) {
        this.type = type
        this.name = name
    }

    constructor(type: Int) : this(type, name = "식품")
    constructor() : this(type = 0, name = "식품")

}

