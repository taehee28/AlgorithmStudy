import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val sb = StringBuilder()
    val case = i()
    val arr = Array(31) { i ->
        IntArray(31) { j ->
            when {
                i == j -> 1
                j == 0 -> 1
                j == 1 -> i
                else -> 0
            }
        }
    }

    for (i in 2..arr.lastIndex) {
        for (j in 1..i) {
            if (arr[i][j] == 0) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1]
            }
        }
    }

    repeat(case) {
        val n = i()
        val m = i()

        sb.appendLine(arr[m][n])
    }

    print(sb.toString())
}
