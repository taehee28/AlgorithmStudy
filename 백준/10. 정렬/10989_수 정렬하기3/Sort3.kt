import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()

    val arr = IntArray(10001)

    repeat(count) {
        val index = br.readLine().toInt()
        ++arr[index]
    }

    val sb = StringBuilder()
    arr.forEachIndexed { index, i ->
        repeat(i) {
            sb.append(index).append("\n")
        }
    }

    print(sb.toString())
}