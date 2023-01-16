import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val count1 = st.nextToken().toInt()
    val count2 = st.nextToken().toInt()
    val map = HashMap<String, Int>(count1)
    val arr = mutableListOf<String>()

    repeat(count1) {
        val p = readLine()
        map[p] = it + 1
        arr.add(p)
    }

    val sb = StringBuilder()
    repeat(count2) {
        val q = readLine()
        val a = map[q] ?: arr[q.toInt() - 1]
        sb.append(a).append("\n")
    }
    print(sb.toString())
}