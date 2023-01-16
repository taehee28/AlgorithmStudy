import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()

    val list = mutableListOf<Pair<Int, Int>>()
    repeat(count) {
        val (x, y) = br.readLine().split(" ")
        list.add(x.toInt() to y.toInt())
    }

    list.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })

    val sb = StringBuilder()
    list.forEach { sb.append(it.first).append(" ").append(it.second).append("\n") }

    print(sb.toString())
}
