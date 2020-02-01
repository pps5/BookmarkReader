package io.github.pps5.bookmarkreader.entity

interface IEntry {
    val title: String
    val link: String
    val imageUrl: String?
    val bookmarkCount: Int
}

