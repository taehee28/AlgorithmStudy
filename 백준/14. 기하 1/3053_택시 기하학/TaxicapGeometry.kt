import kotlin.math.PI

fun main() {
    val r = readln().toInt()

    val sb = StringBuilder()
    sb.appendLine("%.6f".format((r * r) * PI))
        .append("%.6f".format((r * r) * 2.0))
    print(sb.toString())
}