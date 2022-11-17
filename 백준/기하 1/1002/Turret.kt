import java.io.StreamTokenizer
import kotlin.math.hypot

/* 실수 타입 값의 정확도를 체크하는 것이 포인트 */
fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt(); }
    val count = i()
    val sb = StringBuilder()

    repeat(count) {
        val jo = Circle(x = i(), y = i(), r = i())
        val back = Circle(x = i(), y = i(), r = i())

        sb.appendLine(jo.countIntersectionPoint(back))
    }

    print(sb.toString())
}

data class Circle(
    val x: Int,
    val y: Int,
    val r: Int
) {
    fun getDistance(other: Circle): Double {
        val sumX = x - other.x
        val sumY = y - other.y

        return hypot(sumX.toDouble(), sumY.toDouble())
    }

    fun countIntersectionPoint(other: Circle): Int {
        val d = getDistance(other)
        when (tangentWith(other)) {
            1 -> {  // 외접
                val sum = r + other.r
                return if (sum < d) {
                    0
                } else if (sum.toDouble() == d) {
                    1
                } else {
                    2
                }
            }
            -1 -> { //내접
                // 크기와 위치가 일치함
                if ((d == 0.0) && (r == other.r)) return -1

                val (bigR, smallR) = if (r > other.r) {
                    r to other.r
                } else {
                    other.r to r
                }
                val sum = bigR - d

                return if (sum > smallR) {
                    0
                } else if (sum == smallR.toDouble()) {
                    1
                } else {
                    2
                }
            }
            else -> throw IllegalStateException()
        }
    }

    fun tangentWith(other: Circle): Int {
        val d = getDistance(other)
        val longest = if (r > other.r) r else other.r

        return if (longest < d) {
            1
        } else {
            -1
        }
    }
}