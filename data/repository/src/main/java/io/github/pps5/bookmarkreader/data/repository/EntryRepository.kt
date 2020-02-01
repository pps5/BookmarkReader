package io.github.pps5.bookmarkreader.data.repository

import io.github.pps5.bookmarkreader.core.Result
import io.github.pps5.bookmarkreader.data.api.FeedClient
import io.github.pps5.bookmarkreader.data.db.AppDatabase
import io.github.pps5.bookmarkreader.data.repository.mapper.toFeedCategory
import io.github.pps5.bookmarkreader.entity.Category
import io.github.pps5.bookmarkreader.entity.IEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.threeten.bp.ZonedDateTime
import timber.log.Timber
import javax.inject.Inject
import io.github.pps5.bookmarkreader.core.repository.EntryRepository as IEntryRepository

class EntryRepository @Inject constructor(
    private val feedClient: FeedClient,
    private val appDatabase: AppDatabase
) : IEntryRepository {

    override suspend fun getHotEntries(
        category: Category,
        shouldFetch: (ZonedDateTime) -> Boolean
    ): Result<out List<IEntry>> = withContext(Dispatchers.IO) {
        val dao = appDatabase.entryDao()
        runCatching {
            val feedCategory = category.toFeedCategory()
            val dbResult = dao.getHotEntries(feedCategory.id)
            if (dbResult == null || shouldFetch(dbResult.hotEntry.lastUpdatedTime)) {
                val entries = feedClient
                    .getHotEntries(feedCategory)
                    .items
                dao.insertHotEntry(
                    feedCategory.id,
                    entries
                )
                entries
            } else {
                dbResult.entries
            }
        }
            .fold(
                onSuccess = { Result.Ok(it) },
                onFailure = {
                    Timber.e(it)
                    Result.Error<List<IEntry>>(it)
                }
            )
    }
}