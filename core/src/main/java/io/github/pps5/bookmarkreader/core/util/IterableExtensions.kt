package io.github.pps5.bookmarkreader.core.util

fun <T, K, V> Iterable<T>.associateToHashMap(
    block: (T) -> Pair<K, V>
): HashMap<K, V> {
    return hashMapOf<K, V>()
        .apply {
            associateTo(this, block)
        }
}
