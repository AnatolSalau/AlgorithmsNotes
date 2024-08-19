package stream_api.intersection

fun main() {
    arrayIntersection()
}

public fun arrayIntersection(): Unit {
    val arr1: List<Int> = listOf(4, 9, 5);
    val arr2: List<Int> = listOf(9, 4, 9, 8, 4);
    val union = arr1.intersect(arr2)
    println(union)
}