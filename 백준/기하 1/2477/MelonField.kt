import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val melonCount = i()
    // 인덱스를 0으로 초기화 하면 전체에서 가장 큰 길이가 첫번째로 입력됐을 때
    // 다른 방향의 가장 큰 길이는 전체에서 가장 큰 길이 값을 넘을 수가 없음
    var maxHeightIndex = -1
    var maxWidthIndex = -1
    val lengthArr = IntArray(6)

    repeat(6) {
        val direction = i()
        lengthArr[it] = i()

        if (direction.isVertical()) {
            maxHeightIndex = if (maxHeightIndex == -1) {
                it
            } else {
                if (lengthArr[maxHeightIndex] < lengthArr[it]) it else maxHeightIndex
            }
        } else {
            maxWidthIndex = if (maxWidthIndex == -1) {
                it
            } else {
                if (lengthArr[maxWidthIndex] < lengthArr[it]) it else maxWidthIndex
            }
        }
    }

    val bigArea = lengthArr[maxWidthIndex] * lengthArr[maxHeightIndex]
    val smallArea = lengthArr[(maxWidthIndex + 3) % 6] * lengthArr[(maxHeightIndex + 3) % 6]

    print((bigArea - smallArea) * melonCount)
}

private fun Int.isVertical(): Boolean = when (this) {
    3, 4 -> true
    1, 2 -> false
    else -> throw IllegalArgumentException()
}