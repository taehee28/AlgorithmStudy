import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()

    val arr = IntArray(count)
    for (i in 0 until count) {
        arr[i] = br.readLine().toInt()
    }

    heapSort(arr)

    val sb = StringBuilder()
    for (i in arr.indices) {
        sb.append("${arr[i]}\n")
    }

    print(sb.toString())
}

private fun heapSort(arr: IntArray) {
    if (arr.size < 2) return

    for (i in (arr.lastIndex - 1)/2 downTo 0) {
        heapify(arr, i, arr.size)
    }

    for (i in arr.lastIndex downTo 1) {
        arr.swap(0, i)
        heapify(arr, 0, i)
    }
}

private fun heapify(arr: IntArray, i: Int, size: Int) {
    var parent = i
    val left = i * 2 + 1
    val right = i * 2 + 2

    if (left < size && arr[parent] < arr[left]) {
        parent = left
    }

    if (right < size && arr[parent] < arr[right]) {
        parent = right
    }

    if (parent != i) {
        arr.swap(parent, i)
        heapify(arr, parent, size)
    }
}

private fun IntArray.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}