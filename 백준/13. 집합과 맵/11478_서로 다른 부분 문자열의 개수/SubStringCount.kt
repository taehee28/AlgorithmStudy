fun main() {
    val str = readln()
    var count = 0
    for (i in 1..str.length) {
        count += str.windowedSequence(i).distinct().count()
    }
    print(count)
}