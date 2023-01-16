import java.io.StreamTokenizer
import kotlin.reflect.KProperty

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val n = i()
    val k = i()
    val arr = Array(n + 1) { IntArray(n + 1) }
    arr[1][0] = 1
    arr[1][1] = 1

    for (i in 2..arr.lastIndex) {
        for (j in 0..i) {
            if (i == j || j == 0) {
                arr[i][j] = 1
            } else {
                arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % 10007
            }
        }
    }

    print(arr[n][k])
}

// Memoize 구현해서 사용하는 방법
// 비교적 실행시간이 길다
private val lambda: (Int, Int) -> Int by Memoize { n, k ->
    if (n == k || k == 0) {
        1
    } else {
        ((lambda(n-1, k) % 10007) + (lambda(n-1, k-1) % 10007)) % 10007
    }
}

class Memoize(val func: (Int, Int) -> Int) {
    private val cache = Array(1001) { IntArray(1001) { -1 } }
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = { n: Int, k: Int ->
        if (cache[n][k] == -1) {
            cache[n][k] = func(n, k)
        }
        cache[n][k]
    }
}