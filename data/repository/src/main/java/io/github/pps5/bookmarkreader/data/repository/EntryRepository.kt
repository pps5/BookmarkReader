package io.github.pps5.bookmarkreader.data.repository

import io.github.pps5.bookmarkreader.core.Result
import io.github.pps5.bookmarkreader.data.api.FeedClient
import io.github.pps5.bookmarkreader.data.repository.mapper.toEntryList
import io.github.pps5.bookmarkreader.data.repository.mapper.toFeedCategory
import io.github.pps5.bookmarkreader.entity.Category
import io.github.pps5.bookmarkreader.entity.Entry
import javax.inject.Inject
import io.github.pps5.bookmarkreader.core.repository.EntryRepository as IEntryRepository

class EntryRepository @Inject constructor(
    private val feedClient: FeedClient
) : IEntryRepository {

    override suspend fun getHotEntries(
        category: Category
    ): Result<List<Entry>> {
        return runCatching { feedClient.getHotEntries(category.toFeedCategory()) }
            .fold(
                onSuccess = { Result.Ok(it.toEntryList()) },
                onFailure = { Result.Error(it) }
            )
    }

}