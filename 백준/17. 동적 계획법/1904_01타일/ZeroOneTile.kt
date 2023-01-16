fun main() {
    val number = readln().toInt()
    print(fib(number))
}

private tailrec fun fib(number: Int, first: Int = 1, second: Int = 1): Int {
    return if (number <= 0) {
        first
    } else {
        fib(number - 1, second, (first + second) % 15746)
    }
}