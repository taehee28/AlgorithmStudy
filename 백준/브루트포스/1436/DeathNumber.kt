import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = StringTokenizer(br.readLine()).nextToken()

    println(getTitleNumber(count.toInt()))
}

private fun getTitleNumber(count: Int): Int {
    /**
     * 1. 단위 찾기
     * 종말숫자의 뒷부분 666을 제외한 앞부분 숫자의 단위를 예측한다.
     * 예) 666~9666 -> 0단위, 10666~19666 -> 1단위, ...
     *
     * 입력받은 수에서 n단위에 포함되는 종말숫자의 개수를 계속 빼다가
     * 뺄셈의 결과가 음수이면 해당 단위에 찾고자 하는 종말숫자가 있음을 알 수 있다.
     */
    var range = 0
    var remainCount = count
    while (range < count) {
        // 앞부분의 끝자리가 6일 때(=전체 숫자에서 연속된 6이 3개보다 많아지는 순간) 종말숫자를 다르게 세야하는 경우를 따짐
        val prefixNumber = 6 + 10 * range

        // 전체 종말숫자에서 연속되는 6의 개수가 3개보다 초과하는 만큼을 자릿수로 생각해서
        // 자릿수가 증가하기 전까지 0부터 세어줘야 함
        // 앞부분이 16일 때 전체는 16666으로 6이 3개보다 1개 많아짐 -> 16660~16669(10개)
        // 앞부분이 66일 때 전체는 66666으로 6이 3개보다 2개 많아짐 -> 66600~66699(100개)
        val sixCount = prefixNumber.toString().takeLastWhile { it == '6' }.count()
        // 모든 단위는 기본적으로 9개의 종말숫자를 가짐
        val numberCount = 9 + 10f.pow(sixCount).toInt()

        if (remainCount - numberCount < 1) {
            break
        } else {
            // 셀 필요가 없는 범위의 종말숫자 개수들을 한번에 차감시킴
            remainCount -= numberCount
            ++range
        }
    }

    /**
     * 2. 단위 내에서 숫자 찾기
     * n단위의 첫번째 숫자부터 1씩 증가시키면서
     * 숫자에 666이 포함되어있을 때마다(종말숫자)
     * 남아있는 카운트를 1씩 차감
     */
    // 단위가 2라면, 해당 단위의 첫번째 숫자는 20666
    var titleNumber = (range * 10000) + 666
    while (remainCount > 0) {
        if (titleNumber.toString().contains("666")) --remainCount
        if (remainCount == 0) break

        ++titleNumber
    }

    return titleNumber
}