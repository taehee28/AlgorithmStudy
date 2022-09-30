import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }

    /**
     * 맨처음 제출한 답
     */
    fun solution1() {
        val x = HashSet<Int>()
        val y = HashSet<Int>()
        repeat(3) {
            val a = i()
            if (x.remove(a).not()) x.add(a)

            val b = i()
            if (y.remove(b).not()) y.add(b)
        }

        print(StringBuilder().append(x.first()).append(" ").append(y.first()))
    }

    /**
     * 실행시간 단축시키기 위한 답 
     */
    fun solution2() {
        val x1 = i(); val y1 = i()
        val x2 = i(); val y2 = i()
        val x3 = i(); val y3 = i()

        val p = if (x1 == x2) {
            x3
        } else if (x3 == x1) {
            x2
        } else {
            x1
        }

        val q = if (y1 == y2) {
            y3
        } else if (y3 == y1) {
            y2
        } else {
            y1
        }

        print(StringBuilder().append(p).append(" ").append(q))
    }
}