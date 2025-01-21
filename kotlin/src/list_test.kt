import java.security.Principal

fun main() {
    // listOf 함수
    // 이뮤터블한 List 작성
    // mutableListOf 함수
    // 뮤터블한 List 작성
    // 1, 2, 3, 4, 5
    val intList = listOf(1, 2, 3, 4, 5)
    val intMtbList = mutableListOf(1, 2, 3, 4, 5)

    // 요소의 취득
    println(intList[2])
    println(intList.get(2))

    // 대입
//    intList[2] = 10
    intMtbList[2] = 10
    println(intMtbList[2])

    // 요소의 추가/삭제
    intMtbList.add(10)
    intMtbList.removeAt(2)
    println(intMtbList)

    // 이뮤터블 리스트에서는 추가/삭제 가능 존재하지 않는다

    // size : 요소수가 저장되어 있는 프로퍼티
    println(intList.size)

    // distinct : 중복의 제거
    val intList2 = listOf(1, 2, 3, 4, 4, 5)
    println(intList2.distinct())

    // contains(지정한 값이 들어있으면 true)
    // containsAll(지정한 값이 모두 들어있으면 true)
    println(intList.contains((1)))
    println(intList.containsAll(listOf(1, 5)))
    println(intList.containsAll(listOf(1, 5, 6)))

    // indexOf, lastIndexOf
    val strList = listOf("Kotlin", "Java", "Kotlin", "Python")
    println(strList.indexOf("Kotlin"))
    println(strList.lastIndexOf("Kotlin"))
    println(strList.indexOf("C++"))

    // 판정
    // all, any, count
    println(intList.all { it < 5 })
    println(intList.all { it < 6 })

    println(intList.any { it > 6 })
    println(intList.any { it < 5 })

    println(intList.count { it <= 5 })

    // 집계
    // sum, sumBy, average, min, max
    println(intList.sum())
    println(intList.sumBy { it * 3 })
    println(intList.average())
    println(intList.min())
    println(intList.max())

    // 정렬
    // sorted(), sortedDescending
    println(intList.sorted())
    println(intList.sortedDescending())

    // 집합
    // union(합집합), subtract(차집합), intersect(교집합)

    val moviList = listOf("어벤져스", "스파이더맨", "엔트맨")
    val tvList = listOf("스파이더맨", "원더우먼", "맛있는 녀석들")
    println(moviList.union(tvList))
    println(moviList.subtract(tvList))
    println(moviList.intersect(tvList))

    // 이터레이터(컬렉션 전체의 공통 기능)
    // 요소의 전체가 아니라 바로 앞만 본다
    val intItr = intList.iterator()
    println(intItr.next())

    while (intItr.hasNext()) {
        println(intItr.next())
    }
//    println(intItr.next())

    // listIterator : 이터레이터의 고급기능
    val intListItr = intList.listIterator(5)
//    while (intListItr.hasNext()) {
//        print(intListItr.next())
//    }
    println()
    // 거꾸로 순회
    while (intListItr.hasPrevious()) {
        print(intListItr.previous())
    }

}
