fun main() {
    println(factorial(10, 1))
}

private tailrec fun factorial(number: Int, acc: Int): Int {
    return if (number <= 1) {
        acc
    } else {
        factorial(number - 1, number * acc)
    }
}