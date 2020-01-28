package io.github.pps5.bookmarkreader.core

sealed class Option<T> {

    class Some<T>(val value: T) : Option<T>()
    class None<T> : Option<T>()

    companion object {
        fun <T> apply(value: T?) =
            if (value == null) None<T>() else Some(value)
    }
}