package io.github.pps5.bookmarkreader.data.api.entity

enum class FeedCategory(
    val path: String
) {
    ALL("all");

    override fun toString(): String =
        path
}

