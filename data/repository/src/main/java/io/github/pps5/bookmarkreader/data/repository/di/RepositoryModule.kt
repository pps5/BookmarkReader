package io.github.pps5.bookmarkreader.data.repository.di

import dagger.Module
import dagger.Provides
import io.github.pps5.bookmarkreader.data.api.FeedClient
import io.github.pps5.bookmarkreader.data.repository.EntryRepository
import javax.inject.Singleton
import io.github.pps5.bookmarkreader.core.repository.EntryRepository as IEntryRepository

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideEntryRepository(
        feedClient: FeedClient
    ): IEntryRepository =
        EntryRepository(feedClient)
}