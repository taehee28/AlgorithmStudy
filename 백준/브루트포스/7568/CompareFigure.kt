import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = StringTokenizer(br.readLine()).nextToken().toInt()

    val list = mutableListOf<String>()
    repeat(size) {
        list.add(StringTokenizer(br.readLine()).nextToken("\n"))
    }

    print(getRanks(list))
}

private fun getRanks(list: List<String>): String {
    val sb = StringBuilder()

    for ((index1, s1) in list.withIndex()) {
        val (n, m) = s1.split(" ").let { it.first().toInt() to it.last().toInt() }
        var rank = 1

        for ((index2, s2) in list.withIndex()) {
            if (index1 == index2) continue

            val (a, b) = s2.split(" ").let { it.first().toInt() to it.last().toInt() }
            if (n < a && m < b) {
                ++rank
            }
        }

        sb.append("$rank ")
    }

    return sb.toString()
}