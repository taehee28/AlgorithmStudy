import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }

    val map = hashSetOf<Int>()
    repeat(i()) {
        map.add(i())
    }

    val sb = StringBuilder()
    repeat(i()) {
        sb.append(if (map.contains(i())) 1 else 0).append(" ")
    }
    print(sb.toString())
}