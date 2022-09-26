import java.io.StreamTokenizer
import kotlin.math.log2
import kotlin.math.roundToInt

var process = 0

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val count = i()
    process = i()

    if (log2(count.toFloat()).times(count).roundToInt() < process) {
        print("-1")
        return@run
    }

    val arr = IntArray(count) { i() }
    mergeSort(arr, 0, arr.lastIndex)
}

private fun mergeSort(arr: IntArray, left: Int, right: Int, sorted: IntArray = IntArray(arr.size)) {
    if (left == right) return

    val mid = (left + right) / 2

    mergeSort(arr, left, mid, sorted)
    mergeSort(arr, mid + 1, right, sorted)

    merge(arr, sorted, left, right, mid)
    if (process == 0) return
}

private fun merge(arr: IntArray, sorted: IntArray, left: Int, right: Int, mid: Int) {
    var lPivot = left
    var rPivot = mid + 1
    var index = left

    while (lPivot <= mid && rPivot <= right) {
        if (arr[lPivot] <= arr[rPivot]) {
            sorted[index++] = arr[lPivot++]
        } else {
            sorted[index++] = arr[rPivot++]
        }
    }

    while (lPivot <= mid) {
        sorted[index++] = arr[lPivot++]
    }

    while (rPivot <= right) {
        sorted[index++] = arr[rPivot++]
    }

    for (i in left..right) {
        arr[i] = sorted[i]

        if (--process == 0 ) {
            print(arr[i])
            break
        }
    }
}