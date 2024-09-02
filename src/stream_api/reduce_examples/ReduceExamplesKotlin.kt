package stream_api.reduce_examples

import stream_api.reduce_examples.ReduceExamples.User


    fun main() {
        sumUserAgesKotlin(listOf(User("Alice", 25), User("Bob", 30)))
    }

    fun sumElementsKotlin(list: List<Int>): Int {
        val sum: Int = list
            .sum()
        return sum
    }

    fun joinElementsToStringKotlin(list: List<String>): String {
        val join: String = list
            .joinToString()
        return join
    }

    fun joinElementsToStringUppercaseKotlin(list: List<String>): String {
        val join: String = list
            .joinToString { it.uppercase() }
        return join
    }

    fun sumUserAgesKotlin(users: List<User>): Int {
        val sum: Int = users
            .sumOf { it.age }
        print(sum)
        return sum
    }
