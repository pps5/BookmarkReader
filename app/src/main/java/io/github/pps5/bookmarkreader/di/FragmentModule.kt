package io.github.pps5.bookmarkreader.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.pps5.bookmarkreader.core.di.scope.FragmentScope
import io.github.pps5.bookmarkreader.feature.entries.fragment.EntriesFragment
import io.github.pps5.bookmarkreader.feature.entries.di.EntriesModule
import io.github.pps5.bookmarkreader.feature.home.HomeFragment
import io.github.pps5.bookmarkreader.feature.home.di.HomeModule

@Module
abstract class FragmentModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [EntriesModule::class])
    abstract fun contributeEntriesFragment(): EntriesFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeFragment(): HomeFragment
}