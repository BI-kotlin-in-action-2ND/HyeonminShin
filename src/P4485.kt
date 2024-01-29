// https://www.acmicpc.net/problem/4485

// Dijkstra + BFS
// 하나의 시작, 하나의 종점
// PriorityQueue를 적용하여 O(N*logN)

import java.util.PriorityQueue

var n = 0

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

val cave: Array<IntArray> by lazy {
    Array(n) {
        readln().split(" ").map { it.toInt() }.toIntArray()
    }
}
val distance: Array<IntArray> by lazy {
    Array(n) {
        IntArray(n) { Int.MAX_VALUE }
    }
}

data class State(val x: Int, val y: Int, val lose: Int) : Comparable<State> {
    override fun compareTo(other: State): Int = lose - other.lose
}

fun main() {
    var i = 1
    while (true) {
        n = readln().toInt()
        if (n == 0) break

        bfs()
        println("Problem ${i++}: ${distance[n - 1][n - 1]}")
    }
}

fun bfs() {
    val pq =
        PriorityQueue<State>().apply {
            offer(State(0, 0, cave[0][0]))
            distance[0][0] = cave[0][0]
        }

    while (pq.isNotEmpty()) {
        val now = pq.poll()
        val x = now.x
        val y = now.y

        for (i in dx.indices) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0..<n &&
                ny in 0..<n &&
                distance[nx][ny] > distance[x][y] + cave[nx][ny]
            ) {
                distance[nx][ny] = distance[x][y] + cave[nx][ny]
                pq.add(State(nx, ny, distance[nx][ny]))
            }
        }
    }
}
