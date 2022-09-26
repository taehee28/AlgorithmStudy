import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val arr = IntArray(i()) { i() }
    val sorted = arr.heapSort()

    // 정렬된 배열을 순회하면서
    // 각 원소의 rank를 저장
    val map = mutableMapOf<Int, Int>()
    var rank = 0
    sorted.forEach {
        if (!map.containsKey(it)) {
            map[it] = rank++
        }
    }

    val sb = StringBuilder()
    arr.forEach { sb.append(map[it]).append(" ") }
    print(sb.toString())
}

private fun IntArray.heapSort(): IntArray {
    if (size < 2) return this

    val sortedArr = copyOf().apply {
        for (i in (lastIndex-1)/2 downTo 0) {
            heapify(i, size)
        }

        for (i in lastIndex downTo 1) {
            swap(i, 0)
            heapify(0, i)
        }
    }

    return sortedArr
}

private fun IntArray.heapify(i: Int, size: Int) {
    var parent = i
    val left = i * 2 + 1
    val right = i * 2 + 2

    if (left < size && this[parent] < this[left]) {
        parent = left
    }

    if (right < size && this[parent] < this[right]) {
        parent = right
    }

    if (parent != i) {
        swap(parent, i)
        heapify(parent, size)
    }
}

private fun IntArray.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

// 음수가 포함되어있어 쓰기 힘듬
private fun IntArray.radixSort() {
    val sortedArr = IntArray(size)
    val maxLength = maxOf { it.toString().length }

    var exp = 1
    for (i in 1..maxLength) {
        countSort(sortedArr, exp)
        exp *= 10
    }
}

private fun IntArray.countSort(sortedArr: IntArray, exp: Int) {
    val countArr = IntArray(10)
    forEach { countArr[(it/exp) % 10]++ }

    for (i in 1..9) { countArr[i] += countArr[i - 1] }

    for (i in lastIndex downTo 0) {
        val index = countArr[(get(i)/exp) % 10]--
        sortedArr[index-1] = get(i)
    }

    for (i in indices) { set(i, sortedArr[i]) }
}