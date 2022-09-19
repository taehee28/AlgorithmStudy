import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = br.readLine()!!

    val sb = StringBuilder()
    number.toList().sortedDescending().forEach { sb.append(it) }
    print(sb.toString())
}