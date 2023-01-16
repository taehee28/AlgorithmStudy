import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val studentCount = st.nextToken().toInt()
    val winnerCount = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val arr = IntArray(studentCount) {
        st.nextToken().toInt()
    }

    arr.sortDescending()
    print(arr[winnerCount-1])
}