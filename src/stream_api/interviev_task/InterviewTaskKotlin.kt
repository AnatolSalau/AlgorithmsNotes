package stream_api.interviev_task

import stream_api.interviev_task.InterviewTask.Person


fun main() {
    //getAllWordsWithDuplicates()
    //removeAllAnimalsFromL()
    //personMapTask()
    mapWithCountFromStrKotlin()
}

/*
      18. Дано несколько списков слов. Получить список всех слов с этих списков
      c дубликатами
            Hello World World wide Java Stream API Java one love
      без дубликатов
            Hello World wide Java Stream API love
 */
fun getAllWordsWithDuplicates() {
    val sentences1: List<String> = listOf("Hello World", "World wide");
    val sentences2: List<String> = listOf("Java Stream API", "Java one love");

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
    var animals: List<String> = ArrayList(java.util.List.of("Тигр", "Лев", "Горилла", "Лось"))
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

    val personList = java.util.List.of(
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