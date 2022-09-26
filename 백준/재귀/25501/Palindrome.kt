import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    fun s(): String { nextToken(); return sval }

    val sb = StringBuilder()
    repeat(i()) {
        val (result, count) = s().isPalindrome()
        sb.append(result).append(" ").append(count).append("\n")
    }
    print(sb.toString())
}

private tailrec fun String.isPalindrome(left: Int = 0, right: Int = length-1, count: Int = 1): Pair<Int, Int> {
    return when {
        left >= right -> 1 to count
        this[left] != this[right] -> 0 to count
        else -> isPalindrome(left+1, right-1, count+1)
    }
}