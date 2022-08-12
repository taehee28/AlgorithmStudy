fun main() {
    val case = readLine()?.toInt() ?: return
    val numbers = readLine()?.split(" ") ?: return
    countPrimeNumber(numbers)
}

private fun countPrimeNumber(numbers: List<String>) {
    var count = numbers
        .stream()
        .filter { it.toInt() > 1 }
        .filter { strNumber ->
            val number = strNumber.toInt()
            (2 until number).none { number % it == 0 }
        }
        .count()

    println(count)
}