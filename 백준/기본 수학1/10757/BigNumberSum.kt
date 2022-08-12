fun main() {
    val numbers = readLine()?.split(" ") ?: return
    sumBigNumber(numbers[0], numbers[1])
}

private fun sumBigNumber(a: String, b: String) {
    var (longNum, shortNum) = if (a.length > b.length) a to b else b to a

    val diff = longNum.length - shortNum.length
    shortNum = "0".repeat(diff) + shortNum

    var regrouping = 0
    var sum = ""

    for (pivot in longNum.lastIndex downTo 0) {
        val result = longNum[pivot].digitToInt() + shortNum[pivot].digitToInt() + regrouping
        regrouping = result / 10
        sum = "${result % 10}$sum"
    }

    if (regrouping == 1) sum = "$regrouping$sum"

    println(sum)
}