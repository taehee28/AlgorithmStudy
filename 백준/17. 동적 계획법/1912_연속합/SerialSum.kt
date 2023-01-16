import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val count = i()

    var pre = i()
    var totalMax = pre
    repeat(count - 1) {
        val now = i()

        // 값을 누적
        val sum = pre + now

        // 누적한 값과 현재 값을 비교
        // 현재 값이 크다면, 지금까지 중에서는 현재 숫자 1개만 선택하는 것이 가장 큰 연속값
        // 어디서부터 값을 누적할 것인지가 결정됨
        val max = if (sum > now) sum else now
        pre = max

        // 큰 값 중에서도 가장 큰 값이 가장 큰 연속값
        // 어디까지 값을 누적하는 것인지가 결정됨
        if (max > totalMax) totalMax = max
    }

    print(totalMax)
}