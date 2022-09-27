import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    fun s(): String { nextToken(); return sval }
    val count1 = i()
    val count2 = i()

    val set = HashSet<String>(count1)
    repeat(count1) { set.add(s()) }

    var count = 0
    repeat(count2) { if (set.contains(s())) ++count }

    print(count)
}