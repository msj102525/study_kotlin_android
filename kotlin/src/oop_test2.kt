fun main() {
    val riceball = Riceball(type = 1, name = "참치주먹밥", seaweed = false)
    println("${riceball.type}, ${riceball.name}, ${riceball.seaweed}")
}

open class Food3(var type: Int, var name: String) {
//    var type: Int = 0
}

// 주먹밥
class Riceball(
    type: Int, name: String,
    var seaweed: Boolean = true
) : Food3(type, name) {
//    var seaweed: Boolean = true // 김가루 뿌렸는지 여부
}

class Riceball2 : Food2 {
    var seaweed: Boolean = true

    constructor(type: Int, name: String, seaweed: Boolean) : super(type, name) {
        this.seaweed = seaweed
    }
}