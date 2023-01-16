import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val count = i()

    val arr = Array(count) {
        intArrayOf(i(), i())
    }

    val sorted = Array(count) { intArrayOf(0, 0) }

    mergeSort(arr, sorted, 0, arr.lastIndex)

    val sb = StringBuilder()
    arr.forEach { sb.append(it[0]).append(" ").append(it[1]).append("\n") }
    print(sb.toString())
}

private fun mergeSort(arr: Array<IntArray>, sorted: Array<IntArray>, left: Int, right: Int) {
    if (left == right) return

    val mid = (left + right) / 2

    mergeSort(arr, sorted, left, mid)
    mergeSort(arr, sorted,mid + 1, right)

    merge(arr, sorted, left, right, mid)
}

private fun merge(arr: Array<IntArray>, sorted: Array<IntArray>, left: Int, right: Int, mid: Int) {
    var lPivot = left
    var rPivot = mid + 1
    var index = left

    while (lPivot <= mid && rPivot <= right) {
        if (arr[lPivot][0] < arr[rPivot][0]) {
            sorted[index++] = arr[lPivot++]
        } else if (arr[lPivot][0] == arr[rPivot][0]) {
            if (arr[lPivot][1] <= arr[rPivot][1]) {
                sorted[index++] = arr[lPivot++]
            } else {
                sorted[index++] = arr[rPivot++]
            }
        } else {
            sorted[index++] = arr[rPivot++]
        }
    }

    if (lPivot > mid) {
        while (rPivot <= right) {
            sorted[index++] = arr[rPivot++]
        }
    } else if (rPivot > right) {
        while (lPivot <= mid) {
            sorted[index++] = arr[lPivot++]
        }
    }

    for (i in left..right) {
        arr[i] = sorted[i]
    }
}