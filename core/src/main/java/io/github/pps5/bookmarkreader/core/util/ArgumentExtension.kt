package io.github.pps5.bookmarkreader.core.util

import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <F : Fragment, reified R : Any> args(key: String): ReadOnlyProperty<F, R> {
    return object : ReadOnlyProperty<F, R> {
        override fun getValue(thisRef: F, property: KProperty<*>): R {
            val value = thisRef.requireArguments().get(key)
            if (value == null) {
                throw IllegalArgumentException("$thisRef doesn't have argument for key '$key'")
            } else if (value !is R) {
                throw IllegalArgumentException(
                    "$thisRef have argument for key '$key', but the value isn't type of ${R::class}"
                )
            }
            return value
        }
    }
}
