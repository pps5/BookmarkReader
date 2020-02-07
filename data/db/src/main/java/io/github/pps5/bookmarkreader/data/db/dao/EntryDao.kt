package io.github.pps5.bookmarkreader.data.db.dao

import androidx.room.*
import io.github.pps5.bookmarkreader.data.db.entity.HotEntries
import io.github.pps5.bookmarkreader.data.db.entity.HotEntry
import io.github.pps5.bookmarkreader.data.db.entity.HotEntryCrossRef
import io.github.pps5.bookmarkreader.entity.IEntry
import org.threeten.bp.ZonedDateTime
import io.github.pps5.bookmarkreader.data.db.entity.Entry as DBEntry

@Dao
abstract class EntryDao {

    @Transaction
    @Query("SELECT * FROM hot_entries WHERE category = :category")
    abstract fun getHotEntries(category: Int): HotEntries?

    @Transaction
    open fun insertHotEntry(
        category: Int,
        entries: List<IEntry>
    ) {
        val entryIds = insertEntries(entries)
        val hotEntry = HotEntry(
            category = category,
            lastUpdatedTime = ZonedDateTime.now()
        )
        _insertHotEntry(hotEntry)
        val crossRefs = entryIds
            .map { entryId -> HotEntryCrossRef(category, entryId) }
        insertHotEntryCrossRef(crossRefs)
    }

    @Transaction
    open fun insertEntries(entries: List<IEntry>): List<Long> {
        val entriesToInsert = entries.map {
            DBEntry(
                title = it.title,
                link = it.link,
                imageUrl = it.imageUrl,
                bookmarkCount = it.bookmarkCount
            )
        }
        return _insertEntries(entriesToInsert)
    }

    @Delete
    abstract fun deleteEntries(entries: List<DBEntry>)

    @Suppress("FunctionName")
    @Insert
    protected abstract fun _insertEntries(entries: List<DBEntry>): List<Long>

    @Suppress("FunctionName")
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract fun _insertHotEntry(hotEntry: HotEntry)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    protected abstract fun insertHotEntryCrossRef(crossRefs: List<HotEntryCrossRef>)
}