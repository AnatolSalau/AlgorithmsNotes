package stream_api.tutorial

fun main(args: Array<String>) {
    fun findAllEvenKotlin() {
        val nums: List<Int> = listOf(1,2,3,4,5,6,7,8,9,10)
        val filter = nums.filter { it % 2 == 0 }
        println(filter)
    }

    findAllEvenKotlin()
}

