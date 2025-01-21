fun main() {
    // setOf, mutableSetOf
    // set: 중복된 요소도 가지지 않고, 순서도 가지지 않는 특징을 가진다

    val intSet = setOf(1, 2, 3, 2, 4, 5)
    val strMtbSet = mutableSetOf("Avengers", "Wonder Woman", "Avengers", "ET")
    println(intSet)
    println(strMtbSet)

    // 추가/변경
//    strMtbSet.add("영구와 땡칠이")
//    strMtbSet.add("영구와 땡칠이2")
//    strMtbSet.remove("ET")
    strMtbSet+=("영구와 땡칠이")
    strMtbSet+=("영구와 땡칠이2")
    strMtbSet-=("ET")
    println(strMtbSet)

    // Set -> List
    val movList = strMtbSet.toList()

}