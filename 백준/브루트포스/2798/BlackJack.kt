import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val cardCount = st.nextToken().toInt()
    val targetNumber = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val cards = List(cardCount) { st.nextToken().toInt() }

    print(getNumber(targetNumber, cards))
}

private fun getNumber(targetNumber: Int, cards: List<Int>): Int {
    var maxNum = 0

    for (i in 0 until cards.size - 2) {
        for (j in i + 1 until cards.size - 1) {
            for (k in j + 1 until cards.size) {
                val sum = cards[i] + cards[j] + cards[k]
                if (sum == targetNumber) {
                    return sum
                } else if (sum < targetNumber) {
                    maxNum = if (maxNum < sum) sum else maxNum
                }
            }
        }
    }



    return maxNum
}