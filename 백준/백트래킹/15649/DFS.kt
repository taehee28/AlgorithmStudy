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

    fun dfs(n: Int, m: Int, depth: Int) {
        if (depth == m) {
            arr.forEach { sb.append(it).append(" ") }
            sb.appendLine()
            return
        }

        for (i in 0 until n) {
            if (!visit[i]) {
                visit[i] = true
                arr[depth] = i + 1
                dfs(n, m, depth + 1)

                visit[i] = false
            }
        }
    }

    dfs(n, m, 0)
    print(sb.toString())
}