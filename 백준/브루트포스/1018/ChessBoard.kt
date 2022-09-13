import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val row = st.nextToken().toInt()
    val col = st.nextToken().toInt()

    val array = Array(row) {
        st = StringTokenizer(br.readLine())
        val line = st.nextToken()

        BooleanArray(col) {
            line[it] == 'W'
        }
    }

    // 새로 칠해야 하는 경우의 수 중 최대값으로 초기화
    var minCount = 64

    // [n][m]에서 시작하는 8x8 크기의 배열을 검사해야 함
    for (n in 0 until (row-7)) {
        for (m in 0 until (col-7)) {
            // 첫번째 칸의 색
            var color = array[n][m]
            var count = 0

            for (x in n until (n+8)) {
                for (y in m until (m+8)) {
                    // 색이 정상적으로 칠해졌는지 검사
                    if (array[x][y] != color) ++count

                    // 다음칸은 지금 칸의 반대 색
                    color = !color
                }

                // 다음 줄의 첫번째 칸은 마지막으로 바뀐 색의 반대 색
                color = !color
            }

            // 첫번째 칸의 색으로 따졌을 때 다시 칠해야 할 갯수와
            // 첫번째 칸의 반대 색으로 따졌을 때 다시 칠해야 할 갯수를 비교
            count = min(count, 64 - count)

            // 최소값 갱신
            minCount = min(minCount, count)
        }
    }

    print(minCount)
}