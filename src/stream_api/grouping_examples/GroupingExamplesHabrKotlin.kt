package stream_api.grouping_examples

import stream_api.grouping_examples.GroupingExamplesHabr.Worker
import stream_api.grouping_examples.GroupingExamplesHabr.workerList

fun main(args: Array<String>) {
    //groupByPositionBySetTest(workerList)
    countingByPositionLongTest(workerList)
}

internal fun groupByPositionBySetTest(workers: List<Worker>): Map<String, Set<Worker>> {
    val map: Map<String, Set<Worker>>  = workers
        .groupBy { it.position }
        .mapValues { entry -> entry.value.toSet() }
    println(map)
    return mapOf()
}

internal fun countingByPositionLongTest(workers: List<Worker>): Map<String, Long> {
    val eachCount: Map<String, Long> = workers
        .groupingBy { it.position }
        .eachCount()
        .mapValues { it.value.toLong() }
    return mapOf()
}