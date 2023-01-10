import java.io.StreamTokenizer

private val map = mutableMapOf<Triple<Int, Int, Int>, Int>()

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }

    val sb = StringBuilder()

    while (true) {
        val a = i()
        val b = i()
        val c = i()

        if (a == -1 && b == -1 && c == -1) break

        sb.append("w(")
            .append(a)
            .append(", ")
            .append(b)
            .append(", ")
            .append(c)
            .append(") = ")
            .appendLine(w(a, b, c))
    }

    print(sb.toString())
}

private fun w(a: Int, b: Int, c: Int): Int {
    return when {
        (a <= 0) || (b <= 0) || (c <= 0) -> 1
        (a > 20) || (b > 20) || (c > 20) -> {
            map.getOrPut(Triple(20, 20, 20)) { w(20, 20, 20) }
        }
        (a < b) && (b < c) -> {
            map.getOrPut(Triple(a, b, c)) {
                w(a, b, c - 1) + w(a, b-1, c-1) - w(a, b-1, c)
            }
        }
        else -> {
            map.getOrPut(Triple(a, b, c)) {
                w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
            }
        }
    }
}