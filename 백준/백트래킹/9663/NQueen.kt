import java.io.StreamTokenizer

var cnt = 0
lateinit var arr: IntArray

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val input = i()

    // 배열의 index가 열, element가 행을 나타냄
    arr = IntArray(input)

    nQueen(input)
    print(cnt)
}

private fun nQueen(n: Int, col: Int = 0) {
    if (n == col) {
        ++cnt
        return
    }

    for (row in 0 until n) {
        arr[col] = row

        if (isPossible(col)) {
            // 현재 열과 행에 queen을 놓을 수 있다면
            // 다음 열로 넘어감
            nQueen(n, col + 1)
        }
    }
}

/**
 * 특정 열과 행에 queen을 놓을 수 있는지 판별하는 함수
 *
 * @param col queen을 놓고자 하는 열
 */
private fun isPossible(col: Int): Boolean {
    var result = true

    // 이전 열에 놓인 queen의 이동 범위에 속하는지 판별
    for (i in 0 until col) {
        val row = arr[i]

        result = when {
            arr[col] == row -> false                // 같은 행에 놓을 수 없음
            arr[col] == (row - (col - i)) -> false  // 대각선 위의 행에 놓을 수 없음
            arr[col] == (row + (col - i)) -> false  // 대각선 아래의 행에 놓을 수 없음
            else -> true
        }

        if (!result) break  // 놓을 수 없는 칸으로 판단되면 판별 중단
    }

    return result
}