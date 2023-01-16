import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    System.out.bufferedWriter().use {
        while (true) {
            val a = i()
            if (a == 0) break

            val b = i()
            val c = i()

            val result = if (a > b) {
                if (a > c) isRight(b, c, a) else isRight(a, b, c)
            } else {
                if (b > c) isRight(a, c, b) else isRight(a, b, c)
            }

            it.write(if (result) "right" else "wrong")
            it.newLine()
        }
        it.flush()
    }
}

private fun isRight(a: Int, b: Int, c: Int) = a*a + b*b == c*c