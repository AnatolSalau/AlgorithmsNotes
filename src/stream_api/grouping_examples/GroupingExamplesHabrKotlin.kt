package stream_api.grouping_examples

import stream_api.grouping_examples.GroupingExamplesHabr.Worker
import stream_api.grouping_examples.GroupingExamplesHabr.workerList
import java.util.ListResourceBundle

fun main(args: Array<String>) {
    //groupByPositionBySetTest(workerList)
    countingByPositionLongTest(workerList)
    countingByPositionIntegerTest(workerList)
    groupByPositionOnlyNames(workerList)
    calculatePositionsWithAverageSalaryTest(workerList)
    groupingPositionsBySingleStringTest(workerList)
}

internal fun groupByPositionBySetTest(workers: List<Worker>): Map<String, Set<Worker>> {
    val map: Map<String, Set<Worker>>  = workers
        .groupBy { it.position }
        .mapValues { entry -> entry.value.toSet() }
    println(map)
    return mapOf()
}

internal fun countingByPositionLongTest(workers: List<Worker>): Map<Long, List<Worker>> {
    val workersGroupByPosition: Map<Long, List<Worker>> = workers
        .groupBy{ it.position}
        .mapKeys { it.value.count().toLong()}
    return workersGroupByPosition
}

internal fun countingByPositionIntegerTest(workers: List<Worker>): Map<List<Worker>, Int> {
    return workers
        .groupBy { it.position }
        .mapKeys { it.value }
        .mapValues { it.value.count() }
}

internal fun groupByPositionOnlyNames(workers: List<Worker>): Map<String, Set<String>> {
    val mapValues = workers
        .groupBy ( {it.position}, {it.name})
        .mapValues { it.value.toSet() }

    return mapValues
}

internal fun calculatePositionsWithAverageSalaryTest(workers: List<Worker>): Map<String, Double> {
    val mapStringInt: Map<String, List<Int>> =  workers
        .groupBy({it.position}, {it.salary})

    val mapValues: Map<String, Double> = mapStringInt.mapValues { it.value.average() }

    return mapValues
}

internal fun groupingPositionsBySingleStringTest(workers: List<Worker>): Map<String, String> {
    val join: Map<String, String> =
    workers
        .groupBy(Worker::getPosition, Worker::getName)
        .mapValues { it.value.joinToString(",") }
    return join
}