// https://www.acmicpc.net/problem/19941

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val input = readln().toList()

    val hamburger = ArrayDeque<Int>()
    val person = ArrayDeque<Int>()

    input.forEachIndexed { index, c ->
        if (c == 'H')
            hamburger.addLast(index)
        else
            person.addLast(index)
    }

    var cnt = 0
    while (hamburger.isNotEmpty() && person.isNotEmpty()) {
        val dist = hamburger.first() - person.first()

        if (dist > k) {
            person.removeFirst()
        } else if (dist < -k) {
            hamburger.removeFirst()
        } else {
            person.removeFirst()
            hamburger.removeFirst()
            cnt++
        }
    }

    println(cnt)
}