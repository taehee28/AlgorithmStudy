import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    System.out.bufferedWriter().use {
        val x = i(); val y = i(); val w = i(); val h = i()
        val a = if (w - x < h - y) w - x else h - y
        val b = if (x < y) x else y
        it.write((if (a < b) a else b).toString())
        it.flush()
    }
}