fun main() {
    val values = readLine()
    val result = values?.let {
        val split = it.split(" ").map { str -> str.toInt() }
        getBreakEventPoint(split.toIntArray())
    }
    println(result)
}

private fun getBreakEventPoint(values: IntArray): Int {
    val (a, b, c) = values

    return if (b < c) {
        (a / (c - b)) + 1
    } else {
        -1
    }
}