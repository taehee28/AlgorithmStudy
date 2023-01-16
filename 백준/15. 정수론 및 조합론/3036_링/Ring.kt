import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val count = i() - 1
    val ring = i()
    val sb = StringBuilder()
    repeat(count) {
        val other = i()
        val gcd = ring.gcd(other)
        sb.append(ring / gcd).append("/").appendLine(other / gcd)
    }
    print(sb.toString())
}

private tailrec fun Int.gcd(other: Int): Int {
    return if (other == 0) {
        this
    } else {
        other.gcd(this % other)
    }
}