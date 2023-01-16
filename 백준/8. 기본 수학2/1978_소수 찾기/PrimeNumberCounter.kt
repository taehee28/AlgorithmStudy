import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val case = st.nextToken()

    st = StringTokenizer(br.readLine())
    val numbers = Array(case.toInt()) { st.nextToken() }

    countPrimeNumber(numbers)
}

private fun countPrimeNumber(numbers: Array<String>) {
    var count = numbers
        .filter { it.toInt() > 1 }
        .count { strNumber ->
            val number = strNumber.toInt()
            (2 until number).none { number % it == 0 }
        }

    println(count)
}
