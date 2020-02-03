package io.github.pps5.bookmarkreader.feature.entries.bindingadapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import io.github.pps5.bookmarkreader.feature.entries.view.GlideApp

@BindingAdapter("bookmarkCount")
fun TextView.setBookmarkCount(count: Int) {
    val text = buildString {
        append(count)
        append(" users")
    }
    setText(text)
}

@BindingAdapter("thumbnail")
fun ImageView.setThumbnail(url: String?) {
    url?.let {
        GlideApp.with(this)
            .load(url)
            .centerCrop()
            .into(this)
    }
}