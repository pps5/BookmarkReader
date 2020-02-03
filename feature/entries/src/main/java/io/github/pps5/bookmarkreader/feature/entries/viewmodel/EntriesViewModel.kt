package io.github.pps5.bookmarkreader.feature.entries.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.github.pps5.bookmarkreader.core.Option
import io.github.pps5.bookmarkreader.core.Result
import io.github.pps5.bookmarkreader.core.repository.EntryRepository
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
            val EMPTY =
                Model(
                    isLoading = true,
                    entries = listOf(),
                    appError = Option.None()
                )
        }
    }

    val model: LiveData<Model> = liveData {
        emit(Model.EMPTY)
        val result = entryRepository.getHotEntries(
            Category.ALL,
            shouldFetch = { lastUpdated ->
                ZonedDateTime.now()
                    .isAfter(lastUpdated.plusMinutes(CACHE_MINUTE))
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
        emit(newModel)
    }
}
