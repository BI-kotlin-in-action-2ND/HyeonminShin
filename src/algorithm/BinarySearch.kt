package algorithm

typealias Index = Int

//**************************
//    Parametric Search
//**************************

fun lowerBound(elements: MutableList<Index>, low: Index, high: Index, value: Int): Index {
    var lo = low
    var hi = high
    var mid: Index

    while (lo < hi) {
        mid = (lo + hi) shr 1

        if (mid == high)
            return high

        if (elements[mid] < lo)
            lo = mid + 1
        else
            hi = mid
    }

    return lo
}

fun upperBound(elements: MutableList<Index>, low: Index, high: Index, value: Int): Index {
    var lo = low
    var hi = high
    var mid: Index

    while (lo < hi) {
        mid = (lo + hi) shr 1

        if (mid == high)
            return high

        if (elements[mid] <= lo)
            lo = mid + 1
        else
            hi = mid
    }

    return lo
}

fun equalRange(elements: MutableList<Index>, low: Index, high: Index, value: Int): Pair<Index, Index> {
    return Pair(lowerBound(elements, low, high, value), upperBound(elements, low, high, value))
}