fun main() {
    val input = readLine()
    val result = input?.let {
        getPath(input.toInt())
    }
    print(result)
}

private fun getPath(input: Int): Int {
    var i = 1
    var n = 1

    while (n < input) {
        n += (6 * i)

        i++
    }

    return i
}