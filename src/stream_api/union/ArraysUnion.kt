package stream_api.union

fun main() {
    fun mergeMultiplesArraysAsLists(vararg arrays: Array<String>): Array<String> {
        val res = arrays
            .flatMap { it.asList() }
            .toTypedArray()
        return res;
    }

    fun mergeMultipleArraysAsListsTest(vararg arrays: Array<String>): Array<String>? {

        return null
    }

    fun mergeMultiplesArraysByFlatten(vararg arrays: Array<String>): Array<String> {
        val arrayOf = arrayOf(* arrays)
        val flatten = arrayOf.flatten().toTypedArray()

        return flatten
    }

    fun mergeMultiplesArraysByFlattenTest(vararg arrays: Array<String>): Array<String>? {
        return null
    }
}