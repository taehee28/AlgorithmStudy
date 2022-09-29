import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val count1 = i()
    val count2 = i()

    val set = HashSet<Int>()
    repeat(count1) { set.add(i()) }

    val list = mutableListOf<Int>()
    repeat(count2) { list.add(i()) }

    var count = 0
    list.forEach { if (set.contains(it)) ++count }

    print((count1 - count) + (count2 - count))
}