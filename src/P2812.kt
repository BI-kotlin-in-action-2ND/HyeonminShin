// https://www.acmicpc.net/problem/2812

// Greedy with stack
// 가능한 이유: 숫자의 순서를 유지하기 때문에 그리디임에도 최적의 해를 보장해줌.

import java.util.Stack

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val number = readln().map { it.digitToInt() }.toIntArray()

    var cnt = 0
    val stack = Stack<Int>()

    number.forEach { num ->
        while (cnt < k && stack.isNotEmpty() && stack.peek() < num) {
            stack.pop()
            cnt++
        }
        stack.push(num)
    }

    println(stack.subList(0, n - k).joinToString(""))
}
