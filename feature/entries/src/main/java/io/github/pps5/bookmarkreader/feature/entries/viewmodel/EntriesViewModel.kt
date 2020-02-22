package io.github.pps5.bookmarkreader.feature.entries.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.pps5.bookmarkreader.core.Option
import io.github.pps5.bookmarkreader.core.Result
import io.github.pps5.bookmarkreader.core.repository.EntryRepository
import io.github.pps5.bookmarkreader.core.util.mapLiveDataInViewModelScope
import io.github.pps5.bookmarkreader.entity.AppError
import io.github.pps5.bookmarkreader.entity.Category
import io.github.pps5.bookmarkreader.entity.IEntry
import org.threeten.bp.ZonedDateTime


class EntriesViewModel(
    private val entryRepository: EntryRepository
) : ViewModel() {

    companion object {
        private const val CACHE_MINUTE = 100L
    }

    data class Model(
        val isLoading: Boolean,
        val entries: List<IEntry>,
        val appError: Option<AppError>
    ) {
        companion object {
            val EMPTY = Model(
                isLoading = true,
                entries = listOf(),
                appError = Option.None()
            )
        }
    }

    private val category = MutableLiveData<Category>()

    @MainThread
    fun setCategory(category: Category){
       this.category.value = category
    }

    val model: LiveData<Model> = mapLiveDataInViewModelScope(
        initialValue = Model.EMPTY,
        trigger = category
    ) { _: Model, category: Category ->
        val result = entryRepository.getHotEntries(
            category,
            shouldFetch = { lastUpdated ->
                val cacheLimit = lastUpdated.plusMinutes(CACHE_MINUTE)
                ZonedDateTime.now().isAfter(cacheLimit)
            }
        )
        val newModel = when (result) {
            is Result.Ok ->
                Model(
                    isLoading = false,
                    entries = result.value,
                    appError = Option.None()
                )
            is Result.Error ->
                Model(
                    isLoading = false,
                    entries = listOf(),
                    appError = Option.apply(AppError(result.throwable))
                )
        }
        newModel
    }
}
