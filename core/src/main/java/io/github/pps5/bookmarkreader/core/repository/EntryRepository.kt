package io.github.pps5.bookmarkreader.core.repository

import io.github.pps5.bookmarkreader.core.Result
import io.github.pps5.bookmarkreader.entity.Category
import io.github.pps5.bookmarkreader.entity.IEntry
import org.threeten.bp.ZonedDateTime

interface EntryRepository {
    suspend fun getHotEntries(
        category: Category,
        shouldFetch: (ZonedDateTime) -> Boolean
    ): Result<out List<IEntry>>
}