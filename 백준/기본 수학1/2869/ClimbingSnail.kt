import kotlin.math.ceil

fun main() {
    val input = readLine()
    val result = input?.let { str ->
        getClimbingDays(str.split(" ").map { it.toInt() }.toIntArray())
    }
    print(result)
}

private fun getClimbingDays(input: IntArray): Int {
    val (up, down, height) = input
    val meterPerDay = up - down

    var days = ((height - up) / meterPerDay.toDouble()) + 1
    days = ceil(days)

    return days.toInt()
}