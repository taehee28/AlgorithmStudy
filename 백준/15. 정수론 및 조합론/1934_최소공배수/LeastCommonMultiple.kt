import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val sb = StringBuilder()
    repeat(i()) {
        sb.appendLine(i().lcm(i()))
    }

    print(sb.toString())
}

private fun Int.gcd(other: Int): Int {
    var a = if (this > other) this else other
    var b = if (this > other) other else this

    while (b != 0) {
        val r = a % b
        a = b
        b = r
    }

    return a
}

private fun Int.lcm(other: Int): Int = (this * other) / this.gcd(other)