import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val count = st.nextToken().toInt()


    val arr = IntArray(count) {
        st = StringTokenizer(br.readLine())
        st.nextToken().toInt()
    }

    for (i in 0..arr.lastIndex) {
        for (j in i..arr.lastIndex) {
            if (arr[i] > arr[j]) {
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
        println(arr[i])
    }
}