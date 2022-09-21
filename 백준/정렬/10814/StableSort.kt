import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    fun s(): String { nextToken(); return sval }

    // String이 계속 변경될 것임으로 StringBuilder로 String 저장하기
    val arr = Array(201) { StringBuilder() }
    repeat(i()) {
        val age = i()
        arr[age].append(age).append(" ").append(s()).append("\n")
    }

    val sb = StringBuilder()
    arr.forEach { sb.append(it.toString()) }
    print(sb.toString())
}