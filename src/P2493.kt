// https://www.acmicpc.net/problem/2493

import java.util.PriorityQueue

data class Tower(val height: Int, val idx: Int) : Comparable<Tower> {
    override fun compareTo(other: Tower): Int = height - other.height
}

fun main() {
    val n = readln().toInt()
    val arr = intArrayOf(Int.MAX_VALUE).plus(readln().split(" ").map { it.toInt() }.toIntArray())
    val reach = IntArray(n)

    val minHeap = PriorityQueue<Tower>()
    minHeap.add(Tower(arr[n], n))

    for (i in arr.size - 2 downTo 0) {
        val facedTowerHeight = arr[i]

        // step 1. extract towers having lower height than facedTowerHeight
        while (minHeap.isNotEmpty() && minHeap.peek().height < facedTowerHeight) {
            minHeap.poll().run {
                reach[idx - 1] = i
            }
        }

        // step 2. insert the looking tower into minHeap
        minHeap.add(Tower(facedTowerHeight, i))
    }

    // step 3. print it with checking a condition
    println(reach.joinToString(" "))
}
