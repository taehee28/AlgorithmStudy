import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    fun s(): String { nextToken(); return sval!! }
    val sb = StringBuilder()

    /*
    각 옷 종류마다 한개도 고르지 않는 경우를 포함히야 하기 때문에 count한 값에 1을 더한다.
    최종적으로 계산한 결과 값에 전부 아무것도 고르지 않은 경우를 제외해야 하기 때문에 1을 뺀다.
     */
    repeat(i()) {
        val arr = Array(i()) { s() to s() }
        val result = arr.groupingBy { it.second }
            .eachCount()
            .values
            .fold(1) {acc, i -> (i + 1) * acc } - 1

        sb.appendLine(result)
    }
    print(sb.toString())
}