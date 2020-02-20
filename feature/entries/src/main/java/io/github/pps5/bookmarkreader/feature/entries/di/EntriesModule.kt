package io.github.pps5.bookmarkreader.feature.entries.di

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import io.github.pps5.bookmarkreader.core.repository.EntryRepository
import io.github.pps5.bookmarkreader.core.util.create
import io.github.pps5.bookmarkreader.feature.entries.viewmodel.EntriesViewModel

@Module
class EntriesModule {

    @Provides
    fun provideViewModelFactory(
        entryRepository: EntryRepository
    ): ViewModelProvider.Factory =
        create {
            EntriesViewModel(
                entryRepository
            )
        }

}