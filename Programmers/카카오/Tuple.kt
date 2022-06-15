/**
 * https://programmers.co.kr/learn/courses/30/lessons/64065?language=kotlin
 */

fun main() {
    solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")
}

private fun solution(s: String): IntArray {

    // refactoring 필요

    val split = s.split("{", "},{", "}").filter { it.isNotEmpty() }
    val nestedList = List(split.size) { split[it].split(",") }
    val list = nestedList.flatten()
    val map = list.groupingBy { it }.eachCount()
    val sorted = map.toList().sortedByDescending { it.second }
    val answer = sorted.map { it.first.toInt() }.toIntArray()

    return answer
}


