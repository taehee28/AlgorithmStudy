import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    fun s(): String { nextToken(); return sval }
    val count1 = i()
    val count2 = i()

    val set = HashSet<String>()
    repeat(count1) { set.add(s()) }

    val list = MutableList(count2) { s() }
    list.sort()

    val sb = StringBuilder()
    var count = 0
    list.forEach {
        // contains는 O(1)
        if (set.contains(it)) {
            ++count
            sb.appendLine(it)
        }
    }
    sb.insert(0, "$count\n")
    print(sb.toString())
}