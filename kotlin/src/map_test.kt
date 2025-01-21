fun main() {
    // map: Pair(키와 값)을 요소로 가지는 컬렉션
    // mapOf, mutableMapOf
    val ageMap = mapOf(20 to "스물", 30 to "서른", 40 to "마흔")
    val ageMtbMap = mutableMapOf(20 to "스물", 30 to "서른", 40 to "마흔")

    println(ageMap[20])
    println(ageMtbMap[20])

    for ((age, hangul) in ageMap) {
        println("${age}살은 ${hangul}")
    }

    // 변경, 추가, 삭제

    ageMtbMap[20] = "약관"
    ageMtbMap[50] = "쉰"
    ageMtbMap.remove(30)
    println(ageMtbMap)

    println(ageMap.size)
    println(ageMap.keys)
    println(ageMap.values)

    val intList = listOf(1, 2, 3)
//    println(intList[3])

    println(ageMtbMap[50])

    // Pair / Triple
    val couple = Pair("윤석열", "김건희")
    println("${couple.first}씨의 아내는 ${couple.second}")
    // 분해 선언
    val (husband, wife) = Pair("윤석열", "김건희")
    println("${husband} : ${wife}")

    val destiny = Triple("윤석열", "김건희", "천공")
    println("${destiny.first} - ${destiny.second} = ${destiny.third}")

    val (husbandx, wifex, advisor) = Triple("윤석열", "김건희", "천공")
    println("${husbandx} : ${wifex} : ${advisor}")
}