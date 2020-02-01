package io.github.pps5.bookmarkreader.data.db.entity

import androidx.room.*
import io.github.pps5.bookmarkreader.entity.IEntry

@Entity(tableName = "entries")
data class Entry(
    @PrimaryKey(autoGenerate = true)
    val entryId: Long = 0,
    override val title: String,
    override val link: String,
    override val imageUrl: String?,
    override val bookmarkCount: Int
): IEntry


