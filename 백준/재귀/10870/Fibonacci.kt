fun main() {
    print(fibonacci(3))
}

private tailrec fun fibonacci(number: Int, first: Int = 0, second: Int = 1): Int {
    return if (number <= 0) {
        first
    } else {
        fibonacci(number - 1, second, first + second)
    }
}