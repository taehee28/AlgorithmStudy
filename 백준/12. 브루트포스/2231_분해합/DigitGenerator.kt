import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = StringTokenizer(br.readLine()).nextToken().toInt()

    print(getGenerator(number))
}

private fun getGenerator(number: Int): Int {
    val length = number.toString().length
    val min = (number - (length * 9)).takeIf { it >= 0 } ?: 0
    val max = number - length


    for (i in min..max) {
        var sum = i
        i.toString().forEach { sum += it.digitToInt() }

        if (sum == number) return i
    }

    return 0
}