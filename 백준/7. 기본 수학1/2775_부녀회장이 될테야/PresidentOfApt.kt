fun main() {
    val caseCount = readLine()?.toInt() ?: return

    repeat(caseCount) {
        val k = readLine()!!.toInt()
        val n = readLine()!!.toInt()
        println(getPeopleInHouse(k, n))
    }
}

private fun getPeopleInHouse(k: Int, n: Int): Int {
    return if (k == 0 || n == 1) {
        n
    } else {
        getPeopleInHouse(k, n-1) + getPeopleInHouse(k-1, n)
    }
}