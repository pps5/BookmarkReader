package io.github.pps5.bookmarkreader.data.repository.mapper

import io.github.pps5.bookmarkreader.data.api.entity.Entries
import io.github.pps5.bookmarkreader.entity.Entry

internal fun Entries.toEntryList(): List<Entry> =
    items.map { item ->
        Entry(
            title = item.title,
            link = item.link,
            subjects = item.subjects?.map { it.name } ?: listOf(),
            imageUrl = item.imageUrl,
            bookmarkCount = item.bookmarkCount
        )
    }
