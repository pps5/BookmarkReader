package io.github.pps5.bookmarkreader.data.api.entity

enum class FeedCategory(
    val path: String
) {
    ALL("all"),
    SOCIAL("social"),
    ECONOMICS("economics"),
    LIFE("life"),
    KNOWLEDGE("knowledge"),
    TECHNOLOGY("it"),
    ENTERTAINMENT("entertainment"),
    ANIME_AND_GAME("game"),
    FUN("fun");

    override fun toString(): String =
        path
}

