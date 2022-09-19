import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()

    val arr = IntArray(8001)
    var (max, min) = -4000 to 4000
    var sum = 0
    var maxFrequency = 0
    var (maxFirst, maxSecond) = 0 to 4001

    // 반복문 횟수 최대한 줄여서
    repeat(count) {
        val num = br.readLine().toInt()
        arr[num + 4000]++

        sum += num

        if (max < num) max = num
        if (min > num) min = num

        when {
            maxFrequency < arr[num + 4000] -> {
                maxFrequency = arr[num + 4000]
                maxFirst = num
                maxSecond = 4001
            }
            maxFrequency == arr[num + 4000] -> {
                if (maxFirst > num) {
                    maxSecond = maxFirst
                    maxFirst = num
                } else if (num in maxFirst until maxSecond) {
                    maxSecond = num
                }
            }
        }
    }

    val average = (sum / count.toFloat()).roundToInt()

    var middleCount = 0
    var middleValue = 0
    for (i in arr.indices) {
        middleCount += arr[i]
        if (middleCount > count/2) {
            middleValue = i - 4000
            break
        }
    }


    print("${average}\n${middleValue}\n${if(maxSecond == 4001) maxFirst else maxSecond}\n${max - min}")
}