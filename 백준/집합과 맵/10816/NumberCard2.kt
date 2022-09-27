import java.util.StringTokenizer

fun main() {
    var count = readln().toInt()
    var st = StringTokenizer(readln())
    val map = mutableMapOf<String, Int>()
    repeat(count) {
        val num = st.nextToken()
        map[num] = map.getOrDefault(num, 0) + 1
    }

    count = readln().toInt()
    st = StringTokenizer(readln())
    val sb = StringBuilder()
    repeat(count) { sb.append(map.getOrDefault(st.nextToken(), 0)).append(" ") }
    print(sb.toString())
}