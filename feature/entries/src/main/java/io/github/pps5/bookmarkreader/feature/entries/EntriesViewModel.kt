package io.github.pps5.bookmarkreader.feature.entries

import androidx.lifecycle.*
import io.github.pps5.bookmarkreader.core.Option
import io.github.pps5.bookmarkreader.core.repository.EntryRepository
import io.github.pps5.bookmarkreader.entity.AppError
import io.github.pps5.bookmarkreader.entity.Category
import io.github.pps5.bookmarkreader.entity.Entry


class EntriesViewModel(
    private val entryRepository: EntryRepository
) : ViewModel() {

    data class Model(
        val isLoading: Boolean,
        val entries: List<Entry>,
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

    val model: LiveData<Model> = liveData {
        emit(Model.EMPTY)
        val newModel = entryRepository.getHotEntries(Category.ALL)
            .fold(
                onSuccess = {
                    Model(
                        isLoading = false,
                        entries = it,
                        appError = Option.None()
                    )
                },
                onFailure = {
                    Model(
                        isLoading = false,
                        entries = listOf(),
                        appError = Option.apply(AppError(it))
                    )
                }
            )
        emit(newModel)
    }
}
