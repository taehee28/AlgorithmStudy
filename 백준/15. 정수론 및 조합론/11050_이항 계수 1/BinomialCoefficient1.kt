import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    print(i() combination i())
}

private tailrec fun Int.factorial(acc: Int = 1): Int =
    if (this <= 1) acc else (this - 1).factorial(acc * this)

private infix fun Int.combination(r: Int): Int {
    return if (r == 0 || r == this) {
        1
    } else {
        (this.factorial() / (this - r).factorial()) / r.factorial()
    }
}