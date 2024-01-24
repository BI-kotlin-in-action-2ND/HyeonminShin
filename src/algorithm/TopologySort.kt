package algorithm

import java.util.PriorityQueue

class TopologySort(n: Int) {
    private val graph: Array<MutableList<Int>> = Array(n + 1) { mutableListOf() }
    private val inDegree = IntArray(n + 1)
    private val result = mutableListOf<Int>()

    fun addEdge(
        start: Int,
        end: Int,
    ) {
        graph[start].add(end)
        inDegree[end]++
    }

    fun sort() {
        val pq = PriorityQueue<Int>()

        inDegree.forEachIndexed { i, it ->
            if (i > 0 && it == 0) pq.add(i)
        }

        while (pq.isNotEmpty()) {
            val now = pq.poll()

            result.add(now)

            graph[now].forEach { it ->
                if (--inDegree[it] == 0) pq.add(it)
            }
        }
    }

    fun printResult() = println(result.joinToString(" "))
}
