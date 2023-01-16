import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }

    val arr = Array(i()) { i() }
    var min = 1000000
    var max = 0

    arr.forEach { 
        if (min > it) min = it
        if (max < it) max = it    
    }

    print(min * max)
}