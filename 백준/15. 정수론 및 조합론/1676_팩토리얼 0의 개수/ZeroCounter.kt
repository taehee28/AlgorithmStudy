import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    var number = i()
    var count = 0
    while (number >= 5) {
        count += number / 5
        number /= 5
    }
    print(count)
}