// https://www.acmicpc.net/problem/14658

data class Point(val x: Int, val y: Int)

val stars = mutableListOf<Point>()

fun main() {
    val (_, _, l, k) = readln().split(" ").map { it.toInt() }
    repeat(k) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        stars.add(Point(x, y))
    }

    // Brute force with given stars (cuz star exists maximum 100)
    val result =
        stars.maxOf { i ->
            stars.maxOf { j ->
                capturedStar(i.x, j.y, l)
            }
        }

    println(k - result)
}

fun capturedStar(
    x: Int,
    y: Int,
    l: Int,
): Int {
    return stars.count { star ->
        x <= star.x && star.x <= x + l && y <= star.y && star.y <= y + l
    }
}
