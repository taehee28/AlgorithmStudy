fun main () {
    val number = readln().toInt()
    val sb = StringBuilder()
    sb.append(recursiveFib(number)).append(" ").append(dynamicFib(number))
    print(sb.toString())
}

private fun recursiveFib(count: Int): Int {
    var callCount = 0

    fun fib(n: Int): Int = if (n <= 2) {
        ++callCount
        1
    } else {
        fib(n - 1) + fib(n - 2)
    }

    fib(count)
    return callCount
}

private fun dynamicFib(count: Int): Int {
    var callCount = 0
    val map = mutableMapOf(1 to 1, 2 to 1)

    for (i in 3..count) {
        map.getOrPut(i) {
            ++callCount
            map[i - 1]!! + map[i - 2]!!
        }
    }

    return callCount
}
