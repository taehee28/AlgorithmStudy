import java.io.StreamTokenizer

private lateinit var arr: IntArray
private val operations = IntArray(4)
private var max = -1_000_000_000
private var min = 1_000_000_000
private var count = 0

private const val PLUS = 0
private const val MINUS = 1
private const val TIMES = 2
private const val DIVIDED = 3

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    count = i()

    arr = IntArray(count) { i() }
    repeat(4) { operations[it] = i() }

    insertOperation(arr[0])

    print("$max\n$min")
}

private fun insertOperation(value: Int, depth: Int = 1) {
    if (count == depth) {
        max = if (value > max) value else max
        min = if (value < min) value else min
        return
    }

    // DFS를 진행하면서 값을 계산한다
    for (i in operations.indices) {
        if (operations[i] > 0) {
            --operations[i]

            insertOperation(
                value = when (i) {
                    PLUS -> value + arr[depth]
                    MINUS -> value - arr[depth]
                    TIMES -> value * arr[depth]
                    DIVIDED -> value / arr[depth]
                    else -> throw IllegalArgumentException()
                },
                depth = depth + 1
            )

            ++operations[i]
        }
    }
}