package io.github.pps5.bookmarkreader.core.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber

inline fun <reified V : ViewModel?> create(
    crossinline block: () -> V
): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(V::class.java)) {
                Timber.d("Create new ${V::class.java.simpleName}")
                return block() as T
            }
            throw IllegalArgumentException(
                "$modelClass can't assignable from ${V::class.java.simpleName}"
            )
        }
    }
}