fun main() {
    val input = readLine()?.toInt() ?: return
    print(getSugarBags(input))
}

private fun getSugarBags(input: Int): Int {
    return when (input % 5) {
        1 -> if (input < 6) {
            -1
        } else {
            (input / 5) + 1
        }
        2 -> if (input < 12) {
            -1
        } else {
            (input / 5) + 2
        }
        3 -> if (input < 3) {
            -1
        } else {
            (input / 5) + 1
        }
        4 -> if (input < 9) {
            -1
        } else {
            (input / 5) + 2
        }
        else -> input/5
    }
}

/**
 * 사람들이 작성한 답 참고하여 작성
 */
private fun getSugarBagsAnotherVer(input: Int): Int {
    val quotientOfFive = input / 5

    for (n in quotientOfFive downTo 0) {
        val quotientOfThree = (input - (n * 5)) / 3

        if ((n * 5) + (quotientOfThree * 3) == input) {
            return n + quotientOfThree
        }
    }

    return -1
}