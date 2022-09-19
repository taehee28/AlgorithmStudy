import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt

fun main() {
    // 직접 for문 돌리는게 더 빠른듯
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()

    val valueMap = mutableMapOf<Int, Int>()
    repeat(count) {
        val num = br.readLine().toInt()
        valueMap[num] = valueMap.getOrDefault(num, 0) + 1
    }

    val sb = StringBuilder()

    // 산술평균
    val sum = valueMap.asSequence()
        .map { it.key * it.value }
        .sum()
    sb.append((sum / count.toDouble()).roundToInt()).append("\n")

    // 중앙값
    var middle = count/2
    val m = valueMap.asSequence()
        .sortedBy { it.key }
        .find {
            middle -= it.value
            middle < 0
        }?.key ?: -1
    sb.append(m).append("\n")

    // 최빈값
    val maxFrequency = valueMap.maxOf { it.value }
    val list = valueMap.asSequence().filter { it.value == maxFrequency }.map { it.key }.sorted().toList()
    sb.append(list.getOrNull(1) ?: list[0]).append("\n")

    // 범위
    sb.append(valueMap.maxOf { it.key } - valueMap.minOf { it.key }).append("\n")

    print(sb.toString())
}