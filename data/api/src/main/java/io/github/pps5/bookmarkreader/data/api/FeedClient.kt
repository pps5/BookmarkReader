package io.github.pps5.bookmarkreader.data.api

import io.github.pps5.bookmarkreader.core.Result
import io.github.pps5.bookmarkreader.data.api.entity.FeedCategory
import io.github.pps5.bookmarkreader.data.api.entity.Entries
import io.github.pps5.bookmarkreader.entity.Entry
import retrofit2.http.GET
import retrofit2.http.Path

interface FeedClient {

    @GET("hotentry/{category}.rss")
    suspend fun getHotEntries(
        @Path("category") category: FeedCategory
    ): Entries

    @GET("entrylist/{category}.rss")
    fun getNewEntries(
        @Path("category") category: FeedCategory
    ): Result<List<Entry>>
}
