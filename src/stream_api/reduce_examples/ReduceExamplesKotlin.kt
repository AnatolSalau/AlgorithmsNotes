package stream_api.reduce_examples

import stream_api.reduce_examples.ReduceExamples.User


fun main() {
    //sumUserAgesKotlin(listOf(User("Alice", 25), User("Bob", 30)))
    joinStringsStringBuilderByComma(generateStringList(1000000))
    toUpperCase(generateStringList(1000000))
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

fun joinStringsStringBuilderByComma(stringList: List<String>) {
    val start = System.currentTimeMillis()
    val reduce = stringList.joinToString(", ")
    val end = System.currentTimeMillis()
    println("joinStringsStringBuilder")
    println("time : ${end - start}")
    //println(reduce)
}

fun generateStringList(amount: Int): List<String> {
    return (0 until amount).map { "Str$it" }
}

fun toUpperCase(list: List<String>) {
    val result = list.map { it.uppercase() }
    println(result)
}
