package io.github.pps5.bookmarkreader.core.repository

import io.github.pps5.bookmarkreader.core.Result
import io.github.pps5.bookmarkreader.entity.Category
import io.github.pps5.bookmarkreader.entity.Entry

interface EntryRepository {
    suspend fun getHotEntries(category: Category): Result<List<Entry>>
}