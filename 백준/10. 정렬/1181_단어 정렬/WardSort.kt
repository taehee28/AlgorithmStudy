import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): String { nextToken(); return sval }

    nextToken()
    val set = mutableSetOf<String>()
    repeat(nval.toInt()) { set.add(i()) }

    val sb = StringBuilder()
    set.asSequence().sortedWith(compareBy({ it.length }, { it })).forEach { sb.append(it).append("\n") }
    print(sb.toString())
}