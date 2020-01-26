package io.github.pps5.bookmarkreader.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.pps5.bookmarkreader.feature.entries.EntriesFragment

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeEntriesFragment(): EntriesFragment
}