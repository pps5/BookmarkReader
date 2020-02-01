package io.github.pps5.bookmarkreader.data.db.entity.converter

import androidx.room.TypeConverter
import org.threeten.bp.Instant
import org.threeten.bp.ZoneOffset
import org.threeten.bp.ZonedDateTime

class ZonedDateTimeConverter {

    @TypeConverter
    fun fromLocalDateTime(value: ZonedDateTime?) =
        value?.toEpochSecond()

    @TypeConverter
    fun fromLong(value: Long?) =
        value?.let {
            ZonedDateTime.ofInstant(
                Instant.ofEpochSecond(it),
                ZoneOffset.systemDefault()
            )
        }
}