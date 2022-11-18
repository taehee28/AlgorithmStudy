import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val sb = StringBuilder()

    while (true) {
        val a = i()
        val b = i()
        if (a == 0 && b == 0) break

        when {
            a % b == 0 -> sb.appendLine("multiple")
            b % a == 0 -> sb.appendLine("factor")
            else -> sb.appendLine("neither")
        }
    }

    print(sb.toString())
}