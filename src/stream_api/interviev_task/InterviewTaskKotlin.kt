package stream_api.interviev_task

import stream_api.interviev_task.InterviewTask.Person
import java.util.*
import java.util.function.Function
import java.util.stream.Collectors


fun main() {
    //getAllWordsWithDuplicates()
    //removeAllAnimalsFromL()
    //personMapTask()
    mapWithCountFromStrKotlin()
    randomizeListLearningTestKotlin()
    findDuplicateElementsKotlin()
    findFirstUniqueTestKotlin()
    dividedIntoPresentAndAbsentTest()
}



/*
      18. Дано несколько списков слов. Получить список всех слов с этих списков
      c дубликатами
            Hello World World wide Java Stream API Java one love
      без дубликатов
            Hello World wide Java Stream API love
 */
fun getAllWordsWithDuplicates() {
    val sentences1: List<String> = listOf("Hello World", "World wide")
    val sentences2: List<String> = listOf("Java Stream API", "Java one love")

    var withDuplicates: List<String> = sentences1
        .union(sentences2)
        .flatMap { s: String -> s.split(" ") }
        .toList()
    println(withDuplicates)

    var withoutDuplicates: List<String> = sentences1
        .union(sentences2)
        .flatMap { s: String -> s.split(" ") }
        .distinct()
        .toList()
    println(withoutDuplicates)
}

fun removeAllAnimalsFromL() {
    var animals: List<String> = listOf("Тигр", "Лев", "Горилла", "Лось")
    println("Animals before modifying")
    println(animals)

    fun removeByStreamSubstractTest( animals: List<String>): List<String> {
        val filter: List<String>  = animals
            .filter { !it.startsWith("Л") }

        return filter
    }
    animals = removeByStreamSubstractTest(animals)
    println("Animals after modifying")
    println(animals)
}

fun personMapTask() {

    val personList = listOf(
        Person(1L, "One", "English"),
        Person(2L, "Two", "Russian"),
        Person(3L, "Three", "French"),
        Person(4L, "Four", "Russian"),
        Person(5L, "Five", "Russian"),
        Person(6L, "Six", "English"),
        Person(7L, "Seven", "French")
    )
    println(personList)

   fun getPersonMapTest(personList: List<Person>, language: String) : Map<String, List<Person>> {
        val any = personList
            .groupBy(Person::language)
            .filter { it.key == language }
        return any
    }

    val personMap = getPersonMapTest(personList, "English")
    println("All persons with english")
    println(personMap)
}

fun mapWithCountFromStrKotlin() {
    val str: String = "Count words in this string with some words"

    val split: List<String> = str.split(" ")
    val groupBy: Map<String, List<String>> =
        split.groupBy { it }

    val mapValues: Map<String, Int> = groupBy.mapValues { it.value.size }
    println(mapValues)

    val eachCount:Map<String, Int>  = split
        .groupingBy { it }
        .eachCount()
    println(eachCount)
}

@OptIn(ExperimentalStdlibApi::class)
fun randomizeListLearningTestKotlin() {

    val list = listOf("One", "Two", "Three")

    fun getRandomizeList(list: List<String>, outputSize: Int): List<String> {
        val mutable: MutableList<String> = mutableListOf()
        val indexRange = 0..<list.size
        repeat(outputSize) {
            mutable.add(list[indexRange.random()])
        }
        return mutable.toList()
    }

    println(getRandomizeList(list, 3))
}

fun findDuplicateElementsKotlin() {
    fun findDuplicateTestKotlin(arr1: IntArray, arr2: IntArray): IntArray {
        val intersect = arr1.intersect(arr2.toSet())
        return intersect.toIntArray()
    }
    val arr1 = intArrayOf(1, 2, 2, 1)
    val arr2 = intArrayOf(2, 2)
    val answer1 = findDuplicateTestKotlin(arr1, arr2)
    println("Answer 1 : " + answer1.joinToString(" "))
    println("Expected 1 : " + "[2]")
    println()

    val arr3 = intArrayOf(4, 9, 5)
    val arr4 = intArrayOf(9, 4, 9, 8, 4)
    val answer2 = findDuplicateTestKotlin(arr3, arr4)
    println("Answer 2 : " + answer2.joinToString(" "))
    println("Expected 2 : " + "[9,4]")
    println("")


}

fun findFirstUniqueTestKotlin() {
    val nums1 = intArrayOf(9, 4, 9, 9, 6, 7, 5, 5)
    val nums2 = intArrayOf( 9, 8, 5, 7, 9, 8, 7, 1)
    fun findFirstUnique(nums: IntArray): Int {
        return nums
            .groupBy { it }  // Group elements by their values
            .filter { it.value.size == 1 }  // Keep only the groups with one element
            .keys  // Get the keys (unique elements)
            .firstOrNull() ?: throw NoSuchElementException("No unique element found")  // Return the first or throw an exception
    }
    println(findFirstUnique(nums1))
    println(findFirstUnique(nums2))
}

fun dividedIntoPresentAndAbsentTest() {
    val first = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val second = intArrayOf(10, 1, 5, 8, 9, 6, 3)
    val result = mapOf(
        "Present" to first.filter { it in second.toSet() },
        "Absent" to first.filter { it !in second.toSet() }
    )
    println(result)
}