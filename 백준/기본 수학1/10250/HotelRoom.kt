import kotlin.math.ceil

fun main() {
    val caseCount = readLine()?.toInt() ?: return

    repeat(caseCount) {
        readLine()?.let {
            println(getShortestRoom(it))
        }
    }
}

private fun getShortestRoom(input: String): String {
    val (height, width, number) = input.split(" ").map { it.toInt() }

    val yy = (number % height).let { if (it == 0) height else it }
    val xx = ceil((number / height.toFloat())).toInt()

    return "%d%02d".format(yy, xx)
}