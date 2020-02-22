package io.github.pps5.bookmarkreader.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class Category(
    val title: String
): Parcelable {
    ALL("All"),
    SOCIAL("Social"),
    ECONOMICS("Economics"),
    LIFE("Life"),
    KNOWLEDGE("Knowledge"),
    TECHNOLOGY("IT"),
    ENTERTAINMENT("Entertainment"),
    ANIME_AND_GAME("Anime&Game"),
    FUN("Fun");

    companion object {
        fun fromTabIndex(index: Int): Category = values()[index]
    }
}