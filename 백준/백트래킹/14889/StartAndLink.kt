import java.io.StreamTokenizer
import kotlin.math.abs
import kotlin.system.exitProcess

private lateinit var arr: Array<IntArray>
private lateinit var members: BooleanArray
private var min = Int.MAX_VALUE

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val count = i()

    arr = Array(count) { IntArray(count) { i() } }
    members = BooleanArray(count)

    dfs(count)

    print(min)
}

private fun dfs(count: Int, index: Int = 0, depth: Int = 0) {
    if (depth == count/2) {
        var start = 0
        var link = 0

        repeat(members.size) { row ->
            repeat(members.size) { col ->
                if (members[row] && members[col]) {
                    start += arr[row][col]
                } else if (!members[row] && !members[col]) {
                    link += arr[row][col]
                }
            }
        }

        val result = abs(start - link)
        min = if (result < min) result else min

        if (min == 0) {
            print(min)
            exitProcess(0)
        }

        return
    }

    for (i in index until count) {
        if (!members[i]) {
            members[i] = true
            dfs(count, i + 1, depth + 1)
            members[i] = false
        }
    }
}