package stream_api.union

fun main() {
    fun mergeMultiplesArraysAsLists(vararg arrays: Array<String>): Array<String> {
        val res = arrays
            .flatMap { it.asList() }
            .toTypedArray()
        return res;
    }

    fun mergeMultiplesArraysByFlatten(vararg arrays: Array<String>): Array<String> {
        val arrayOf = arrayOf(* arrays)
        val flatten = arrayOf.flatten().toTypedArray()

        return flatten
    }
}