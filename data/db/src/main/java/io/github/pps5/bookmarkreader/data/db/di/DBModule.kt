package io.github.pps5.bookmarkreader.data.db.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.github.pps5.bookmarkreader.data.db.AppDatabase
import javax.inject.Singleton

private const val dbName = "app_database"

@Module
class DBModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        context: Context
    ) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            dbName
        ).build()
}