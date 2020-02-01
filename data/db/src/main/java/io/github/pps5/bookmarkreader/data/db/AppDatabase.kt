package io.github.pps5.bookmarkreader.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.pps5.bookmarkreader.data.db.dao.EntryDao
import io.github.pps5.bookmarkreader.data.db.entity.*
import io.github.pps5.bookmarkreader.data.db.entity.converter.ZonedDateTimeConverter

@Database(
    entities = [
        Entry::class,
        HotEntry::class,
        HotEntryCrossRef::class
    ],
    version = 1
)
@TypeConverters(ZonedDateTimeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun entryDao(): EntryDao
}