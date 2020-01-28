package io.github.pps5.bookmarkreader.core

sealed class Result<T> {

    class Ok<T>(val value: T) : Result<T>() {
        override fun toString(): String {
            return "Ok(value=$value)"
        }
    }

    class Error<T>(val throwable: Throwable?) : Result<T>()

    inline fun onSuccess(block: (T) -> Unit) = apply {
        if (this is Ok<T>) {
            block(this.value)
        }
    }

    inline fun onFailure(block: (Throwable?) -> Unit) = apply {
        if (this is Error) {
            block(this.throwable)
        }
    }

    inline fun <R> fold(
        onSuccess: (T) -> R,
        onFailure: (Throwable?) -> R
    ): R = when (this) {
        is Ok -> onSuccess(this.value)
        is Error -> onFailure(this.throwable)
    }

}