fun main() {
    val input = readLine()
    val result = input?.let {
        getFraction(it.toInt())
    }
    print(result)
}

private fun getFraction(input: Int): String {
    var count = 0
    var base = 1

    for (i in 1..input) {
        count++

        if (count > base) {
            base++
            count = 1
        }
    }

    val a = count
    val b = base - (count - 1)

    return if (base%2 == 0) {
        "$a/$b"
    } else {
        "$b/$a"
    }
}