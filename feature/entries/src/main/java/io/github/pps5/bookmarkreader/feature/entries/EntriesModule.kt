package io.github.pps5.bookmarkreader.feature.entries

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import io.github.pps5.bookmarkreader.core.di.scope.FragmentScope
import io.github.pps5.bookmarkreader.core.repository.EntryRepository
import io.github.pps5.bookmarkreader.core.util.create

@Module
class EntriesModule {

    @FragmentScope
    @Provides
    fun provideViewModelFactory(
        entryRepository: EntryRepository
    ): ViewModelProvider.Factory =
        create { EntriesViewModel(entryRepository) }

}