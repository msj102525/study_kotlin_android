//fun main() {
//    val burger = Burger()  // Burger 객체 생성
//    burger.price = -1000  // 잘못된 가격 입력
//    println("${burger.name} : ${burger.price}")  // 가격 출력
//
//    val cheeseBurger = CheeseBurger()  // CheeseBurger 객체 생성
//    cheeseBurger.price = 1000  // 올바른 가격 입력
//    println("${cheeseBurger.name} : ${cheeseBurger.price}")  // 가격 출력
//}
//
//// Burger 클래스 정의 (음수 가격을 막는 setter 포함)
//open class Burger(var name: String = "햄버거", var price: Int = 0) {
//    var price: Int = price
//        set(value) {
//            if (value >= 0) {
//                field = value  // 음수가 아닌 값만 설정
//            } else {
//                println("0 이상 입력 바랍니다.")  // 음수 가격은 허용하지 않음
//            }
//        }
//}
//
//// CheeseBurger 클래스 정의 (Burger를 상속받고, price의 범위 설정)
//class CheeseBurger : Burger() {
//    init {
//        this.name = "치즈버거"  // name을 "치즈버거"로 설정
//    }
//
//    // price를 오버라이드하여 0 이상 9999 이하 값만 허용
//    override var price: Int = 0
//        set(value) {
//            if (value in 0..9999) {
//                field = value
//            } else {
//                println("가격은 0 이상 9999 이하이어야 합니다.")  // 가격 범위 제한
//            }
//        }
//}
