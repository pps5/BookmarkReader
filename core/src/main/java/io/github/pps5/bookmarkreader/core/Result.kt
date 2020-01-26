package io.github.pps5.bookmarkreader.core

sealed class Result<T> {
    class Ok<T>(val value: T) : Result<T>() {
        override fun toString(): String {
            return "Ok(value=$value)"
        }
    }
    class Error<T> : Result<T>()

    inline fun onSuccess(block: (T) -> Unit) = apply {
        if (this is Ok<T>) {
            block(this.value)
        }
    }

    inline fun onFailure(block: () -> Unit) = apply {
        if (this is Error) {
            block()
        }
    }

}