import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val a = i()
    val b = i()

    print("${a.gdc(b)}\n${a.lcm(b)}")
}

private fun Int.gdc(other: Int): Int {
    var a = if (this > other) this else other
    var b = if (this > other) other else this

    // 유클리드 호제법 
    while(b != 0) {
        val r = a % b
        a = b
        b = r
    }

    return a
}

private fun Int.lcm(other: Int) = (this * other) / this.gdc(other)