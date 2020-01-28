package io.github.pps5.bookmarkreader.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.pps5.bookmarkreader.feature.entries.EntriesFragment
import io.github.pps5.bookmarkreader.feature.entries.EntriesModule

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector(modules = [EntriesModule::class])
    abstract fun contributeEntriesFragment(): EntriesFragment
}