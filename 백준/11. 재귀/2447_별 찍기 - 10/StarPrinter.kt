/**
 * https://www.acmicpc.net/problem/2447
 */

private const val BLANK = " "
private const val STAR = "*"

fun main() {
    printStar(27)
}

private fun printStar(number: Int) {
    val strBuilder = java.lang.StringBuilder()

    for (i in 0 until number) {
        for (j in 0 until number) {
            strBuilder.append(getStarOrBlank(i, j, number))
        }
        strBuilder.append("\n")

    }
    println(strBuilder.toString())
}

/**
 * @param x 행 인덱스
 * @param y 열 인덱스
 * @param num input 값 (3의 n제곱수)
 */
private fun getStarOrBlank(x: Int, y: Int, num: Int): String {
    // 패턴 1개를 최소 단위로 하는 한 변의 길이.
    // 1 -> 1x1, 3 -> 3x3, 9 -> 9x9, ...
    val pCount = num / 3

    // 실제 인덱스를 한변의 길이로 나누면 3개로 나눌 수 있음
    // -> 상대적인 3x3 행렬로 만들어버림
    return if (x/pCount == 1 && y/pCount == 1) {
        // 어떤 크기든지 [1][1]은 비어있어야 함.
        BLANK
    } else {
        if (pCount == 1) {
            // 현재 1x1 짜리 패턴이라면
            // "*" 반환
            STAR
        } else {
            // 아니면 패턴을 한단계 작게 쪼개서 재귀호출
            // 한단계 작아진 패턴에 맞는 인덱스로 변환 
            getStarOrBlank(x % pCount, y % pCount, pCount)
        }
    }
}