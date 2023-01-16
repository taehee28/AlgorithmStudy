import java.io.StreamTokenizer
import kotlin.system.exitProcess

private lateinit var arr: Array<IntArray>

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }

    arr = Array(9) { IntArray(9) { i() } }
    completeSudoku()
}

private fun completeSudoku(row: Int = 0, col: Int = 0) {
    if (col == 9) {
        completeSudoku(row + 1, 0)
        return
    }

    if (row == 9) {
        val sb = StringBuilder()
        arr.forEach { arr2 ->
            arr2.forEach { sb.append(it).append(" ") }
            sb.appendLine()
        }

        print(sb.toString())

        // 스도쿠가 한번 완성이 되면 끝
        exitProcess(0)
    }

    if (arr[row][col] == 0) {
        for (x in 1..9) {
            if (isPossible(row, col, x)) {
                arr[row][col] = x
                completeSudoku(row, col + 1)
            }
        }

        // for문을 다 돌고 빠져나왔다는 의미는
        // 넣을 수 있는 숫자가 없다는 의미.
        // 넣을 수 있는 숫자가 있다면 이곳을 타지 않음
        // return 시켜서 호출한 곳의 for문이 계속 돌도록 함
        arr[row][col] = 0
        return
    }

    // row나 col이 끝에 도달하지 않았거나
    // 값이 0이 아닌경우 다음 열로 넘어감
    completeSudoku(row, col + 1)
}

private fun isPossible(row: Int, col: Int, value: Int): Boolean {
    repeat(9) {
        if (arr[it][col] == value) {
            return false
        }
    }

    repeat(9) {
        if (arr[row][it] == value) {
            return false
        }
    }

    val n = (row / 3) * 3
    val m = (col / 3) * 3
    for (i in n until n + 3) {
        for (j in m until m + 3) {
            if (arr[i][j] == value) {
                return false
            }
        }
    }

    return true
}