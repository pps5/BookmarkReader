package io.github.pps5.bookmarkreader.feature.entries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import io.github.pps5.bookmarkreader.core.repository.EntryRepository
import timber.log.Timber

@Module
class EntriesModule {

    @Provides
    fun provideViewModelFactory(
        entryRepository: EntryRepository
    ): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                if (modelClass.isAssignableFrom(EntriesViewModel::class.java)) {
                    Timber.d("Create new ${EntriesViewModel::class.java.simpleName}")
                    return EntriesViewModel(entryRepository) as T
                }
                throw IllegalArgumentException(
                    "$modelClass can't assignable from ${EntriesViewModel::class.java.simpleName}"
                )
            }

        }
    }

}