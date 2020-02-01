package io.github.pps5.bookmarkreader.data.db.entity

import androidx.room.*
import org.threeten.bp.ZonedDateTime

@Entity(tableName = "hot_entries")
data class HotEntry(
    @PrimaryKey
    val category: Int,
    val lastUpdatedTime: ZonedDateTime
)

@Entity(
    tableName = "hot_entry_cross_ref",
    primaryKeys = ["category", "entryId"]
)
data class HotEntryCrossRef(
    val category: Int,
    val entryId: Long
)

data class HotEntries(
    @Embedded
    val hotEntry: HotEntry,

    @Relation(
        parentColumn = "category",
        entityColumn = "entryId",
        associateBy = Junction(HotEntryCrossRef::class)
    )
    val entries: List<Entry>
)