package io.github.pps5.bookmarkreader.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.pps5.bookmarkreader.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(
        modules = [
            FragmentModule::class,
            MainActivityModule::class,
            NavigatorModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}