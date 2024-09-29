package stream_api.tutorial

fun main(args: Array<String>) {
    fun findAllEvenKotlin() {
        val nums: List<Int> = listOf(1,2,3,4,5,6,7,8,9,10)
        val filter = nums.filter { it % 2 == 0 }
        println(filter)
    }

    fun findAllStartFromZeroKotlin() {
        val nums: List<Int> = listOf(10,15,8,49,25,98,32)
        val res = nums
            .map { it.toString() }
            .filter { it.startsWith("1") }
        println(res)
    }

    findAllEvenKotlin()
    findAllStartFromZeroKotlin()
}

