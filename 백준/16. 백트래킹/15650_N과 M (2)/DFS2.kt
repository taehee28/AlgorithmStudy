import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val n = i()
    val m = i()

    printSequence(n, m)
}

private fun printSequence(n: Int, m: Int) {
    val visit = BooleanArray(n)
    val arr = IntArray(m)
    val sb = StringBuilder()

    fun dfs(n: Int, m: Int, depth: Int, i: Int = 0) {
        if (depth == m) {
            arr.forEach { sb.append(it).append(" ") }
            sb.appendLine()
            return
        }

        for (j in i until n) {
            if (!visit[j]) {
                visit[j] = true
                arr[depth] = j + 1

                // 이전 자리수에서 표시됐었던 숫자는 다음 자리수에서 표시되면 안됨
                dfs(n, m, depth + 1, j)

                visit[j] = false
            }


        }
    }

    dfs(n, m, 0)
    print(sb.toString())
}