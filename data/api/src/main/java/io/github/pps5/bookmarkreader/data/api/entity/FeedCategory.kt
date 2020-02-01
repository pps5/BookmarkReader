package io.github.pps5.bookmarkreader.data.api.entity

enum class FeedCategory(
    val id: Int,
    val path: String
) {
    ALL(1, "all"),
    SOCIAL(2, "social"),
    ECONOMICS(3, "economics"),
    LIFE(4, "life"),
    KNOWLEDGE(5, "knowledge"),
    TECHNOLOGY(6, "it"),
    ENTERTAINMENT(7, "entertainment"),
    ANIME_AND_GAME(8, "game"),
    FUN(9, "fun");

    override fun toString(): String =
        path
}

