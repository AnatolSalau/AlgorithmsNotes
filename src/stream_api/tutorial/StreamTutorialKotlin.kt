package stream_api.tutorial

fun main(args: Array<String>) {
    fun findAllEvenKotlin() {
        val nums: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val filter = nums.filter { it -> it % 2 == 0 }
        println(filter)
    }

    fun findAllStartFromZeroKotlin() {
        val nums: List<Int> = listOf(10, 15, 8, 49, 25, 98, 32)
        val res = nums
            .map { it.toString() }
            .filter { it.startsWith("1") }
            .map { it.toInt() }
        println(res)
    }

    fun findDuplicates() {
        val nums: List<Int> = listOf(10, 15, 8, 49, 25, 98, 98, 32, 15)
        val res = nums
            .groupingBy { it }
            .eachCount()
            .filter { it.value > 1 }
            .map {it.value}
            .toList()
        println(res)
    }

    fun findFirstTest() {
        val list: List<Int> = listOf(10, 15, 8, 49, 25, 98, 98, 32, 15)
        val first = list.first()

        println(first)
    }

    fun firstFirstNonRepeatingCharacterTest() {
        val input = "Java articles are Awesome"
        val eachCount: Map<Char, Int> = input
            .groupingBy { it }
            .eachCount()

        val res = eachCount
            .filter { it.value == 1 }
            .map { it.key }
            .first()
            .toString()
        println(res)
    }

    fun sortArrTest() {
        val list: List<Int> = listOf(10, 15, 8, 49, 25, 98, 98, 32, 15);
        val sorted = list.sorted()
        println(sorted)
    }

    fun sortArrTestDesc() {
        val list: List<Int> = listOf(10, 15, 8, 49, 25, 98, 98, 32, 15);
        list.sortedDescending()
        println(list)
    }

    firstFirstNonRepeatingCharacterTest()
    sortArrTest()
    sortArrTestDesc()
    findAllStartFromZeroKotlin()
}

