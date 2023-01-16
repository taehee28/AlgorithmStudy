import java.io.StreamTokenizer
import kotlin.math.absoluteValue
import kotlin.math.sqrt

/**
 * 어떤 수 N을 다음과 같이 표현 가능하다 -> N = M * n + R (M = 나눈 수, R = 나머지)
 * 입력으로 들어온 수들을 같은 나머지 수 R을 갖게 하는 공통된 수 M으로 표현하면 다음과 같다.
 * A = M * a + R
 * B = M * b + R
 * C = M * c + R
 * ...
 *
 * 공통 된 수 M을 알아내기 위해서 앞뒤로 있는 수끼리 뺀다.
 * B - A = M(b - a)
 * C - B = M(c - b)
 * 이렇게 나온 M(b - a)와 M(c - b)에 공통으로 곱해져있는 M(=최대공약수)를 구하기 위해 유클리드 호제법을 사용한다.
 *
 * 최종적으로 구해진 M의 약수들도 M 처럼 입력으로 받은 수를 나눴을 때 같은 R이 나오게 하기 때문에
 * 1을 제외한 M의 약수들이 최종 답이 된다.
*/
fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val arr = List(i()) { i() }
    val result = arr.zipWithNext { a, b ->  (a - b).absoluteValue }.reduce { acc, i -> acc.gcd(i) }

    val sb = StringBuilder()
    val set = mutableSetOf(result)
    for (i in 2..sqrt(result.toFloat()).toInt()) {
        if (result % i == 0) {
            set.add(i)
            set.add(result / i)
        }
    }
    set.sorted().forEach { sb.append(it).append(" ") }
    print(sb.toString())
}

private tailrec fun Int.gcd(other: Int): Int {
    return if (other == 0) {
        this
    } else {
        other.gcd(this % other)
    }
}