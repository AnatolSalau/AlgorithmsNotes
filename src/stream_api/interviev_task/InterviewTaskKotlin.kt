package stream_api.interviev_task

fun main() {
    getAllWordsWithDuplicates()
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
