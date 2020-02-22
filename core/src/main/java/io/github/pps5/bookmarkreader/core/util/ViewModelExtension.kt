package io.github.pps5.bookmarkreader.core.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

inline fun <V : ViewModel, T : Any, L : Any> V.mapLiveDataInViewModelScope(
    initialValue: T,
    trigger: LiveData<L>,
    crossinline block: suspend (T, L) -> T
): LiveData<T> {
    return MediatorLiveData<T>().apply {
        value = initialValue
        addSource(trigger) {
            viewModelScope.launch {
                value = block(value!!, it)
            }
        }
    }
}
