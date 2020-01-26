package io.github.pps5.bookmarkreader.entity

data class Entry(
    val title: String,
    val link: String,
    val subjects: List<String>,
    val imageUrl: String?,
    val bookmarkCount: Int
)

