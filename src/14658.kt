// https://www.acmicpc.net/problem/14658

import kotlin.math.max

data class Point(val x: Int, val y: Int)

val stars = mutableListOf<Point>()
var max = 1

fun main() {
    val (n, m, l, k) = readln().split(" ").map { it.toInt() }
    repeat(k) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        stars.add(Point(x, y))
    }

    // Brute force with given stars (cuz star exists maximum 100)
    var result = Int.MIN_VALUE
    stars.forEach { i ->
        stars.forEach { j ->
            result = max(result, capturedStar(i.x, j.y, l))
        }
    }

    println(k - result)
}

fun capturedStar(x: Int, y: Int, l: Int): Int {
    var cnt = 0

    stars.forEach { star ->
        if (x <= star.x && star.x <= x + l &&
            y <= star.y && star.y <= y + l
        )
            cnt++
    }

    return cnt
}