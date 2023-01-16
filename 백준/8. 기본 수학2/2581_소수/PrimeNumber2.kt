import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val min = StringTokenizer(br.readLine()).nextToken().toInt()
    val max = StringTokenizer(br.readLine()).nextToken().toInt()

    var minPrimeNumber = -1

    val sum = (min..max)
        .filter { it.isPrime() }
        .sumOf {
            if (minPrimeNumber == -1) minPrimeNumber = it
            it
        }

    if (sum != 0) println(sum)
    println(minPrimeNumber)
}

fun Int.isPrime(): Boolean {
    return if (this < 2) {
        false
    } else {
        (2 until this).none { this % it == 0 }
    }
}




