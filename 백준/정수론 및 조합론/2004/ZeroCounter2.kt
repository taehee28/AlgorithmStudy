import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }

    val n = i()
    val k = i()

    val five = n.countFive() - ((n - k).countFive() + k.countFive())
    val two = n.countTwo() - ((n - k).countTwo() + k.countTwo())
    print(if (five < two) five else two)
}

fun Int.countFive(): Int {
    var number = this
    var count = 0
    while (number >= 5) {
        count += number / 5
        number /= 5
    }
    return count
}

fun Int.countTwo(): Int {
    var number = this
    var count = 0
    while (number >= 2) {
        count += number / 2
        number /= 2
    }
    return count
}