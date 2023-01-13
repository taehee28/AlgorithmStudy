import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val count = i()
    val map = mutableMapOf<Int, Long>()

    fun dp(n: Int): Long = when (n) {
        1, 2, 3 -> 1
        else -> map.getOrPut(n) { dp(n - 2) + dp(n - 3) }
    }

    val sb = StringBuilder()
    repeat(count) {
        sb.appendLine(dp(i()))
    }

    print(sb.toString())
}